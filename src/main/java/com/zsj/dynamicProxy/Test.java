package com.zsj.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zsj on 2017/5/5.
 */
public class Test {

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

        SubProxy handler = new SubProxy(subjectImpl);

        Subject subject = (Subject) handler.getProxy();

        subject.execute();


    }
}
