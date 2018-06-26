package com.jnshu.controller;
import com.jnshu.service.Impl.ChecksServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ChecksController {
    @Resource
    private ChecksServiceImpl checksServiceImpl;

}
