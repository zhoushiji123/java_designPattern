package com.zsj.adapter;

/**
 * Created by zsj on 2017/5/5.
 */
public class Main {
    public static void main(String[] args) {
        TwoOutlet thing = new Thing();
        OutletAdapter outletAdapter = new OutletAdapter(thing);
        outletAdapter.connect();
    }
}
