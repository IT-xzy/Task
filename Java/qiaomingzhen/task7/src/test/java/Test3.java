
/*
 * @ClassName:Test3
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/26 23:04
 **/

import com.mapper.UserMapper;
import com.service.UpImgService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test3 {
    @Autowired
    private UpImgService upImgService;

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\java-project\\task6\\target\\task6\\upload\\0adc9b18c83f4788a53572f80508847f.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        String url = upImgService.updateHead(multipartFile);
        System.out.println(url);
    }

}
