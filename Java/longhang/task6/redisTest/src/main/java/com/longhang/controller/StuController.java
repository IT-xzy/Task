package com.longhang.controller;

import com.longhang.model.Curriculum;
import com.longhang.model.Student;
import com.longhang.stuService.StuService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class StuController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(StuController.class);
    @Resource
    private StuService stu;
    /**
     * 跳转添加
     */
    @RequestMapping("/POST")
    public String toAddStu() {
        return "addStu";
    }

    /**
     * 跳转
     */
    @RequestMapping("/GET")
    public String toQueryStu() {
        return "message";
    }
    /**
     * 获取学生在跳转编辑
     */
    @RequestMapping("/toStudent/{id}")
    public String toUpdateStu(Model model,@PathVariable Long id) {
        model.addAttribute("student", stu.getStuById(id));
        logger.info("get student : "+stu.getStuById(id));
        return "editStu";
    }
    /**
     * 新增学生
     */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStu( Model model,Student student) {
        logger.info("add student : "+student.toString());
        if (student != null) {
            Long start=System.currentTimeMillis();
            System.out.println(student.toString());
            student.setCreate_at(start);
            stu.getInsert(student);
            Long end=System.currentTimeMillis();
            logger.info("the db run time : "+(end-start));
        }
        return "redirect:/students";
    }
    /**
     * 编辑学生
     * @param
     * @return
     */
    @RequestMapping(value = "/student",method =RequestMethod.PUT)
    public String updateStu( Long id, Student student) {
        logger.info("update id : "+id);
        logger.info("student massage : "+student.toString());
        Long start=System.currentTimeMillis();
        student.setUpdate_at(start);
        stu.getUpdate(student);
        Long end=System.currentTimeMillis();
        logger.info("???"+end);
        logger.info("the db run time : "+(end-start));
        return "redirect:/students";
    }
    /**
     * 获取学生
     *
     * @param id
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/json/student",method =RequestMethod.GET)
    public String getStu1(@RequestParam Long id, Student student, Model model) {
//        if (stu.getStuById(id)!=null){
        logger.info("query id : "+id);
        Long start=System.currentTimeMillis();
        Student student1=stu.getStu(student);
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
        model.addAttribute("student",student1);
        logger.info("student massage : "+student.toString());
        return "stuJson";
//        else
//            return "error";
    }
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET)
    public String getStu(@PathVariable Long id, Model model) {
//        if (stu.getStuById(id)!=null){
        logger.info("query id : "+id);
        model.addAttribute("student", stu.getStuById(id));
        return "message";
//        else
//            return "error";
    }
    /**
     * 根据id删除
     *
     * @param id
     * @param
     * @param
     */
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteStu(@PathVariable Long id, Model model) {
        logger.info("delete id : "+ id);
        Long start=System.currentTimeMillis();
        stu.getDelete(id);
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
        return "redirect:/students";
    }
    /**
     * 查询所有
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/students")
    public String getAllStu(Model model)  {

            List<Student> students = stu.getGetAll();
        System.out.println("我来了"+students.toString());

        model.addAttribute("studentList", students);

        return "all";

    }
    /**
     * 查询所有json
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/json/students")
    public String getAllStuOne(Model model)  {

            List<Student> students = stu.getGetAll();

        model.addAttribute("students", students);
        return "stuJson";
    }
    /**
     *?????????
     *t10
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("")
    public String go(Model model,Long id)
    {
        int sum=stu.getGetCount();
        int goodsum1=stu.getGetCountG();
        List<Student> student = stu.getGetAllExcellent();
        model.addAttribute("s", sum);
        model.addAttribute("ss", goodsum1);
        model.addAttribute("goodstuList", student);
       return "index";
    }
    /**
     *刷新t11
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping(value="/jnshu",method=RequestMethod.GET)
    public String get(Model model ){
        ArrayList<String> a =stu.getGetAllCuName();
        Iterator<String> it=a.iterator();
        while(it.hasNext()) {
            //System.out.println(it.next());//???????????java.util.NoSuchElementException
            String cuName =it.next();
            String REGEX_CHINESE = "[\u4e00-\u9fa5]";
            Pattern pat = Pattern.compile(REGEX_CHINESE);
            Matcher mat = pat.matcher(cuName);
            //System.out.println(mat.replaceAll(""));
            String cu=mat.replaceAll("");
            //System.out.println(cu+"??"+stu.getGetMajor(cu));
            int s=stu.getGetMajor(cu);//??????????
            stu.getUpdateCuByName(cuName,s);//dao???????@Param("name")
        }
        List<Curriculum> curriculum = stu.getGetAllCu();
        model.addAttribute("curriculumList", curriculum);
        return "t11";
    }
    /**
     *获取所有课程
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping("/jnshus")
    public String getAllCu(Model model){

        List<Curriculum> curriculum = stu.getGetAllCu();
        model.addAttribute("curriculumes", curriculum);
        return "allCurr";
    }
    /**
     *更新课程
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping(value = "/jnshu",method = RequestMethod.PUT)
    public String updateCu(Model model,Curriculum curriculum) {
        stu.getUpdateCu(curriculum);
        return"redirect:/jnshu";

    }
    /**
     *删除课程
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping(value = "/jnshu/{id}",method = RequestMethod.DELETE)
    public String deleteCu(Model model,@PathVariable Long id) {
        stu.getDeleteCu(id);
        return"redirect:/jnshu";

    }
    /**
     *添加课程
     *
     * @param
     * @param model
     * @return
     */

    @RequestMapping(value = "/jnshu",method = RequestMethod.POST)
    public String addCu(Model model,Curriculum curriculum) {
        stu.getInsertCu(curriculum);
        return"redirect:/jnshu";

    }
    /**
     * ?????????
     */
    @RequestMapping("/toPOST")
    public String toAddCurr() {
        return "addCurr";
    }

    /**
     * ?????????
     */
    @RequestMapping("/toCurr/{id}")
    public String toUpdateCurr(Model model,@PathVariable Long id) {
        model.addAttribute("curriculum", stu.getSelectCu(id));
        return "editCurr";
    }


//    private MemcachedClient createClient() throws Exception{
//        if(memcachedClient==null){//??spring????????build??
//            return memcachedClient = memcachedClientBuilder.build();
//        }
//        return null;
//    }
//     public Map<String, Student> queryFromCache(List<String> keys) {
//        Map<String, Student> users = new HashMap<String, Student>();
//        for (String key : keys) {
//          try {
//             Student student = memcachedClient.get(key);
//              users.put(key, student);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          } catch (MemcachedException e) {
//            e.printStackTrace();
//          } catch (TimeoutException e) {
//            e.printStackTrace();
//          }
//     }
//    return users;
//}
}
