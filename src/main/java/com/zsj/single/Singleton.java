package com.zsj.single;

/**
 * Created by zsj on 2017/5/26.
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    public Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}
