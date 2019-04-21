/**
 * Author: 老王
 * Date: 2019/4/13 23:36
 */
package dao;

import pojo.Demo;

public interface DemoDao {
//    查
    Demo queryDemoById(int id);

//    增
    void add(Demo demo);
}