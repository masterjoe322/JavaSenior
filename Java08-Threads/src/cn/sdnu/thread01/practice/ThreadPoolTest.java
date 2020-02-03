package cn.sdnu.thread01.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 11:04 PM
 */

/**
 * this class is the sum of odd number from 0 to 100
 */
class OddThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
        return sum;
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;

        service.setCorePoolSize(3);
        service.setKeepAliveTime(1, TimeUnit.SECONDS);
        Future submit = executorService.submit(new OddThread());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + "I like Yanqiu");
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        sum += i;
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    }
                }
                System.out.println("sum = " + sum);
            }
        });
//        executorService.shutdown();
        System.out.println(submit.get());
    }
}
