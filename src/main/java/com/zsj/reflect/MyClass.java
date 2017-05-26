package com.zsj.reflect;


/**
 * Created by zsj on 2017/5/26.
 */
public class MyClass implements MyInterface {

    public MyClass(){

    }

    @Override
    public void execute(){
        System.out.println(" it is myclass");
    }



    public void execute(int id ,String name){
        System.out.println(id+" "+name);
    }

    public void execute(String name){
        System.out.println(name);
    }
}
