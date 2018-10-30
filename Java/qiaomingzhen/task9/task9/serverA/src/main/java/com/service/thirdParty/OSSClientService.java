package com.service.thirdParty;

import com.service.BaseService;

import java.io.File;
import java.net.URL;

public interface OSSClientService extends BaseService {
    public URL uploadPicture(String key, File file);
    public URL uploadInputStream(String key, byte[] file);

}
