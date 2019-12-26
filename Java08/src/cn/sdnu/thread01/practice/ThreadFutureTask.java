package cn.sdnu.thread01.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * The third method to create a new thread
 * @author Master_Joe qiaoguangtong@aliyun.com
 */

class NumberThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": i = " + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadFutureTask {

    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        FutureTask futureTask = new FutureTask(numberThread);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Object o = futureTask.get();
            System.out.println("sum = " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
