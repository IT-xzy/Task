/**
 * Author: 老王
 * Date: 2019/4/14 0:51
 */
package cn.wp.dao;

import cn.wp.entity.Demo;

import java.util.List;

public interface  DemoDao {

    boolean add (Demo de);

    Demo findById (int id);

    List<Demo> findAll();
}
