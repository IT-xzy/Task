package com.dao;

import com.pojo.people;

import java.util.List;

public interface PeopleMapper {
    public void insertPeople(people a);
    public void deletePeopleById(int id);
    public  void updatePeopleById(people a);
    public people findPeopleById(int id);
    public List<people> findPeopleAll();
    public void insertBatch(List<people> list);

}
