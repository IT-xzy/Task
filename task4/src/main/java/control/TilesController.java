package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.CareerService;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="")
public class TilesController {
    @Autowired
    StudentService studentService;
    @Autowired
    CareerService careerService;

    //继承主模板接口
    @RequestMapping(value = "/layout",method = RequestMethod.GET)
    public ModelAndView test1(){
        ModelAndView modelAndView =new ModelAndView("layout");
        return modelAndView;
    }
    //继承test模板，home主页面
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView test2() throws Exception {
        ModelAndView modelAndView =new ModelAndView("home");
        //在线人数
        Integer onlineCount=studentService.getLearningStudentCount();
        //找到工作人数
        Integer workCount = studentService.getGraduatedStudentCount();
        //优秀学员
        Student student1 =studentService.getExcellentStudent(20180028);
        Student student2 =studentService.getExcellentStudent(20180001);
        Student student3 =studentService.getExcellentStudent(20180004);

        modelAndView.addObject("onlineCount",onlineCount);
        modelAndView.addObject("workCount",workCount);
        modelAndView.addObject("student1",student1);
        modelAndView.addObject("student2",student2);
        modelAndView.addObject("student3",student3);
        return modelAndView;
    }

    //继承test1模板的header和footer，career页面
    @RequestMapping(value = "/career",method = RequestMethod.GET)
    public ModelAndView career() throws Exception {
        ModelAndView modelAndView =new ModelAndView("career");
        //通过循环把职业分类插入到list中
        List list = new ArrayList(8);
        for(int i=1;i<=careerService.getAllCareer().size();i++){
            list.add(careerService.getCareerById(i));
        }
        //[0]web,[1]css,[2]java,[3]python,[4]ios,[5]android,[6]c,[7]pm
        modelAndView.addObject("list",list);

//       modelAndView.addObject("web",careerService.getCareerById(1));//web
        modelAndView.addObject("webCount",studentService.getCareerTypeCount("web"));
//       modelAndView.addObject("css",careerService.getCareerById(2));//css
        modelAndView.addObject("cssCount",studentService.getCareerTypeCount("css"));
//       modelAndView.addObject("java",careerService.getCareerById(3));//java
        modelAndView.addObject("javaCount",studentService.getCareerTypeCount("java"));
//       modelAndView.addObject( "python",careerService.getCareerById(4));//python
        modelAndView.addObject("pythonCount",studentService.getCareerTypeCount("python"));
//       modelAndView.addObject("ios",careerService.getCareerById(5));//ios
        modelAndView.addObject("iosCount",studentService.getCareerTypeCount("ios"));
//       modelAndView.addObject("android",careerService.getCareerById(6));//android
        modelAndView.addObject("androidCount",studentService.getCareerTypeCount("android"));
//       modelAndView.addObject("c",careerService.getCareerById(7));//c
        modelAndView.addObject("cCount",studentService.getCareerTypeCount("c"));
//       modelAndView.addObject("pm",careerService.getCareerById(8));//pm
        modelAndView.addObject("pmCount",studentService.getCareerTypeCount("pm"));
        return modelAndView;
    }


}
