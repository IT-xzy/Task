package com.jnshu.entity;

import java.io.Serializable;

/**
     * @author lxk on 2017/11/1
     */
    public class FlyPig implements Serializable {
        private static final long serialVersionUID = 1L;
        private static String AGE = "26";
        private String name;
        private String color;
        transient private String car;
        private  String addTip = "BMW";

        //private String addTip;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }

        //public String getAddTip() {
        //    return addTip;
        //}
        //
        //public void setAddTip(String addTip) {
        //    this.addTip = addTip;
        //}

        @Override
        public String toString() {
            return "FlyPig{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", car='" + car + '\'' +
                    ", AGE='" + AGE + '\'' +
                    //", addTip='" + addTip + '\'' +
                    '}';
        }
    }
