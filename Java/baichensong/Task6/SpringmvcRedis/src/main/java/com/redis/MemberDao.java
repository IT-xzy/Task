package com.redis;

import java.util.List;

public interface MemberDao {

    void addId(Member member);


    List<Member> findAll();

    Member findById(int id);

    void deleteId(int id);

    void updateId(Member member);

    //List<Member> findAllTwo();
}