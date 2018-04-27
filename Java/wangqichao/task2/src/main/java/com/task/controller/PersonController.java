package com.task.controller;

import com.task.models.Person;
import com.task.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
@RequestMapping(value = "/task2")
public class PersonController {
    @Autowired
    private PersonService personService;
    private Logger logger=Logger.getLogger(PersonController.class);

    @RequestMapping(value="/list")
    //方法为获取所有数据，对应路径为/task2/list
    //currentPage这个值是从jsp页面传回来的，对应不同的按钮值也不同，根据传回来的不同值传进不同的值，默认为1，即没有按任何键的情况下自动显示第一页
    public ModelAndView listPersonByPage(@RequestParam(value = "currentPage" ,defaultValue="1",required = false)int currentPage){
        ModelAndView mav=new ModelAndView();
        //使用mav将查找到的数据传到list.jsp里，再在jsp中动态获取数据
        mav.addObject("pagemsg",personService.listByPage(currentPage));
        //注意此时的attributeName为pagemsg，后面会使用到其来选定属性和路径
        mav.setViewName("list");
        //设置返回的视图页面为list.jsp，前缀后缀在spring-mvc.xml中设置了
        return mav;
    }

    @RequestMapping(value="/person/{id}",method = RequestMethod.GET)
        //get意味着在url同样显示/person/id的情况下显示此方法主要起到查询数据的作用
    public String findPersonById(@PathVariable int id,Model model)throws Exception{
        Person personById=personService.justListById(id);
        //使用id查找数据并将查找到的对象添加到model中方便在id.jsp页面动态获
            // 其中第一个personById对应id.jsp页面的${personById.id},第二个对应之前存储查找结果的对象名
        model.addAttribute("personById",personById);
        //主要作用是将操作细节记录到本地日志中，方便查看
        logger.info("查找操作，id为"+id);
        //返回到id.jsp视图
        return "id";
    }
    //根据姓名模糊查找
    @RequestMapping(value = "/person/name",method = RequestMethod.GET)
    //因为在输入框中输入了name，所以需要将此name传过来，就需要用到@RequestParam，然后需要将查询到的数据传回去，就需要使用到Model
    public String finePersonByName(@RequestParam String name, Model model)throws  Exception{
        List<Person> person=personService.justList(name);
        model.addAttribute("person",person);
        logger.info("查找操作，name为"+name);
        return "list";
    }


    @RequestMapping(value="/person/{id}",method = RequestMethod.PUT)
    //put意味着在url同样显示/person/id的情况下显示此方法主要起到修改数据的作用
    public String updatePersonById(@PathVariable int id,Person person) {
        if (person.getFightingCapacity() > 100 || person.getFightingCapacity() < 0||person.getName().length()>5) {
            return "redirect:/task2/error";
        } else {
            try {
                //因为在页面中没有设置id这一栏，而且修改是不能修改id的，而修改语句中有个where id=?,所以需要先获得id.
                person.setId(id);
                //手动添加更新时间这一属性到person中
                person.setUpdatedAt(System.currentTimeMillis());
                personService.justUpdate(person);
            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.error("修改姓名有重复，id为" + person.getId());
                //如果姓名有重复就跳转到/task2/error中，在error里面设置跳转到error.jsp
                return "redirect:/task2/error";
            }
            //主要作用是将操作细节记录到本地日志中，方便查看
            logger.info("修改操作，id为" + person.getId());
            //redirect为重定向
            return "redirect:../list";
            //或者使用return "redirect:/task2/list"，而直接使用redirect:list就会进入/person/list，这个url是无效的
        }
    }
    @RequestMapping(value="/person/{id}",method = RequestMethod.DELETE)
    //使用DELETE作为请求方法，其余参考更新方法
     public String deletePersonById(@PathVariable int id)throws  Exception{
        personService.justDelete(id);
        logger.info("删除操作，id为"+id);
        return "redirect:/task2/list";
    }
    @RequestMapping(value="/person/newone",method = RequestMethod.GET)
    public String newPerson(){
        return "newone";
    }

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public String addPerson(Person person) {
        if (person.getFightingCapacity() > 100 || person.getFightingCapacity() < 0||person.getName().length()>5) {
            return "redirect:/task2/error";
        } else {
            try {
                person.setCreatedAt(System.currentTimeMillis());
                //因为createdAt是not null所以需要手动添加此属性到person中
                personService.justAdd(person);
            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.error("插入姓名有重复，id为" + person.getId());
                //如果姓名有重复就跳转到/task2/error中，在error里面设置跳转到error.jsp
                return "redirect:/task2/error";
            }
            logger.info("添加操作，id为" + person.getId());
            return "redirect:/task2/list";
        }
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String goToError(){
        return "error";
    }


}
