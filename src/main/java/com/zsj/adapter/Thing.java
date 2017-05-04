package com.zsj.adapter;

/**
 * Created by zsj on 2017/5/5.
 */
public class Thing implements TwoOutlet {


    public void connect() {
        this.start();
    }


    private  void start(){
        System.out.println("2口充电器连接成功，开始工作");
    }
}
