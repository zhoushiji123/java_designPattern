package com.zsj.adapter;

/**
 * Created by zsj on 2017/5/5.
 * 插口适配器
 */
public class OutletAdapter implements ThreeOutlet {

    private  TwoOutlet twoOutlet;  //被适配者是适配器的成员变量

    public OutletAdapter (TwoOutlet twoOutlet){  //通过构造函数获得 被适配者的实例
        this.twoOutlet =twoOutlet;
    }

    public void connect() {   //执行功能
        twoOutlet.connect();
    }
}
