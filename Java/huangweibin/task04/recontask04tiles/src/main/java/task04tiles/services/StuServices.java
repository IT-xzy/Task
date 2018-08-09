package task04tiles.services;

import task04tiles.pojo.Students;

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
