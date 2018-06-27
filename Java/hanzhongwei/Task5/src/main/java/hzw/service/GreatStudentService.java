package hzw.service;

import hzw.model.GreatStudent;

import java.io.IOException;
import java.util.List;

public interface GreatStudentService {
    public List<GreatStudent> findUserByName() throws IOException;
}
