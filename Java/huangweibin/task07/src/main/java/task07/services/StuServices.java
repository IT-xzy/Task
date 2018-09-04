package task07.services;

import task07.pojo.Students;

import java.util.List;

/**
 * @author Administrator
 */
public interface StuServices {
    /**
     *
     * @return
     */
    int querySum ();

    int queryWorkSum();

    List<Students> queryFrontList();

}
