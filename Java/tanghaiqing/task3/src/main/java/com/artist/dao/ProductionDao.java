package com.artist.dao;

import com.artist.pojo.Production;

import java.util.List;

public interface ProductionDao {
     List<Production> queryProductions(String word);
     List<Production> queryProductions1(String category);
     Production queryProduction (Integer productionId);
     void saveProduction(Production production);
     void delProduction(Integer id);
     void updateProduction(Production production);
}
