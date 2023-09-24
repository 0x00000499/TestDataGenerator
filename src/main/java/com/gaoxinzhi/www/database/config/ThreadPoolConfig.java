package com.gaoxinzhi.www.database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {
    @Value("${data.thread.core-num}")
    int coreNum;
    @Value("${data.thread.max-num}")
    int maxNum;
    @Value("${data.thread.keep-alive-time}")
    int keepAliveTime;
    @Value("${data.thread.block-queue-length}")
    int blockQueueLen;
    @Bean
    public ThreadPoolExecutor InjectThreadPool(){
        return new ThreadPoolExecutor(coreNum, maxNum, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(blockQueueLen));
    }
}
