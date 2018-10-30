import com.jnshu.entity.Art;
import com.jnshu.mapper.ArtMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class ArtMapperTest {

        Logger logger = LogManager.getLogger(ArtMapperTest.class.getName());
        @Autowired
        ArtMapper artMapper;

        @Test //新增作品
        public void testInsertArt() {
            Art art = new Art();
            art.setAuthor("达芬奇");
            art.setName("最后的晚餐");
            art.setFirstId(1l);
            art.setSecondId(1l);
            art.setIntroduce("耶稣基督");
            art.setState(true);
            art.setVideo("http://www.runker.net/");
            art.setIsLink(false);
            art.setImgSecondNaill("https://www.cnblogs.com/lsr-flying/p/6523529.html");
            art.setImgDetail("https://www.cnblogs.com/jerrylz/p/5814460.html");
            art.setArticleDetail("这幅画描述的是关于耶稣基督被人背叛的故事");
            art.setCreateAt(System.currentTimeMillis());
            art.setCreateBy("王伟");
            art.setUpdateAt(System.currentTimeMillis());
            art.setUpdateBy("");
            logger.info("添加结果："+ artMapper.insertArt(art));
            logger.info(art.toString());
        }
    @Test//根据主键选择性更新非空字段
    public void testUpdateArtSelective(){
        Art art = new Art();
        art.setId(1l);
        art.setAuthor("梵高");
        art.setName("向日葵");
        art.setFirstId(2l);
        logger.info("更新结果："+ artMapper.updateArtSelective(art));
    }

        @Test//作品上下架
        public void testIsOnlineArt(){
                Art  art = new Art();
                art.setId(6l);
                art.setState(true);
            logger.info("上架结果："+ artMapper.isOnlineArt(art));
        }

    @Test//获取作品详情
    public void testFindArtDetail() {
        logger.info("查找结果："+ artMapper.findArtDetail(1));
    }
    @Test//根据查询条件获取作品列表
    public void testFindArtSelective(){
        Art  art = new Art();
        art.setIntroduce("圣亚");
        List artList = artMapper.findArtSelective(art);
        for( int i = 0 ; i < artList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            //System.out.println(artList.get(i));
            logger.info(artList.get(i).toString());
        }
    }
    @Test//根据主键删除作品
    public void testDeleteArt(){
        logger.info("删除结果" +artMapper.deleteArt(1));
    }
    @Test//查询记录数
    public void testFindArtTotal(){
        logger.info("总共记录数" +artMapper.findArtTotal());
    }

}
