package com.longhang.controller;

import com.longhang.model.Curriculum;
import com.longhang.model.Student;
import com.longhang.stuService.StuService;
import com.longhang.util.GetBean;
import com.longhang.util.OOSUtil;
import com.longhang.util.UploadOOS;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class StuController {

   // GetBean getBean=new GetBean();
   // GetBean1 getBean1=new GetBean1();
   // private StuService stu= getBean.getStu();
    //private StuService stu1= getBean.getService();

    org.slf4j.Logger logger = LoggerFactory.getLogger(StuController.class);
    @Resource
    private OOSUtil oosUtil;
    @Resource
    private UploadOOS uploadOOS;
//    @Resource
//    private StuService stu;
    GetBean getBean=new GetBean();
    private StuService stu=getBean.getStu();


    /**
     *
     * 数据迁移工具
     *
     * */
    @RequestMapping ("/qianyi")
    public String qianyi(){
        return "qinayi";
    }
    //@ResponseBody
    @RequestMapping(value = "/gotoAliyun" ,method =RequestMethod.POST )
    public String goAliyun() throws IOException {
        //获取图片名称,这里使用java基础String[]来储存picture数据
        String[] pictures=stu.getGetPicture();
        for (String picture : pictures)
        {
            //获取七牛url迁移至阿里云
            String url=uploadOOS.downloadQiniiu(picture);
            System.out.println("url:::"+url);
            //  uploadOOS.uploadAliyunOSS(url,picture);
        }
        System.out.println("url:::"+"213123214");
        return "o";
    }
    //@ResponseBody
    @RequestMapping("/goQiniuyun")
    public String goQiniuyun() throws IOException {

        String[] pictures=stu.getGetPicture();
        for (String picture : pictures)
        {
            //获取阿里云url迁移至七牛
            logger.info("所有图片::::"+picture);
            String url=uploadOOS.getAliyunUrl(picture);
            logger.info("url:::"+url);
            // uploadOOS.uploadQiniuOnline(url,picture);
        }
        return "o";
    }



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
        Student student;
        try{
         student=stu.getStuById(id);
       }catch (Exception e){
            student=getBean.getStu().getStuById(id);
       }
        String url="http://"+oosUtil.getBucketName()+"."+oosUtil.getEndpoint()+"/"+student.getPicture();
        student.setPicture(url);
        model.addAttribute("student", student);
        logger.info("get student : "+stu.getStuById(id));
        return "editStu";
    }

    /**
     * 新增学生
     */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStu(HttpServletRequest request, Student student, @RequestParam("upPicture") CommonsMultipartFile upPicture) throws IOException {
        logger.info("图片路径:::"+upPicture);
        String fileName=null;
        if(upPicture!=null) {
            InputStream inputStream = upPicture.getInputStream();
            //判断域名所属，对应存储那个云
            if(oosUtil.getEndpoint().equals("oss-cn-shenzhen.aliyuncs.com")){
                fileName =  oosUtil.uploadOSS(inputStream);
            } else {
                fileName=oosUtil.qiniu(inputStream);
            }
        }
        logger.info("add student : "+student.toString());
        if (student != null) {
            //把图片的名字作为picture字段储存
            student.setPicture(fileName);
            Long start=System.currentTimeMillis();
            logger.info(student.toString());
            //设置创建时间
            student.setCreate_at(start);
            try{
                stu.getInsert(student);
            }catch (Exception e){
                getBean.getStu().getInsert(student);
            }
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
    public String updateStu(Long id, Student student,@RequestParam("upPicture") CommonsMultipartFile upPicture) throws IOException {
        logger.info("update id : "+id);
        logger.info("student massage : "+student.toString());
        String fileName=null;
        if(upPicture!=null) {
            InputStream inputStream = upPicture.getInputStream();
            //判断域名所属，对应存储那个云
            if(oosUtil.getEndpoint().equals("oss-cn-shenzhen.aliyuncs.com")){
                fileName =  oosUtil.uploadOSS(inputStream);
            } else {
                fileName=oosUtil.qiniu(inputStream);
            }
        }
        Long start=System.currentTimeMillis();
        student.setUpdate_at(start);
        //修改该字段
        student.setPicture(fileName);
        try{
        stu.getUpdate(student);
        }catch (Exception e ){
            getBean.getStu().getUpdate(student);
        }
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
        Student student1;
        try{
         student1=stu.getStu(student);
        }catch (Exception e ){
            student1=getBean.getStu().getStu(student);
        }
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
        model.addAttribute("student",student1);
        logger.info("student massage : "+student.toString());
        return "stuJson";
//        else
//            return "error";
    }
    @ResponseBody
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET)
    public Student getStu(@PathVariable Long id, Model model) {
        logger.info("query id : "+id);
        try{
        model.addAttribute("student", stu.getStuById(id));
        }catch (Exception e){
            model.addAttribute("student", getBean.getStu().getStuById(id));
        }
        return stu.getStuById(id);
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
        try{
            stu.getDelete(id);
        }catch (Exception e){
            StuService stu= getBean.getStu();
                stu.getDelete(id);
        }
        Long end=System.currentTimeMillis();
        logger.info("the db run time : "+(end-start));
//        StuService stu= getBean.getStu();
//        stu.getDelete(id);
        return "redirect:/students";
    }
    /**
     * 查询所有
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("students")
    public String getAllStu(Model model)  {
//try/catch方法
        List<Student> students;
        try{
             students = stu.getGetAll();
            //System.out.println("我来了"+students.toString());
        } catch (Exception e){
            System.gc();
            StuService stu= getBean.getStu();
           students = stu.getGetAll();
        }
           model.addAttribute("studentList", students);


        //new方法
//       StuService stu= new GetBean().getStu();
//        List<Student> students = stu.getGetAll();
//        model.addAttribute("studentList", students);
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
    @RequestMapping("/jnshu/goodstudent")
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

}
