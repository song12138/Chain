package ShutDownHook;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 1）程序正常退出
 2）使用System.exit()
 3）终端使用Ctrl+C触发的中断
 4）系统关闭
 5）使用Kill pid命令干掉进程
 注：在使用kill -9 pid是不会JVM注册的钩子不会被调用。
 * Created by paul on 2018/1/9.
 */
public class HookTest {
    //简单模拟干活的
    static Timer timer = new Timer("job");


    //计数干活次数
    static AtomicInteger integer = new AtomicInteger(0);

    /**
     * hook线程
     */
    static class CleanWorkThread extends Thread {
        @Override
        public void run() {
            System.out.println("清除任务");
            timer.cancel();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        //将hook线程添加到运行时环境中去
        Runtime.getRuntime().addShutdownHook(new CleanWorkThread());
        System.out.println("主线程工作");

        //简单模拟
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                integer.getAndIncrement();
                System.out.println("任务"+integer);
                if (integer.get() == 10) {  //干了10次退出
                    System.exit(0);
                }
            }
        },0,2000);



    }

}
