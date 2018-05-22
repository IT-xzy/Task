package com.longhang.myAnnotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) //表明该注解对成员方法起作用
@Retention(RetentionPolicy.RUNTIME) //在编译以后仍然起作用
@Documented //支持JavaDoc文档注释
public @interface MyAnno {
}
