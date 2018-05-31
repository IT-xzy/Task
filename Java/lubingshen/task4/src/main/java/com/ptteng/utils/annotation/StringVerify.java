package com.ptteng.utils.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//自定义注释的优点在于灵活，可以自定义一些特殊配置，但本次示例明显功能不足
//javax.validation.constraints包提供了更加强大的注释功能
//详情可见Spring实战（第四版）第五章
public @interface StringVerify {

    //boolean isNotNull() default true;

    //boolean isNotBlank() default true;

    //boolean isNumber() default false;

    //boolean isNotIllegal() default true;

    //boolean isDefault() default false;

    //......

    String aliasName() default "某个";

    int maxLength() default 95;

    int minLength() default 0;

}
