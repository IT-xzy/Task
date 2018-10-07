
/*
 * @ClassName:TestTel
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/4 17:21
 **/

import com.mapper.TelCodeMapper;
import com.mapper.UserMapper;
import com.model.Code;
import com.model.People;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.service.UserService;
import com.util.task7.DayUtils;
import com.util.task7.MoveUtil;
import com.util.task7.NoteUtil;
import com.util.task7.QiNiuUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTel {
    @Autowired
    private NoteUtil noteUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private TelCodeMapper telCodeMapper;

    @Autowired
    private MoveUtil moveUtil;

    @Autowired
    private QiNiuUtil qiNiuUtil;

    @Autowired
    UserMapper userMapper;
    @Test

    public void test1() {

//        Boolean b = noteUtil.sendRandCode(17635265173L,"123456");
//        System.out.println(b);
    }

    @Test
    public void test2() {
        Boolean b = noteUtil.checkRandCode("650752", 15202487994L);
        System.out.println(b);
    }

    @Test
    public void test3() {
        long tel = 1L;
        System.out.println(DayUtils.IsToday(1536200791592L));
        Code code = new Code();
        code.setTel(tel);
        try {
            //数据库根据tel查询
            code = telCodeMapper.findTel(tel);

            long day = code.getUpdateTime();
            int sum = code.getTelSum();
//            code.setUpdateTime(System.currentTimeMillis());
            if (sum < 5) {
                //手机号存在，次数小于5
                if (DayUtils.IsToday(day)) {
                    //更新时间为当天，次数+1
                    code.setTelSum(sum + 1);
                    telCodeMapper.updateSum(code);
                } else {
                    //否则，次数设为1
                    code.setTelSum(1);
                    telCodeMapper.updateSum(code);
                }
            }
        } catch (NullPointerException e) {
            //手机号不存在，新增tel记录，次数为1
            code.setTelSum(1);
            telCodeMapper.addTel(code);
        }
    }

    @Test
    public void test4() {
//        System.out.println(noteUtil.sendNote("17635265173", "21312"));
//        System.out.println(noteUtil.checkTelSum(17635265173L));
        System.out.println(telCodeMapper.findTel(17635265173L).toString());
//        System.out.println(noteUtil.checkTelSum(15202487994L));

    }

    @Test
    public void testMove() {
        System.out.println(moveUtil.moveFile(10));

    }

    @Test
    public void name() {
        People people=new People();
        people.setTel(17635265173L);
        people.setUpdateTime(System.currentTimeMillis());
        System.out.println(userService.updatePeople(people));
    }
}
