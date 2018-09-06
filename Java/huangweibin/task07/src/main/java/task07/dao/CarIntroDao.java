package task07.dao;

import org.springframework.stereotype.Repository;
import task07.pojo.CarIntro;

import java.util.List;
@Repository
public interface CarIntroDao {

     List<CarIntro> queryAllIntro ();

}