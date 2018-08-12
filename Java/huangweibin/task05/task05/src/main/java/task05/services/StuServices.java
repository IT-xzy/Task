package task05.services;

import task05.pojo.Students;

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
