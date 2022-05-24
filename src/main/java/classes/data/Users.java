package classes.data;

import classes.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Users{
    private HashMap<String, User> users;
    private int counter;
    public static Users us;
public ObjectMapper mapper;

    public Users(HashMap<String, User> users) {
        this.users = users;
        counter = users.size();
        us = this;
        mapper = new ObjectMapper();

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

    public String getUsersJson() throws JsonProcessingException {
        String s = mapper.writeValueAsString(users.values());
        System.out.println(s);

        return s;
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