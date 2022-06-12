package org.vxinv.java_base.a5_juc.ScheduledExecutorService_Demo;

import java.util.Timer;
import java.util.TimerTask;

public class BasicTimer {
    static class DelayTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("delayed task");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new DelayTask(), 1000);
        Thread.sleep(2000);
        timer.cancel();
    }
}
