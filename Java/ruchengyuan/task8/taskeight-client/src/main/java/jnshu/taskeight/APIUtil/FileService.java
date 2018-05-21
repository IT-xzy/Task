package jnshu.taskeight.APIUtil;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * 实现不同的服务商的上传
 * @author Administrator
 * @date 2017-11-02
 */

@Service("fileService")
public interface FileService {

    /**
     * 上传文件到服务商的接口
     * @param path
     * @param name
     * @param in
     * @param contentType
     * @return
     */
     String uploadStream(String path, String name, InputStream in, String contentType);
     InputStream getFileStream(String path, String name);
     List<String> listFileName(String prefix);
}
