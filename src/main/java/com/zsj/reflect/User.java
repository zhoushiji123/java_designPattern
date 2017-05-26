package com.zsj.reflect;

/**
 * Created by zsj on 2017/5/26.
 */
public class User implements MyInterface {

    private int id;
    private String username;


    public User(){

    }

    public User(int id,String username){
        this.id = id;
        this.username = username;
    }


    public void execute() {
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
