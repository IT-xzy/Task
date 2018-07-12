package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OccupationDao;
import spring.model.Occupation;

import java.util.List;
@Service
public class OccupationService {
    @Autowired
    private OccupationDao occupationDao;

    public List<Occupation> query() {
        return occupationDao.query();
    }
}
