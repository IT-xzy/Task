package com.task.controller;

import org.springframework.stereotype.Controller;


@Controller
public class SendController {

//    @Resource
//    private SendService service;
//
//
//    @ResponseBody
//    @RequestMapping(value="sendme" ,method = RequestMethod.GET)
//    public ModelAndView sendme(@RequestParam(value="phone") String phone,
//                               HttpServletRequest request) throws HttpException, IOException {
//        ModelAndView model = new ModelAndView();
//        if(service.selectPhone(phone)){//查找是否被注册
//            HashMap<String, String> m = SendMessage.getMessageStatus(phone); //应用发送短信接口
//            String result = m.get("result");   //获取到result值
//            if (result.trim().equals("1")) {
//                String code = m.get("code");
//                System.out.println(code+"============================================================================");
//
//                HttpSession  session = request.getSession(); //设置session
//                session.setAttribute(phone+"code", code);    //将短信验证码放到session中保存
//                session.setMaxInactiveInterval(60 * 3); //缓存设置3分钟
//
//                model.addObject("flag", "短信发送成功");
//            }else{
//                model.addObject("flag", "短信发送失败,请重试");
//            }
//            model.addObject("phone", phone);
//            model.setViewName("index");
//        }else{
//            model.addObject("flag1", "该手机号已被注册");
//            model.addObject("phone", phone);
//            model.setViewName("index");
//        }
//        return model;
//
//    }
//
//
//    @RequestMapping(value="comparecode" ,method = RequestMethod.POST)
//    public ModelAndView comparecode(@RequestParam(value="code") String code, PhoneModel pmodel, HttpServletRequest request){
//        ModelAndView model = new ModelAndView();
//        //从session中比对发送的验证码
//        HttpSession session = request.getSession();//设置session
//        String sessioncode =(String) session.getAttribute(pmodel.getPhone()+"code");
//        System.out.println(sessioncode);
//
//
//        if((code).equals(sessioncode)){//比对缓存
//            //注册
//            service.add(pmodel);
//
//            model.addObject("result", "注册成功");
//        }
//        else{
//            model.addObject("result", "验证码不正确 ，注册失败");
//            model.setViewName("index");
//        }
//        model.setViewName("result");
//
//        return model;
//
//    }

}
