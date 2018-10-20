package cn.wyq.service;

import cn.wyq.pojo.OutstandingStudent;
import cn.wyq.util.PageForMain;

import java.util.List;

public interface OutstandingStudentService {
    List<OutstandingStudent> get(PageForMain page);
    int total();
}
