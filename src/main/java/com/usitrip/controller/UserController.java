package com.usitrip.controller;

import com.usitrip.pojo.Hotel;
import com.usitrip.pojo.User;
import com.usitrip.service.UserService;
import com.usitrip.test.AyTestJob;
import com.usitrip.test.ScheduleEmailJob;
import com.usitrip.utils.TestJob;
import org.apache.ibatis.annotations.Result;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/testCode")
    @ResponseBody
    public void testCode() throws SchedulerException, ParseException {
        System.out.println("UserController.test!!!中文乱码");
//        new TestJob().doSomething();

//        JobDetail job = JobBuilder.newJob(AyTestJob.class)
//                .withIdentity("dummyJobName", "group1").build();
//
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("dummyTriggerName", "group1")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
//                .build();
//
//        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//        scheduler.getContext().put("time", new Date().getTime());
//        scheduler.start();
//        scheduler.scheduleJob(job, trigger);

//        return "";

    }

    @RequestMapping("login")
    public String login(@ModelAttribute Hotel hotel) {
        System.out.println(hotel.getHotelId());
        System.out.println("UserController.login");
        return "login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String testSave(@RequestBody Hotel hotel) throws IOException {
        int[] ints = IntStream.range(0, 5)
                .filter(n -> n > 3).map(e -> e * 10).toArray();
        System.out.println(hotel.getHotelId());
        return "ok";
    }
}
