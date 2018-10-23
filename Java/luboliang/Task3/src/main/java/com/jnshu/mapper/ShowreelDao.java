package com.jnshu.mapper;

import com.jnshu.model.ShowreelOne;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ShowreelDao {
    
    
    public long addShowreelOne(ShowreelOne showreelOne);

    public boolean deleteShowreelOne(long id);

    public boolean updateShowreelOne(ShowreelOne showreelOne);

    public ShowreelOne findByShowreelOne(long id);

    public List<ShowreelOne> findAllShowreelOne();
    
}
