package jnshu.tasknine.dao;

import jnshu.tasknine.model.Profession;

import java.util.List;

/**
 * @author ruchengyaun
 * @date 2017-10-15
 * Created by Administrator on 2017-10-15.
 */

public interface ProfessionMapper {

    /**
     * get a list of profession information
     *
     * @param
     * @return List<Profession>
     */
    List<Profession> listProfession();
}
