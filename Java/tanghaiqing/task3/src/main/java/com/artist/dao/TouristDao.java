package com.artist.dao;

import com.artist.pojo.Tourist;

import java.util.List;

public interface TouristDao {
    List<Tourist> queryTourists();
    List<Tourist> queryTourists1(Integer productionId);
    void delTourist (Integer touristId);
    Integer saveTourist(Tourist tourist);
    void updateTourist(Tourist tourist);
}
