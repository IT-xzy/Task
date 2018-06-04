package com.ptteng.utils.strategy.concreteStrategy;

import com.ptteng.utils.aliyunAPI.HelloOSS;
import com.ptteng.utils.strategy.QiNiuOrALi;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class ALiConfig implements QiNiuOrALi {
    @Resource
    private HelloOSS helloOSS;

    @Override
    public void convert(String name, InputStream inputStream) throws IOException {
        //上传到阿里云
        helloOSS.upImage(name,inputStream);
        //迁移到七牛云
        helloOSS.corsALi();
    }
}
