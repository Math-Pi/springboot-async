package com.example.async.controller;

import com.example.async.runnable.RunnableTask;
import com.example.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author CJM
 * @Date 2021-05-30  14:33
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/async")
    public String asyncTest(){
        asyncService.async();
        return "使用注解进行异步任务处理...";
    }

    @RequestMapping("/thread")
    public String threadTest(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new RunnableTask());
        return "使用线程池进行异步任务处理...";
    }
}
