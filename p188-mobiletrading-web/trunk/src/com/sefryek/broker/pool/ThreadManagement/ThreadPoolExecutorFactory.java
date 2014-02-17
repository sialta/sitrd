package com.sefryek.broker.pool.ThreadManagement;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 12, 2011
 * Time: 11:19:35 AM
 */
public class ThreadPoolExecutorFactory {

    public ThreadPoolExecutorFactory() {}

    private static class ThreadPoolExecutorHolder {
        private static int THREAD_COUNT = 200;
        private static int MAX_POOL_SIZE = 400;
        private final static ThreadPoolExecutor pool = new ThreadPoolExecutor(THREAD_COUNT, MAX_POOL_SIZE, 15,
                TimeUnit.SECONDS, new LinkedBlockingQueue(2));
    }

    public static ThreadPoolExecutor getInstance() {
        return ThreadPoolExecutorHolder.pool;
    }

}
