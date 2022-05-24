package classes;

import classes.data.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class User  implements Serializable {
    private String nick;

    private transient boolean online;
    @JsonIgnore
    private String key;
    @JsonIgnore
    private transient int count;


    @JsonIgnore
    private transient Thread thread;

    public String getNick() {
        return nick;
    }

    public String getKey() {
        return key;
    }

    public Boolean getOnline() {
        return online;
    }

    public User(String nick) {
        this.nick = nick;
        key = Users.us.getCounter() + nick;
        newThread();
        setStatus();
    }

    public void setStatus() {
        count = 30;
        online = true;
        try {
            if(thread.isInterrupted()||!thread.isAlive())
            thread.start();
        }catch (Exception e){
            online = false;
            newThread();
            System.out.println(e.getMessage()+online);
        }
    }

    private void newThread(){
        thread = new Thread(() -> {
            while (online)
                try {
                    Thread.sleep(1000);
                    count--;
                    if (count <= 0) {
                        online = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }, "userOnline");
    }

    @Override
    public String toString() {
        return nick+ "%%" +key;

    }
}

