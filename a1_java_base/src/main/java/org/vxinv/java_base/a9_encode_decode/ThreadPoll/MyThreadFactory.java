package org.vxinv.java_base.a9_encode_decode.ThreadPoll;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixin
 * @date 2021/6/23
 * @description:
 */
public  class MyThreadFactory {

    public static class SelfDefinedThreadFactory implements ThreadFactory {
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public SelfDefinedThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix+"-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread( r,namePrefix + threadNumber.getAndIncrement());
            if (t.isDaemon()) {
                t.setDaemon(true);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}
