package task05.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task05.dao.CarIntroDao;
import task05.pojo.CarIntro;
import task05.services.CarIntroServices;

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
