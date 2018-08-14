package wyq.webapp.service;

import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.util.PageForMain;

import java.util.List;

public interface OutstandingStduentService {
    List<OutstandingStudent> get(PageForMain page);
    int total();
}
