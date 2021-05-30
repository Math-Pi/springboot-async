package com.example.async.runnable;

/**
 * @Author CJM
 * @Date 2021-05-30  14:46
 */
public class RunnableTask implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("数据正在传送！");
    }
}
