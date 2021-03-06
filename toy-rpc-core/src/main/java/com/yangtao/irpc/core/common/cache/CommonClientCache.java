package com.yangtao.irpc.core.common.cache;

import com.yangtao.irpc.core.common.ChannelFuturePollingRef;
import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.common.config.ClientConfig;
import com.yangtao.irpc.core.filter.client.ClientFilterChain;
import com.yangtao.irpc.core.registy.URL;
import com.yangtao.irpc.core.router.IRouter;
import com.yangtao.irpc.core.serialize.SerializeFactory;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.common.cache
 * @Version: 1.0
 */
public class CommonClientCache {
    // 阻塞队列，专门一个线程轮询队列，完成发送任务
    public static BlockingQueue<RpcInvocation> SEND_QUEUE = new ArrayBlockingQueue(100);
    // uuid <-> response
    public static Map<String, Object> RESP_MAP = new ConcurrentHashMap<>();
    //provider名称 --> 该服务有哪些集群URL
    public static List<URL> SUBSCRIBE_SERVICE_LIST = new ArrayList<>();
    //com.sise.test.service -> <<ip:host,urlString>,<ip:host,urlString>,<ip:host,urlString>>
    public static Map<String, Map<String,String>> URL_MAP = new ConcurrentHashMap<>();
    public static Set<String> SERVER_ADDRESS = new HashSet<>();
    //每次进行远程调用的时候都是从这里面去选择服务提供者
    public static Map<String, List<ChannelFutureWrapper>> CONNECT_MAP = new ConcurrentHashMap<>();
    //随机请求的map
    public static Map<String, ChannelFutureWrapper[]> SERVICE_ROUTER_MAP = new ConcurrentHashMap<>();
    public static ChannelFuturePollingRef CHANNEL_FUTURE_POLLING_REF = new ChannelFuturePollingRef();
    public static IRouter IROUTER;

    public static SerializeFactory CLIENT_SERIALIZE_FACTORY;
    public static ClientConfig CLIENT_CONFIG;
    public static ClientFilterChain CLIENT_FILTER_CHAIN ;
}