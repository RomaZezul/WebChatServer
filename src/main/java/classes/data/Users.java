package classes.data;

import classes.User;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private final Map<String, User> users;
    private int counter;
    public static Users us;

    public Users() {
        counter = 0;
        users = new HashMap<String, User>() {
        };
        us = this;
    }

    public User getUser( String k) {
        return  users.get(k.trim());
    }
    public User setUser(String n) {
        User user = new User(n);
        users.put(user.getKey().trim(), user);
        return user;
    }

    public String getCounter() {
        return String.valueOf(++counter);
    }

}