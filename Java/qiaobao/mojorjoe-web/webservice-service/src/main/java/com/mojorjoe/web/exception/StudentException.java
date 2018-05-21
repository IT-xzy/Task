package com.mojorjoe.web.exception;



    public class StudentException extends Exception {

        /**
         * 自定义异常信息
         */

        //异常信息
        public String message;
        //重写构造方法
        public StudentException(String message) {

            //这句话的意思是调用Exception的有参构造方法。
            super(message);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

