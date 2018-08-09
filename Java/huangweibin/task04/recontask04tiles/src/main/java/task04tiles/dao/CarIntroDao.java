package task04tiles.dao;

import org.springframework.stereotype.Repository;
import task04tiles.pojo.CarIntro;

import java.util.List;
@Repository
public interface CarIntroDao {

    public List<CarIntro> queryAllIntro ();

}