package jnshu.taskeight.APIUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author Administrator
 * @date 2017-11-09
 */
@Service("readFileService")
public interface ReadFileService {

    /**
     * 上传文件，正常返回为新命名的文件名
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    String readPicture(HttpServletRequest request, String user) throws ServletException, IOException;
    String readPicture(MultipartFile file, String user) throws ServletException, IOException;
}
