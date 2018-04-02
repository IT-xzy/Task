package Service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.model.Profession;
import task.jnshu.service.ProfessionService;

import java.util.List;

/**
 * Created by Administrator on 11/8/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ProService {
    private static Logger LoggerPST = Logger.getLogger(ProService.class);

    @Autowired
    private ProfessionService professionService;

    @Test
    public void selectProfession(){
        try{
            LoggerPST.info("开始查询");
            List<Profession> professions = professionService.selectProfessionAll();
            int a[] = new int[professions.size()];
            for(int i = 0;i<professions.size();i++){
                LoggerPST.info(professions.get(i).getSocialNeeds());
                a[i] = professions.get(i).getSocialNeeds();
                LoggerPST.info(a[i]);
            }
            LoggerPST.info("profession: "+ professions);
            }catch (Exception e){
            e.printStackTrace();
            LoggerPST.error("e.getMessage()： " + e.getMessage());
        }


    }


}
