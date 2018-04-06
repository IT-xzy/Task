package com.jnshu.tactics;
import com.jnshu.service.Impl.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class migrationContext {
    private Logger logger = Logger.getLogger(migrationContext.class);
    private Strategy strategy;
    @Resource
    private StudentServiceImpl studentService;

    public migrationContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public String migrationUp() throws IOException {
        return strategy.migration();
    }

    public String fileUpload(String filename, InputStream inputStream) throws IOException {
        return strategy.fileUpload(filename, inputStream);
    }

    public String filedown(String filename, InputStream inputStream) throws IOException {
        return strategy.filedown(filename, inputStream);
    }

    //public String getUrl(String portrait) throws IOException {
    //    String filename = studentService.selectPortraitByPhone(portrait);
    //    logger.info("studentService.selectPortraitByPhone(portrait):\t"+filename);
    //    if (filename == null) {
    //        filename = studentService.selectPortraitByName(portrait);
    //        logger.info("studentService.selectPortraitByName(portrait):\t"+filename);
    //        if (filename == null) {
    //            return null;
    //        }
    //    }
    //    return strategy.getUrl(filename);
    //}
    public String getUrl(String portrait) throws IOException {
        if (portrait != null && !portrait.equals("")) {
            return strategy.getUrl(portrait);
        }
        return null;
    }
}
