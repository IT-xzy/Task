package jnshu.controller;

import com.alibaba.fastjson.JSON;
import jnshu.model.ExcellentStudent;

import jnshu.service.ProfessionService;
import jnshu.service.StudentService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import java.util.List;

/**
 *
 * @author Administrator
 */
@Controller
public class ControllerTwo {
    private static Logger logger = Logger.getLogger (ControllerOne.class);
    @Resource
    StudentService studentService;
    @Resource
    ProfessionService professionService;

    long timeStamp = System.currentTimeMillis ();

    @RequestMapping(value="/u/students/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") long id) {
        int rs=   studentService.deleteStudent (id);
        ModelAndView mv = new ModelAndView ("info/delete01");
        mv.addObject ("rs", rs);
        return mv;
    }
    @RequestMapping(value="/u/toInsert", method = RequestMethod.GET)
    public ModelAndView toInsert() {

        ModelAndView mv = new ModelAndView ("info/insert01");
        return mv;
    }


    @RequestMapping(value="/u/students", method = RequestMethod.POST)
    public ModelAndView insert(ExcellentStudent student) {

        student.setCreatTime (timeStamp);
        student.setUpdateTime (timeStamp);
        logger.info (JSON.toJSONString (student));

        int rs=studentService.insertInfo (student);
        logger.info ("新增结果:"+rs);
        ModelAndView mv = new ModelAndView ("info/delete01");
        mv.addObject ("rs1", rs);
        return mv;
    }

    @RequestMapping(value="/u/toUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView toUpdate(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView ("info/update");
        mv.addObject ("id", id);
        return mv;
    }

    @RequestMapping(value="/u/students", method = RequestMethod.PUT)
    public ModelAndView update(ExcellentStudent student) {
        logger.info (11111);
        student.setUpdateTime (timeStamp);
        logger.info (JSON.toJSONString (student));

        int rs=studentService.updateByPrimaryKeySelective (student);
        logger.info ("更新结果:"+rs);
        ModelAndView mv = new ModelAndView ("info/delete01");
        mv.addObject ("rs2", rs);
        return mv;
    }

    @RequestMapping(value="/selectName", method = RequestMethod.GET)
    public ModelAndView update(String name) {
        List<ExcellentStudent> student = studentService.selectByName (name);

        ModelAndView mv = new ModelAndView ("info/select01");
        mv.addObject ("students", student);
        return mv;
    }
}
