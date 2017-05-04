package com.zsj.dynamicProxy;

/**
 * Created by zsj on 2017/5/5.
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Proxy proxy = new Proxy(subject);

    }
}
