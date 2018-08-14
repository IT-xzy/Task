package wyq.webapp.mapper;

import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.util.PageForMain;

import java.util.List;

public interface OutstandingStudentMapper {
    List<OutstandingStudent> get(PageForMain page);
    int total();
}
