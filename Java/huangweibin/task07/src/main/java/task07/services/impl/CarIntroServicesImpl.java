package task07.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task07.dao.CarIntroDao;
import task07.pojo.CarIntro;
import task07.services.CarIntroServices;

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
