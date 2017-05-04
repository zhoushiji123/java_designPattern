package com.zsj.proxy;

/**
 * Created by zsj on 2017/5/5.
 * 静态代理  代理类
 */
public class Proxy {

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    private void request(){
        subject.execute();  //执行代理客户的操作
    }
}
