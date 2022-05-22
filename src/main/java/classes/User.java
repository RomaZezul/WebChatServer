package classes;

import classes.data.Users;

import java.io.Serializable;

public class User  implements Serializable {
    private String nick;
    private boolean onLine;
    private String key;
    private transient int count;
    private transient Thread thread;

    public String getNick() {
        return nick;
    }

    public String getKey() {
        return key;
    }

    public User(String nick) {
        this.nick = nick;
        key = Users.us.getCounter() + nick;
        thread = new Thread(() -> {
            while (onLine)
                try {
                    Thread.sleep(1000);
                    count--;
                    if (count <= 0) {
                        onLine = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }, "userOnline");
        setStatus();
    }

    public void setStatus() {
        count = 30;
        onLine = true;
        try {
            thread.start();
        }catch (Exception e){

        }
    }

    public String isOnLine() {

        return onLine?"ONLINE":"DISCONNECT";
    }

    @Override
    public String toString() {
        return nick+ "%%" +key;

    }
}

