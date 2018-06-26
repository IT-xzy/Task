package com.ptteng.utils.strategy.concreteStrategy;

import com.ptteng.utils.strategy.QiNiuOrALi;

import java.io.IOException;
import java.io.InputStream;

public class Context {
    private QiNiuOrALi qiNiuOrALi;

    public Context() {
    }

    //构造函数，传入一个具体策略对象
    public Context(QiNiuOrALi qiNiuOrALi) {
        this.qiNiuOrALi = qiNiuOrALi;
    }

    public Context(ALiConfig aLiConfig, QiNiuConfig qiNiuConfig) {
    }

    //策略方法
    public void operate(String name, InputStream inputStream) throws IOException {
        this.qiNiuOrALi.convert(name, inputStream);
    }
}
