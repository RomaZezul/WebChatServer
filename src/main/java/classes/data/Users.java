package classes.data;

import classes.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Users implements Serializable{
    private HashMap<String, User> users;
    private transient int counter;
    public transient static Users us;

    public Users(HashMap<String, User> users) {
        this.users = users;
        counter = users.size();
        us = this;
    }

    public User getUser( String k) {
        return  users.get(k.trim());
    }
    public User setUser(String n) {
        User user = new User(n);
        users.put(user.getKey().trim(), user);
        saveUsers();
        return user;
    }

    public List<String> getOnlineInfo(){
        List<String> map = new ArrayList<>();
        for (User u:users.values()) {
            map.add(u.getNick()+ "   ->   " +u.isOnLine());
        }
        return map;
    }

    public String getCounter() {
        return String.valueOf(++counter);
    }

    public void saveUsers() {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Users.dat")))
        {
            oos.writeObject(users);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}