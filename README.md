# Spring Boot异步处理任务

> 同步：一定要等任务执行完了，得到结果，才执行下一个任务。 
>
> 异步：不等任务执行完，直接执行下一个任务。

## 1.异步方式一

> 1.启动类使用@EnableAsync开启异步；
>
> 2.定义Spring组件，使用@Component(或Service)和@Async。

### Service

```java
@Service
public class AsyncService {
    @Async
    public void async(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("数据正在传输！");
    }
}
```

### controller

```java
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String asyncTest(){
        asyncService.hello();
        return "OK";
    }
}
```

前端输出“使用注解进行异步任务处理...”,5秒后后台输出“数据正在传送！”。

## 2.异步方式二

> 1.使用Executors创建线程池；
>
> 2.调用ExecutorService.execute(Runnable command)方法。

### Runnable

```java
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
```

### controller

```java
@RestController
public class AsyncController {
    @RequestMapping("/thread")
    public String threadTest(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new RunnableTask());
        return "使用线程池进行异步任务处理...";
    }
}
```

前端输出“使用线程池进行异步任务处理...”,5秒后后台输出“数据正在传送！”。