package com.zsj.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zsj on 2017/5/5.
 * 动态代理 代理类
 */
public class Proxy implements InvocationHandler{

    private Object target ;

    public Proxy(Object target){
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = method.invoke(target,args);
        return object;
    }



//    public Object getProxy(){
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Class<?>[] interfaces = target.getClass().getInterfaces();
//        return Proxy.newProxyInstance(loader, interfaces, this);
//    }
}
