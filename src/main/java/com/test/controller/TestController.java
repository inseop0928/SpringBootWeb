package com.test.controller;

import com.test.entity.Test01;
import com.test.entity.Test01Repository;
import com.test.service.TestService;
import com.test.vo.Test01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    Test01Repository test01Repository;

    @RequestMapping("/testJspList")
    public ModelAndView testJspList(){

        boolean ran = new Random().nextBoolean();

        Object testList = null;
        if(ran){
            testList = testService.selectTest(null);
        }else{
            testList = test01Repository.findAll();//erp 개발
        }

        ModelAndView modelAndView = new ModelAndView("jsp/test/testList.jsp");
        modelAndView.addObject("list",testList);

        return modelAndView;
    }

    @RequestMapping(value = "/testJspInfo",method = RequestMethod.GET)
    public ModelAndView testJspInfo(HttpServletRequest request){

        String seq = request.getParameter("seq");
        ModelAndView modelAndView = new ModelAndView("jsp/test/testInfo.jsp");

        if(!"".equals(seq) && seq !=null){
            List<Test01VO> testInfo = testService.selectTest(seq);

            if(!testInfo.isEmpty() && testInfo != null){
                modelAndView.addObject("info",testInfo.get(0));
            }
        }
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/test/saveTest")
    public int saveTest(@RequestBody Map<String,Object> map, HttpServletRequest request){

        if(!"".equals(map.get("seq")) && map.get("seq") != null){
            return testService.updateTest(map);
        }else{
            return testService.insertTest(map);
        }
    }

    @ResponseBody
    @DeleteMapping("/test/deleteTest")
    public int deleteTest(@RequestBody Map<String,Object> map, HttpServletRequest request){

        return testService.deleteTest(map);
    }
}
