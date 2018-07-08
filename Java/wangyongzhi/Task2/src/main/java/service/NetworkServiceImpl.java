package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import model.Network1;
import mapper.Network1Mapper;
import page.Page;

@Component
public class NetworkServiceImpl implements NetworkService {

    @Autowired(required=true)
    private Network1Mapper mapper;

    //INSERT插入数据

    public int insert(Network1 network1) {
        int result = mapper.insert(network1);
        return result;

    }

    //UPDATE方法：优先根据学生学号更新，其次根据姓名更新数据方法

    public Boolean update(Network1 network1) {
        int result = mapper.update(network1);
        if(result == 0) {
            return false;
        } else {
            return true;
        }
    }


    //SELECT根据姓名或者学号查询单条数据方法

    public Network1 selectByIdName(Network1 network1) {
        Network1 one = mapper.selectByIdName(network1);
        return one;
    }

    //根据学生学号删除记录方法

    public Boolean deleteById(Long id) {
        int result = mapper.deleteById(id);
        if(result == 0) {
            return false;
        } else {
            return true;
        }

    }

    //SELECT查询全部数据方法

    public List<Network1> selectAll() {
        List<Network1> ones = mapper.selectAll();
        return ones;
    }

    //SELECT分页查询全部数据方法

    public List<Network1> selectAll(Page page) {
        List<Network1> ones = mapper.selectAll(page);
        return ones;
    }

    public int total() {
        return mapper.total();
    }


}