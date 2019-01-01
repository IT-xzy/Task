package com.mutesaid.service.impl;

import com.mutesaid.mapper.MessageMapper;
import com.mutesaid.mapper.WorkMapper;
import com.mutesaid.pojo.Work;
import com.mutesaid.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Work> getWorkList(String name, Boolean status) {
        return workMapper.getWorkList(name, status);
    }

    @Override
    public Work getWork(Long workId) {
        return workMapper.getWork(workId);
    }

    @Override
    public void deleteWork(Long workId) {
        messageMapper.deleteWork(workId);
        workMapper.deleteWork(workId);
    }

    @Override
    public void updateStatus(Long workId) {
        Work work =  workMapper.getWork(workId);
        workMapper.updateStatus(workId, !(work.getStatus()));
    }

    @Override
    public void insert(String name, Long workListId, String intro, String thum, String video, String picture, String article) {
        Long currentTime = System.currentTimeMillis();
        Work work = new Work();
        work.setName(name);
        work.setWorkListId(workListId);
        work.setIntro(intro);
        work.setThum(thum);
        work.setVideo(video);
        work.setPicture(picture);
        work.setArticle(article);
        work.setStatus(false);
        work.setSubTitle(workListId + "二级标题");
        work.setAdminId(5L);
        work.setCreateAt(currentTime);
        work.setUpdateAt(currentTime);

        workMapper.insert(work);
    }
}
