package task04tiles.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import task04tiles.dao.CarIntroDao;
import task04tiles.pojo.CarIntro;
import task04tiles.services.CarIntroServices;

import java.util.List;
@Service
public class CarIntroServicesImpl implements CarIntroServices {
    @Autowired
    private CarIntroDao carIntroDao;

    @Override
    public List<CarIntro> queryAllIntro() {
        return carIntroDao.queryAllIntro();
    }
}
