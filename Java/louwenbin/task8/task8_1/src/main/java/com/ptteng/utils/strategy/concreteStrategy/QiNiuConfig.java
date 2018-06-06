package com.ptteng.utils.strategy.concreteStrategy;

import com.ptteng.utils.qiniuyunAPI.QiNiuYunImage;
import com.ptteng.utils.strategy.QiNiuOrALi;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class QiNiuConfig implements QiNiuOrALi {
    @Resource
    private QiNiuYunImage qiNiuYunImage;

    @Override
    public void convert(String name, InputStream inputStream) throws IOException {
        //上传到七牛云
        qiNiuYunImage.upload(name,inputStream);
        //迁移到阿里云
        qiNiuYunImage.corsQiNiu();
    }
}
