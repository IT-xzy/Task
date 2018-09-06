package task05.dao;

import org.springframework.stereotype.Repository;
import task05.pojo.CarIntro;

import java.util.List;
@Repository
public interface CarIntroDao {

     List<CarIntro> queryAllIntro ();

}