package com.service.thirdParty;

import com.qiniu.storage.BucketManager;
import com.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

public interface QiNiuService extends BaseService {

    public String uploadFile(String key, MultipartFile multipartFile);

    public BucketManager.FileListIterator getList(int limit);
}
