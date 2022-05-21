package classes;

import classes.data.Users;

public class User {
    private String nick;
    private boolean onLine;
    private String key;
    private int count;
    private Thread thread;

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
        if (thread.isInterrupted()) {
            thread.start();
        }
    }

    public boolean isOnLine() {
        return onLine;
    }

    @Override
    public String toString() {
        return nick+ "%%" +key;

    }
}

