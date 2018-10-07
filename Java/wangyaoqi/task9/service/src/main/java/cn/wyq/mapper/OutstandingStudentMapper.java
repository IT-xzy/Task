package cn.wyq.mapper;

import cn.wyq.pojo.OutstandingStudent;
import cn.wyq.util.PageForMain;

import java.util.List;

public interface OutstandingStudentMapper {
    List<OutstandingStudent> get(PageForMain page);
    int total();
}
