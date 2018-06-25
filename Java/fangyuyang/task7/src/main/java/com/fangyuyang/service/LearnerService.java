package com.fangyuyang.service;

import com.fangyuyang.model.Learner;


public interface LearnerService {
    void addLearner(Learner learner);
    void updateLearner(Learner learner);
    void deleteLearner(int id);
    Learner findLearnerById(int id);
    Learner findByName(String name);
    int countAll();

}
