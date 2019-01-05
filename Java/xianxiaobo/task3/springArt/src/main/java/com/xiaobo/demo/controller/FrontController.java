package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.*;
import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/a")
public class FrontController {
    private static Logger log = Logger.getLogger(AboutController.class);
    @Autowired
    private CollectionServiceImpl collectionService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private Collection collection;
    @Autowired
    private Banner banner;
    @Autowired
    private BannerServiceImpl bannerService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private Comment comment;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    User user;
    @Autowired
    private WorkServiceImpl workService;
    @Autowired
    private Work work;
    @Autowired
    private About about;
    @Autowired
    private AboutService aboutService;
    //获取所有收藏
    @RequestMapping(value = "/u/front/collectionAndCategory", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCollectionAndCategory(){
        // 获取所有的collection id list
        Collection collection = new Collection();
        collection.setStatus(1);

        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        List<Collection> collectionList = collectionService.getList(collection,pageData);
        ArrayList collectionIdList = new ArrayList();
        for(Collection collectionItem:collectionList){
            collectionIdList.add(collectionItem.getId());
        }
        log.info(collectionIdList);
        Category category=new Category();
        // 获取所有的category
        List<Category> categoryList = categoryService.getListInCollectionIdList(category,collectionIdList,pageData);
        ArrayList categoryDataList = new ArrayList();
        // 拼装数据
        for(int i=0;i<collectionIdList.size();i++){
            ArrayList tempList = new ArrayList();
            for(Category categoryItem:categoryList){
                if(categoryItem.getCollection_id() == collectionIdList.get(i)){
                    tempList.add(categoryItem);
                }
            }
            categoryDataList.add(tempList);

        }
        ModelAndView modelAndView = new ModelAndView("frontCollectionAndCategoryList");
        Response response = new Response();
        modelAndView.addObject("response",response);
        modelAndView.addObject("collectionList",collectionList);
        modelAndView.addObject("categoryDataList",categoryDataList);
        return modelAndView;
    }
    //获取已上架的banner图
    @RequestMapping(value = "/u/front/banner", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBanner(){
        Banner banner = new Banner();
        banner.setStatus(1);
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        // 查询数据
        List<Banner> bannerList = bannerService.getList(banner,pageData);

        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("frontBannerList");
        Response response = new Response();
        modelAndView.addObject("response",response);
        modelAndView.addObject("bannerList",bannerList);
        return modelAndView;
    }
    //新增留言
    @RequestMapping(value = "/u/front/comment",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Comment comment){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        comment.setCreate_by(new Long(userId.toString()));
        comment.setUpdate_by(new Long(userId.toString()));
        comment.setCreate_at(new Long(new Date().getTime()));
        comment.setUpdate_at(new Long(new Date().getTime()));
        comment.setType(2);
        Boolean result = commentService.add(comment);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"参数错误");
        }
        return new ModelAndView("response","data",response);
    }
    // 根据作品id获取评论
    @RequestMapping(value = "/u/front/comment", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "work_id",required = false) String work_id){
        // 处理User参数
        Comment comment = new Comment();
        comment.setType(1);
        if(work_id != null && work_id.length() != 0){
            comment.setWork_id(new Long(work_id));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        // 查询数据
        List<Comment> commentList = commentService.getList(comment,pageData);

        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("frontCommentList");
        Response response = new Response();
        modelAndView.addObject("response",response);
        modelAndView.addObject("commentList",commentList);
        return modelAndView;
    }
    // 根据作品id获取作品详情
    @RequestMapping(value = "/u/front/work", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getWork(
            @RequestParam(value = "id",required = false) String id,
            @RequestParam(value="category_id",required = false) String category_id,
            @RequestParam(value = "page",required = false,defaultValue = "1") String page,
            @RequestParam(value = "size",required = false,defaultValue = "10") String size
            ){
        // 处理User参数
        Work work = new Work();

        if(id != null && id.length() != 0){
            work.setId(new Long(id));
        }
        if(category_id!=null && category_id.length() !=0){
            work.setCategory_id(new Long(category_id));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));

        // 查询数据
        List<Work> workList = workService.getList(work,pageData);
        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);

        ArrayList categoryNameList = new ArrayList();
        ArrayList collectionNameList = new ArrayList();
        for(Work workItem:workList){

            // category
            Long category_id2 = workItem.getCategory_id();
            Category category = new Category();
            category.setId(category_id2);
            List<Category> categoryList = categoryService.getList(category,pageData);
            if(categoryList != null && categoryList.size()>=1){
                categoryNameList.add(categoryList.get(0).getCategory_name());
            }
            // collection
            Long collection_id = categoryList.get(0).getCollection_id();
            Collection collection = new Collection();
            collection.setId(collection_id);
            List<Collection> collectionList = collectionService.getList(collection,pageData);
            if(collectionList != null && collectionList.size()>=1){
                collectionNameList.add(collectionList.get(0).getCollection_name());
            }
        }
        // 获取total
        Integer total = workService.getList(work,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("workList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("workList",workList);
        modelAndView.addObject("categoryNameList",categoryNameList);
        modelAndView.addObject("collectionNameList",collectionNameList);
        return modelAndView;
    }
    //获取所有工作室
    @RequestMapping(value = "/u/front/about", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(){
        // 处理User参数
        About about = new About();
        about.setStatus(1);

        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        // 查询数据
        List<About> aboutList = aboutService.getList(about,pageData);


        //获取用户列表
        ArrayList usernameList = new ArrayList();
        for(About aboutItem:aboutList){
            Long id = aboutItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);
            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
        }

        //获取total
        Integer total = aboutService.getList(about,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("aboutList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("aboutList",aboutList);
        modelAndView.addObject("usernameList",usernameList);
        return modelAndView;
    }
    // 从上架的作品集，上架的作品类中搜索作品name或者introduction中搜索
    @RequestMapping(value = "/u/front/workSearch", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getWork(
            @RequestParam(value = "text",required = false) String text,
            @RequestParam(value = "page",required = false,defaultValue = "1") String page,
            @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理page和sie
        Map<String,Object> originalPageData = new HashMap<>();
        originalPageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        originalPageData.put("limit",new Integer(size));

        Map<String,Object> allPageData = new HashMap<>();
        allPageData.put("offset",0);
        allPageData.put("limit",1000000);
        // 获取出上架的作品集列表
        Collection collection = new Collection();
        collection.setStatus(1);
        List<Collection> collectionList = collectionService.getList(collection,allPageData);
        ArrayList collectionIdList = new ArrayList();
        for(Collection collectionItem:collectionList){
            collectionIdList.add(collectionItem.getId());
        }
        log.info(collectionIdList);
        Category category = new Category();
        category.setStatus(1);
        List<Category> categoryList = categoryService.getListInCollectionIdList(category,collectionIdList,allPageData);
        log.info(categoryList);
        ArrayList categoryIdList = new ArrayList();
        for(Category categoryItem:categoryList){
            categoryIdList.add(categoryItem.getId());
        }
        log.info(categoryIdList);
        List<Work> workList = workService.getWorkSearchList(text,categoryIdList,originalPageData);
        log.info(workList);
        ModelAndView modelAndView = new ModelAndView("workList");
        Integer total = workService.getWorkSearchList(text,categoryIdList,allPageData).size();
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("workList",workList);

        return modelAndView;
    }


}
