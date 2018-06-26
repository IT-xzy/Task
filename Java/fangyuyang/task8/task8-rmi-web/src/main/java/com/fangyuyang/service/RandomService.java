package com.fangyuyang.service;

import com.fangyuyang.model.Learner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomService {
    public List<Learner> serviceRandomUsed(){
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
        String learner1 = "learnerClient";
        String learner2 = "learnerClient1";
        double count = Math.random()*10;
        System.out.println("count: "+ count);
        if(count<5){
            try {
                LearnerService learnerService = (LearnerService) f.getBean(learner1);
                System.out.println("加载第一台");
                int allId = learnerService.countAll();
                Random randomLearner = new Random();
                int pictureId = randomLearner.nextInt(allId-3);
                List<Learner> learnerList = new ArrayList<>();
                learnerList.add(learnerService.findLearnerById(pictureId));
                learnerList.add(learnerService.findLearnerById(pictureId+1));
                learnerList.add(learnerService.findLearnerById(pictureId+2));
                learnerList.add(learnerService.findLearnerById(pictureId+3));
                System.out.println("第一次成功1");
                return learnerList;

            }catch (Exception e){
                LearnerService learnerService = (LearnerService) f.getBean(learner2);
                System.out.println("加载第二台");
                int allId = learnerService.countAll();
                Random randomLearner = new Random();
                int pictureId = randomLearner.nextInt(allId-3);
                List<Learner> learnerList = new ArrayList<>();
                learnerList.add(learnerService.findLearnerById(pictureId));
                learnerList.add(learnerService.findLearnerById(pictureId+1));
                learnerList.add(learnerService.findLearnerById(pictureId+2));
                learnerList.add(learnerService.findLearnerById(pictureId+3));
                return learnerList;
            }
        }else {
            try {
                LearnerService learnerService = (LearnerService) f.getBean(learner2);
                System.out.println("加载第二台");
                int allId = learnerService.countAll();
                Random randomLearner = new Random();
                int pictureId = randomLearner.nextInt(allId-3);
                List<Learner> learnerList = new ArrayList<>();
                learnerList.add(learnerService.findLearnerById(pictureId));
                learnerList.add(learnerService.findLearnerById(pictureId+1));
                learnerList.add(learnerService.findLearnerById(pictureId+2));
                learnerList.add(learnerService.findLearnerById(pictureId+3));
                System.out.println("第一次成功2");
                return learnerList;

            }catch (Exception e){
                LearnerService learnerService = (LearnerService) f.getBean(learner1);
                System.out.println("加载第一台");
                int allId = learnerService.countAll();
                Random randomLearner = new Random();
                int pictureId = randomLearner.nextInt(allId-3);
                List<Learner> learnerList = new ArrayList<>();
                learnerList.add(learnerService.findLearnerById(pictureId));
                learnerList.add(learnerService.findLearnerById(pictureId+1));
                learnerList.add(learnerService.findLearnerById(pictureId+2));
                learnerList.add(learnerService.findLearnerById(pictureId+3));
                System.out.println("OK");
                return learnerList;
            }
        }

    }
}
