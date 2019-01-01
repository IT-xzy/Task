package com.mutesaid.controller;

import com.mutesaid.pojo.Work;
import com.mutesaid.service.WorkService;
import com.mutesaid.util.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class WorkController {
    @Autowired
    private WorkService workService;

    @Autowired
    private ResponseBo responseBo;

    @RequestMapping(value = "list")
    @ResponseBody
    public Map getWorkList(String workName, String status) {
        try{
            Boolean statusIn = status==null?null:Integer.parseInt(status)!=0;
            List<Work> workList = workService.getWorkList(workName, statusIn);
            return responseBo.msg("success", workList);
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map insert(@RequestBody Work work) {
        try{
            workService.insert(work.getName(), work.getWorkListId(),
                    work.getIntro(), work.getThum(), work.getVideo(),
                    work.getPicture(), work.getArticle());
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map delete(@PathVariable("id") String id) {
        try{
            workService.deleteWork(Long.parseLong(id));
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map updateStatus(@PathVariable("id") String id) {
        try{
            workService.updateStatus(Long.parseLong(id));
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map getWork(@PathVariable("id") String id) {
        try{
            Work work = workService.getWork(Long.parseLong(id));
            return responseBo.msg("success", work);
        }catch (Exception e){
            return responseBo.msg("fail");
        }

    }
}
