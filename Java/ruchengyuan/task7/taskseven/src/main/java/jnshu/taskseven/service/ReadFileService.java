package jnshu.taskseven.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    String readPicture(HttpServletRequest request) throws ServletException, IOException;
}
