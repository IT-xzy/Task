package wyq.webapp.mapper;

import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.util.Page;

import java.util.List;

public interface OutstandingStudentMapper {
    List<OutstandingStudent> get(Page page);
    int total();
}
