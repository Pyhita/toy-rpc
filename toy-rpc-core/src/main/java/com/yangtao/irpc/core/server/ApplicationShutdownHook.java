package com.yangtao.irpc.core.server;

import com.yangtao.irpc.core.common.event.IRpcDestroyEvent;
import com.yangtao.irpc.core.common.event.IRpcListenerLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.server
 * @Version: 1.0
 */

// 监听Java进程被关闭
public class ApplicationShutdownHook {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationShutdownHook.class);

    /**
     * 注册一个shutdownHook的钩子，当jvm进程被关闭的时候触发
     */
    public static void registryShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("[registryShutdownHook] ==== ");
                IRpcListenerLoader.sendSyncEvent(new IRpcDestroyEvent("destroy"));
                System.out.println("destory");
            }
        }));
    }

}
