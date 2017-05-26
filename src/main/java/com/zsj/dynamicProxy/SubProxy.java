package com.zsj.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zsj on 2017/5/5.
 * 动态代理类
 * 步骤：
 * 1.实现InvocationHandler接口，重写invoke方法。
 * 2.要代理的对象以"成员变量"的方式在动态代理类中，以构造方法的方式赋值。
 */
public class SubProxy implements InvocationHandler{

    private Object target ;

    public SubProxy(Object target){
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args);
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }


}
