import com.entity.Profession;
import com.service.ProfessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/spring-context.xml")
public class Task04 {
    @Autowired
    ProfessionService professionService;
    @Test
    public void insert01(){
/*        Profession profession =
                new Profession("android","互谅网技术","3颗星","难","5年",
                        "稀缺","10-40k","66","要有一定的基础","11");
        professionService.insert(profession);
        System.out.println(profession);*/
//        System.out.println(professionService.findById(2));
    }


    @Test
    public void findByStyle(){
        List<Profession> professions = professionService.findByStyle("全站");
        for (Profession list : professions){
            System.out.println(list);

        }
    }

}
