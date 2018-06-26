package com.ssm.controller;

import com.aliyun.oss.model.OSSObjectSummary;
import com.ssm.utils.AliyunConvertUtil;
import com.ssm.utils.QiniuConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


@Controller
public class DataMigrationController {

    @Autowired
    private QiniuConvertUtil qiniuConvertUtil;

    @Autowired
    private AliyunConvertUtil aliyunConvertUtil;

    @RequestMapping(value = "/migration/qiniu", method = RequestMethod.POST)
    @ResponseBody
    public String qiniuToOSS() throws IOException {
        List<String> fileNameList = QiniuConvertUtil.getListOfQiniu(qiniuConvertUtil.getAk(), qiniuConvertUtil.getSk());
        for (String fileName : fileNameList) {
            QiniuConvertUtil.uploadToOSS(qiniuConvertUtil.getOssAK(),qiniuConvertUtil.getOssSK(),fileName);
        }
        return "data migrate to aliyun successful !";
    }

    @RequestMapping(value = "/migration/aliyun", method = RequestMethod.POST)
    @ResponseBody
    public String ossToQiniu() {
        List<OSSObjectSummary> fileNameList = AliyunConvertUtil.getListOfAliyun(aliyunConvertUtil.getOssAK(), aliyunConvertUtil.getOssSK());
        for (OSSObjectSummary summary : fileNameList) {
            AliyunConvertUtil.uploadToQiniu(aliyunConvertUtil.getAk(), aliyunConvertUtil.getSk(), summary.getKey());
        }
        return "data migrate to qiniu successful !";
    }

}
