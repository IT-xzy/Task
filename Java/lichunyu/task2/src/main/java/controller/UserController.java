package controller;

import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import exception.SupplierException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;
import service.SupplierService;
import java.util.List;

/**
 * UserController 是一个基于注解的控制器
 * 可以同时处理多个请求动作
 * 采用Restful格式编写接口
 * 新增=post、删除=delete、查询=get、更新=put
 */
@Controller
@RequestMapping(value="")
public class UserController {
    //注入服务类接口
    @Autowired
    SupplierService supplierService;

    //  打日志定位异常
   private Logger logger = Logger.getLogger(UserController.class);

    /**
     * 跳转到增加页面
     * @param supplier
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(@ModelAttribute("supplier") Supplier supplier) {
        logger.info("controller：添加页面跳转");
        return "/add";
    }

    /**
     * restful增加供应商
     * @param supplier
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    public String add(@Validated Supplier supplier) throws Exception {
        logger.info("controller:开始添加数据...");
        //异常处理：当添加信息为空时，异常错误跳转到error界面
            if (supplier.getSupplierName().isEmpty()||supplier.getContactName().isEmpty()
                    ||supplier.getContactMobile().isEmpty()||supplier.getRemark().isEmpty()||supplier.getValidFlag().isEmpty()) {
                logger.info("controller:添加失败，数据为空");
                throw new SupplierException("controller异常：添加信息不可为空!");
            }else {
                supplierService.addSupplier(supplier);
                logger.info("controller:添加供应商成功!supplier:"+supplier);
                return "redirect:/supplierPage";
            }
    }

    /**
     * restful删除供应商
     * @param supplierId
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/supplier/{supplierId}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable String supplierId) throws Exception {
        logger.info("controller:开始删除...");
        ModelAndView modelAndView =new ModelAndView();
        supplierService.deleteSupplier(supplierId);
        logger.info("controller:删除供应商成功!supplierId:"+supplierId);
        modelAndView.setViewName("redirect:/supplierPage");
        return modelAndView;
    }

    /**
     * 根据Id查询
     * @param supplierId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplier",method = RequestMethod.GET)
    public ModelAndView getOilSupplierById(@RequestParam("supplierId") String supplierId) throws Exception {
        logger.info("controller：开始通过ID查询...");
        ModelAndView modelAndView = new ModelAndView();
        if(supplierId.isEmpty()){
            logger.info("controller:ID查询：ID为空");
            throw new SupplierException("controller异常：ID不能为空");
        }else {
            Supplier supplier = supplierService.getSupplierById(supplierId);
            logger.info("controller：通过ID查询成功!"+supplier);
//          异常处理，当供应商不存在时，跳转到error页面，并返回错误信息
            if(supplier==null){
                logger.info("controller:ID查询数据不存在!");
                throw new SupplierException("controller异常：该ID的供应商不存在");
            }
            modelAndView.addObject(supplier);
            return modelAndView;
        }
    }

    /**
     * 模糊查询
     * 返回供应商列表界面
     * @return
     */
    @RequestMapping(value = "/supplierList",method = RequestMethod.GET)
    public ModelAndView getSupplierList(@RequestParam("supplierName") String supplierName) throws Exception {
        logger.info("controller:开始模糊查询...");
        ModelAndView mav = new ModelAndView();
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierName);
        if(supplierName.isEmpty()){
            logger.info("controller:模糊查询供应商名称为空!supplierName.isEmpty:"+supplierName.isEmpty());
            throw new SupplierException("controller异常：模糊查询名称不能为空");
        }else {
            List<Supplier> list = supplierService.getSupplierList(supplier);
            logger.info("模糊查询成功:" + list);
//          异常处理，当供应商不存在时，跳转到error页面，并返回错误信息
            if(list.isEmpty()){
                logger.info("controller:模糊查询数据不存在！list.isEmpty:"+list.isEmpty());
                throw new SupplierException("controller异常：模糊查询数据不存在！");
            }
            mav.addObject("list", list);
            mav.setViewName("supplierList");
            return mav;
        }
    }

    /**
     * 所有数据分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/supplierPage",method = RequestMethod.GET)
    public ModelAndView listByPage(Page<Supplier> page){
        logger.info("controller：开始所有数据分页查询...");
        ModelAndView mav=new ModelAndView();
        //分页查询
        List<Supplier> list =supplierService.listByPage(page);
        logger.info("controller：所有数据分页查询成功!");
        mav.addObject("list",list);
        mav.setViewName("supplierPage");
        return mav;
    }

    /**
     * 跳转到编辑页面
     * @param supplier
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updatePage(@ModelAttribute("supplier") Supplier supplier) throws Exception {
        logger.info("controller：编辑页面跳转");
        return "/update";
    }

    /**
     * 编辑信息
     * @param supplier
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplier",method = RequestMethod.PUT)
    public String update(@Validated Supplier supplier) throws Exception {
        logger.info("controller:开始更新数据...");
        //异常处理：当修改信息为空时，异常错误跳转到error界面
        if (supplier.getSupplierId().isEmpty()) {
            throw new SupplierException("controller异常：修改供应商id不可为空");
        }else if(supplier.getSupplierName().isEmpty()||supplier.getContactName().isEmpty()
                ||supplier.getContactMobile().isEmpty()||supplier.getRemark().isEmpty()){
            logger.info("controller:编辑失败，数据为空");
            throw new SupplierException("controller异常：修改信息不可为空");
        }else {
            supplierService.updateSupplier(supplier);
            logger.info("controller：更新数据成功！"+supplierService.getSupplierById(supplier.getSupplierId()));
            return "redirect:/supplierPage";
        }
    }

    /**
     * Login登录成功/失败界面
     * RequestMapping 用来映射一个请求和请求的方法
     * value="/success" 表示请求由success方法进行处理
     */
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        logger.info("controller:开始执行登录操作...");
        // 在 model 中添加一个名为 "user" 的 user 对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        ModelAndView mav = new ModelAndView();
        if (true/*"jnshu".equals(username) && "123456".equals(password)*/) {
            mav.addObject(user);
            logger.info("login:登录成功！user:"+username);
            return mav;
        } else {
            mav.setViewName("fail");
            logger.info("login:登录失败！");
            return mav;
        }
    }

    /**
     * Json返回查询数据
     * 使用ResponseBody注解，返回Json格式的对象
     * @param supplierId
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public  ModelAndView json(@RequestParam("supplierId") String supplierId) throws Exception {
        logger.info("controller：json开始通过ID查询...");
        ModelAndView modelAndView = new ModelAndView();
        if(supplierId.isEmpty()){
            logger.info("controller:json ID查询：ID为空");
            throw new SupplierException("controller异常：json ID不能为空");
        }else {
            Supplier supplier = supplierService.getSupplierById(supplierId);
            logger.info("controller：json通过ID查询成功!"+supplier);
//          异常处理，当供应商不存在时，跳转到error页面，并返回错误信息
            if(supplier==null){
                logger.info("controller:json ID查询数据不存在!");
                throw new SupplierException("controller异常：json 该ID的供应商不存在");
            }
            modelAndView.addObject("supplier",supplier);
            return modelAndView;
        }
    }


}
