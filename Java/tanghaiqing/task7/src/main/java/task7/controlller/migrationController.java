package task7.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import task7.util.OSSClientUtil;
import task7.util.QNOSSUtil;
import task7.util.RedisUtil;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class migrationController {
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;
    @RequestMapping(value = "/migration", method = RequestMethod.POST)
    public String qiniuMigration(@RequestParam("address")String address) {
        System.out.println("jinlaile ------------");
        System.out.println("地址："+address);
        redisUtil.set("address",address);
        List<String> URLs = OSSClientUtil.getListUrl();
        for (String url : URLs) {
            QNOSSUtil.captureResource(url);
        }
        System.out.println("迁移完成");
        return "redirect:u/user";
    }

    @RequestMapping(value = "/aliMigration",method = RequestMethod.POST)
    public String aliyunMigration(@RequestParam("address")String address) {
        System.out.println("aliyun -------------");
        System.out.println("地址："+address);
        redisUtil.set("address",address);
        List<String> keys = QNOSSUtil.Qniuall();
        for (String key : keys) {
            if(!"".equals(key)){
                System.out.println(key);
                OSSClientUtil.captureResource(QNOSSUtil.getUrl(key));
            }
        }
        System.out.println("迁移完成");
        return "redirect:u/user";
    }
}
