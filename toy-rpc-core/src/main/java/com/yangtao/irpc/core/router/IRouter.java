package com.yangtao.irpc.core.router;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.registy.URL;


/**
 * @Author: pyhita
 * @Date: 2022/4/12
 * @Descrption: com.yangtao.irpc.core.router
 * @Version: 1.0
 */
public interface IRouter {


    /**
     * 刷新路由数组
     *
     * @param selector
     */
    void refreshRouterArr(Selector selector);

    /**
     * 获取到请求到连接通道
     *
     * @return
     */
    ChannelFutureWrapper select(Selector selector);

    /**
     * 更新权重信息
     *
     * @param url
     */
    void updateWeight(URL url);
}
