package hzw.DAO;

import hzw.model.*;

import java.util.List;

public interface GreatStudentMapper {
    List<GreatStudent> findUserByName();
    List<Cooperation> findCooperation();
    List<HowToStudy> findStudy();
    List<Profession> findFront();
    List<Profession> findAfter();
    List<Profession> findOP();
    List<Profession> findPM();
    List<Company> findCompany();

}
