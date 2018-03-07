package com.link.entity;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 10:43
 */
public class InheritTest {

    public static void main(String[] args) {
        B b = new B();
        b.setName("ddd");
        b.setTitle("ddc");
        b.setBrd("343");

        A a;
        a= b;
        System.out.println(a.getName()+a.getTitle());
        B b0 = (B)a;
        System.out.println(b0.getBrd());
    }
}
