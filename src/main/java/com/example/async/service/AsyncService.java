package com.example.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author CJM
 * @Date 2021-05-30  14:36
 */
@Service
public class AsyncService {
    @Async
    public void async(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("数据正在传送！");
    }
}
