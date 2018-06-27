package com.redis;


import java.util.List;

import com.RedisTest.RedisUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class MemberServiceImpl implements MemberService {

    private static  Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
    @Autowired
    private MemberDao memberDao;



    /*
     * 添加对象
     */

    @Override
    public void addId(Member member) {
        Jedis jedis = RedisUtil.getJedis();
        memberDao.addId(member);
        //获取连接
        //写入缓存
        jedis.set(member.getId(), member.getNickname());
        System.out.println("写入redis成功");
    }

// 查询  通过json字符串
    @Override
    public List<Member> findAll() {
        Jedis jedis = null;
        // 标准写法 释放连接池
        try {
            jedis = RedisUtil.getJedis();
            String string = jedis.get("st");
            if (string == null) {
                List<Member> members = memberDao.findAll();
                //转为json字符串
                String ss = JSON.toJSONString(members);
                jedis.set("st", ss);
                log.info("写入成功" + members);
                return members;

            } else {
                String s = jedis.get("st");
                List<Member> m = JSON.parseArray(s, Member.class);
                log.info("加载缓存" + m);
                return m;
            }
        } catch (Exception e){
            log.info("错误");
        }finally {
            RedisUtil.returnResource(jedis);

        }
        return null;
    }


    // 查
    @Override
    public Member findById(int id) {
       Jedis jedis = RedisUtil.getJedis();
        Member m = memberDao.findById(id);
        jedis.set(m.getId(), m.getNickname());
        return m;
    }

    //删除
    @Override
    public void deleteId(int id) {
        memberDao.deleteId(id);
    }

    //更新
    @Override
    public void updateId(Member member) {
        memberDao.updateId(member);
    }

    //查询 List[] 集合
@Override
    public List<Member> findAllTwo(){
        return memberDao.findAll();
}

}