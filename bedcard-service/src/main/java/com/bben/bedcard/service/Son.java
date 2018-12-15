package com.bben.bedcard.service;

public class Son extends Parent{
    public Son(String abc) {
        super(abc);
    }

    public static void main(String[] args) {
        final ddd dd = new ddd();
        System.out.println("111");
        dd.setId("5555");
        System.out.println(dd.getId());
    }

    static class ddd {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String id;

    }

}

