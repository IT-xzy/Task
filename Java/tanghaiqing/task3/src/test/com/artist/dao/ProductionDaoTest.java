package com.artist.dao;
import com.artist.pojo.Production;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductionDaoTest {
    @Autowired
    private ProductionDao productionDao;

    @Test
    public void queryProductions() {
        List<Production> productions =
                productionDao.queryProductions("光芒");
        for(Production production:productions){
            System.out.println(production);
        }
    }
    @Test
    public void queryProductions1(){
        List<Production> list =productionDao.queryProductions1("城市光景");
        System.out.println(list);
    }
    @Test
    public void queryProduction() {
        Production production=productionDao.queryProduction(3);
        System.out.println(production);
    }
    @Test
    public void saveProduction() {
        Production p=new Production();
        p.setHeadline("爱上你");
        p.setAuthorName("天道");
        p.setIntroduce("本文讲述作者爸妈的年代恋情，结合他爸妈的实际。");
        p.setCategory("散文");
        p.setTheme("爸妈的年代");
        p.setContent("拉萨大家来看阿杜里斯坚阿斯利康客流量了快速GL看 充值卡DLKG点来看DLGKJJLK CBLKGO接啊该地块啊balk啊两个拉开；啊噶弗兰克不咋啊");
        p.setState("1");
        p.setCreateTime(System.currentTimeMillis());
        p.setUpdateTime(System.currentTimeMillis());
        productionDao.saveProduction(p);
    }

    @Test
    public void delProduction() {
        productionDao.delProduction(4);
    }

    @Test
    public void updateProduction() {
        System.out.println(System.currentTimeMillis());
        Production p=new Production();
        p.setProductionId(2);
        p.setHeadline("爱上你");
        p.setAuthorName("天道");
        p.setIntroduce("本文讲述作者爸妈的年代恋情，结合他爸妈的实际。");
        p.setCategory("散文");
        p.setTheme("爸妈的年代");
        p.setContent("拉萨大家来看阿杜里斯坚阿斯利康客流量了快速GL看 充值卡DLKG点来看DLGKJJLK CBLKGO接啊该地块啊balk啊两个拉开；啊噶弗兰克不咋啊");
        p.setState("1");
        p.setCreateTime(System.currentTimeMillis());
        p.setUpdateTime(System.currentTimeMillis());
        productionDao.updateProduction(p);
    }
}