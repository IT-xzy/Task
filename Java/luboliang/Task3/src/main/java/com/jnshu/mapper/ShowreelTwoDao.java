package com.jnshu.mapper;

import com.jnshu.model.ShowreelTwo;

import java.util.List;

public interface ShowreelTwoDao {
    public long addShowreelTow(ShowreelTwo showreelTwo);

    public boolean deleteShowreelTow(long id);

    public boolean updateShowreelTow(ShowreelTwo showreelTwo);

    public ShowreelTwo findByShowreelTow(long id);

    public List<ShowreelTwo> findAllShowreelTow();
}
