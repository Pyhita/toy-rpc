package com.yangtao.irpc.core.common;

import java.util.concurrent.atomic.AtomicLong;

import static com.yangtao.irpc.core.common.cache.CommonClientCache.SERVICE_ROUTER_MAP;

/**
 * @Author: pyhita
 * @Date: 2022/4/12
 * @Descrption: com.yangtao.irpc.core.common
 * @Version: 1.0
 */
public class ChannelFuturePollingRef {

    private AtomicLong referenceTimes = new AtomicLong(0);


    public ChannelFutureWrapper getChannelFutureWrapper(String serviceName){
        ChannelFutureWrapper[] arr = SERVICE_ROUTER_MAP.get(serviceName);
        long i = referenceTimes.getAndIncrement();
        int index = (int) (i % arr.length);
        return arr[index];
    }

}