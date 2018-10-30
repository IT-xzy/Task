package cn.wyq.service;

import cn.wyq.pojo.OutstandingStudent;
import cn.wyq.util.PageForMain;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OutstandingStudentService {
    List<OutstandingStudent> get(PageForMain page);
    int total();
}
