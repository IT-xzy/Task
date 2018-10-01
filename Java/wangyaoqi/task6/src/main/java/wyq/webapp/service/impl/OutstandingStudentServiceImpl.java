package wyq.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wyq.webapp.mapper.OutstandingStudentMapper;
import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.service.OutstandingStduentService;
import wyq.webapp.util.PageForMain;

import java.util.List;

public class OutstandingStudentServiceImpl implements OutstandingStduentService {
    @Autowired
    OutstandingStudentMapper outstandingStudentMapper;

    @Override
    public List<OutstandingStudent> get(PageForMain page){
        return outstandingStudentMapper.get(page);
    }

    @Override
    public int total(){
        return outstandingStudentMapper.total();
    }
}
