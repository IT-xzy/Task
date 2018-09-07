package com.controller;
import com.exception.PaperException;
import com.pojo.Paper;
import com.service.PaperService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    //  打日志定位异常
    private Logger logger = Logger.getLogger(PaperController.class);

    //查询所有信息页面
    @RequestMapping(value ="/allPaper", method = RequestMethod.GET)
    public String queryAllPaper(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) {
        List<Paper> list = paperService.queryAllPaper();
        model.addAttribute("list", list);
        model.addAttribute("pagemsg", paperService.findByPage(currentPage));//回显分页数据
        logger.info("跳转到查询所有数据页面.");
        return "allPaper";
    }

    //新增信息
    @RequestMapping(value = "/toAddPaper", method = RequestMethod.GET)
    public String toAddPaper() {
        return "addPaper";
    }
    @RequestMapping(value = "/addPaper", method = RequestMethod.POST)
    public String addPaper(Paper paper) {
        logger.info(paper.toString());
        paperService.addPaper(paper);
        logger.info("POST:新增论文信息,paperService" + paperService);
        return "redirect:/allPaper";
    }

    //删除信息
    @RequestMapping(value = "/del/{paperId}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable("paperId") int id) {
        //logger.info("/del/{} POST");
        logger.info("controller:开始删除数据...");
        ModelAndView modelAndView = new ModelAndView();
        boolean A=paperService.deletePaperById(id);
        logger.info("controller:删除论文记录成功！id:" +A);
        modelAndView.setViewName("redirect:/allPaper");
        //return "redirect:/allPaper";//重定向allPaper页面
        return modelAndView;
    }

    //获取编辑页面
    @RequestMapping(value = "/toUpdatePaper/{id}", method = RequestMethod.GET)
    public String toUpdatePaper(Model model, @PathVariable("id") int id) {
        logger.info("controller：编辑页面跳转");
        model.addAttribute("paper", paperService.queryById(id));
        //logger.info("controller:更新成功！更新数据=" + paperService);
        return "updatePaper";
    }

    //修改论文信息
    @RequestMapping(value = "/updatePaper", method = RequestMethod.PUT)
    public String updatePaper(@Validated Paper paper) throws Exception {
        logger.info("controller:开始更新数据...");
        //异常处理：当修改信息为空时，异常错误跳转到error界面
     if(paper.getPaperName().isEmpty()){
            logger.info("controller:编辑失败，论文名称为空");
            throw new PaperException("controller异常：论文名称信息不可为空");
        }else {
            paperService.updatePaper(paper);
            logger.info("controller：更新数据成功！");
            return "redirect:/allPaper";
        }

    }



    //查询单条数据
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public String queryPaper(Model model, @RequestParam("id") int paperId) {
        logger.info("\n后端取到的id值："+paperId);
        Paper paper=paperService.queryById(paperId);
        model.addAttribute("paper",paper );
        logger.info("\n后端取到的值为："+paperService.queryById(paperId));
        return "findOne";
    }



    /**
     * Json返回查询数据
     * 使用ResponseBody注解，返回Json格式的对象
     //* @param paperId
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String queryAllPaper(Model model) {
        List<Paper> userList = paperService.queryAllPaper();
        //logger.info("the students are::{}", userList.toString());
        model.addAttribute("userList", userList);
        return "json";
    }


    //返回单条json记录
    @RequestMapping(value = "/json/one", method = RequestMethod.GET)
    public String jsonOne(@RequestParam("paperId") int paperId, Model model) throws Exception {
        logger.info("\n controller:json开始通过ID查询...:" + paperId);
        if (String.valueOf(paperId).isEmpty()) {
            logger.info("\n controller:json ID查询：ID为空");
        } else {
            Paper paper = paperService.queryById(paperId);
            if (paper == null) {
                //throw new PaperException("controller:json ID查询数据不存在!");
                return "error";
            }
            logger.info("\n controller：json通过ID查询成功!" + paper.toString());
            model.addAttribute("paper", paper);
        }
        return "jsonOne";
    }
}

    //
    //@RequestMapping(value = "/json", method = RequestMethod.GET)
    //@ResponseBody
    //public  ModelAndView json(@RequestParam("paperId")String paperId) throws Exception {
    //    logger.info("controller:json开始通过ID查询...");
    //    ModelAndView modelAndView = new ModelAndView();
    //    if(paperId.isEmpty()){
    //        logger.info("controller:json ID查询：ID为空");
    //        throw new PaperException("controller异常：json ID不能为空");
    //    }else {
    //        Paper paper = paperService.getPaperById(paperId);
    //        logger.info("controller：json通过ID查询成功!"+paper);
    //        if(paper==null){
    //            logger.info("controller:json ID查询数据不存在!");
    //            throw new PaperException("controller异常：json 该ID的供应商不存在");
    //        }
    //        modelAndView.addObject("paper",paper);
    //        return modelAndView;
    //    }
    //}






//修改论文信息
//@RequestMapping(value = "/updatePaper",method = RequestMethod.PUT)
//public String updatePaper(Paper paper) {
//    //paper = paperService.queryById(paper.getPaperId());
//    paperService.updatePaper(paper);
//    //model.addAttribute("paper", paper);
//    return "redirect:/allPaper";
