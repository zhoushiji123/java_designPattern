package com.zsj.reflect;

/**
 * Created by zsj on 2017/5/26.
 */
public class Test1 {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.zsj.reflect.MyClass");

            MyClass myclass = (MyClass) c.newInstance();
            myclass.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e2){
            e2.printStackTrace();
        }catch (InstantiationException e3){
            e3.printStackTrace();
        }
    }
}
