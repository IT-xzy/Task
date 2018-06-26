package com.ssm.utils;

import java.io.InputStream;

public interface UploadStrategyDao  {

    int upload(String fileName, InputStream stream)throws Exception;

}
