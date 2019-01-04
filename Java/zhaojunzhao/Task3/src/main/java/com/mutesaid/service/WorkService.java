package com.mutesaid.service;

import com.mutesaid.pojo.Work;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkService {
    /**
     * 根据提供的参数查找作品
     * @param name 作品标
     * @param status 作品向下架状态1/0
     * @return 作品列表
     */
    List<Work> getWorkList(String name, Boolean status);

    /**
     * 查询指定作品
     * @param workId 作品id
     * @return 作品
     */
    Work getWork(Long workId);

    /**
     * 删除指定作品
     * @param workId 作品id
     */
    void deleteWork(Long workId);

    /**
     * 改变作品状态
     * @param workId 作品id
     */
    void updateStatus(Long workId);

    /**
     * 新增作品
     * @param name 作品标题
     * @param workListId 作品集id
     * @param intro 作品简介
     * @param thum 缩略图路径
     * @param video 视频连接
     * @param picture 图片路径
     * @param article 文章
     */
    void insert(String name, Long workListId, String intro,
                String thum, String video, String picture,
                String article);
}