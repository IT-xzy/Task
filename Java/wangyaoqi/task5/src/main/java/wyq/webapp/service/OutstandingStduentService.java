package wyq.webapp.service;

import wyq.webapp.pojo.OutstandingStudent;
import wyq.webapp.util.Page;

import java.util.List;

public interface OutstandingStduentService {
    List<OutstandingStudent> get(Page page);
    int total();
}
