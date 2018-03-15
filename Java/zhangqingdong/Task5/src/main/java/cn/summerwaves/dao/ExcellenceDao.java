package cn.summerwaves.dao;

import cn.summerwaves.model.Excellence;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcellenceDao {
    List<Excellence> selectExcellenceByName();
}
