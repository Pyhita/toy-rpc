package com.yangtao.irpc.core.common.event.listener;

import com.yangtao.irpc.core.client.ConnectionHandler;
import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.event.IRpcListener;
import com.yangtao.irpc.core.common.event.IRpcUpdateEvent;
import com.yangtao.irpc.core.common.event.data.URLChangeWrapper;
import com.yangtao.irpc.core.common.utils.CommonUtils;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.yangtao.irpc.core.common.cache.CommonClientCache.CONNECT_MAP;

/**
 * @Author: pyhita
 * @Date: 2022/4/4
 * @Descrption: com.yangtao.irpc.core.common.event.listener
 * @Version: 1.0
 */
public class ServiceUpdateListener implements IRpcListener<IRpcUpdateEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceUpdateListener.class);

    @Override
    public void callBack(Object t) {
        //获取到字节点的数据信息
        URLChangeWrapper urlChangeWrapper = (URLChangeWrapper) t;
        List<ChannelFutureWrapper> channelFutureWrappers = CONNECT_MAP.get(urlChangeWrapper.getServiceName());
        if (CommonUtils.isEmptyList(channelFutureWrappers)) {
            LOGGER.error("[ServiceUpdateListener] channelFutureWrappers is empty");
            return;
        } else {
            List<String> matchProviderUrl = urlChangeWrapper.getProviderUrl();
            Set<String> finalUrl = new HashSet<>();
            List<ChannelFutureWrapper> finalChannelFutureWrappers = new ArrayList<>();
            for (ChannelFutureWrapper channelFutureWrapper : channelFutureWrappers) {
                String oldServerAddress = channelFutureWrapper.getHost() + ":" + channelFutureWrapper.getPort();
                //如果老的url没有，说明已经被移除了
                if (!matchProviderUrl.contains(oldServerAddress)) {
                    continue;
                } else {
                    finalChannelFutureWrappers.add(channelFutureWrapper);
                    finalUrl.add(oldServerAddress);
                }
            }

            //此时老的url已经被移除了，开始检查是否有新的url
            List<ChannelFutureWrapper> newChannelFutureWrapper = new ArrayList<>();
            for (String newProviderUrl : matchProviderUrl) {
                if (!finalUrl.contains(newProviderUrl)) {
                    ChannelFutureWrapper channelFutureWrapper = new ChannelFutureWrapper();
                    String host = newProviderUrl.split(":")[0];
                    Integer port = Integer.valueOf(newProviderUrl.split(":")[1]);
                    channelFutureWrapper.setPort(port);
                    channelFutureWrapper.setHost(host);
                    ChannelFuture channelFuture = null;
                    try {
                        channelFuture = ConnectionHandler.createChannelFuture(host,port);
                        channelFutureWrapper.setChannelFuture(channelFuture);
                        newChannelFutureWrapper.add(channelFutureWrapper);
                        finalUrl.add(newProviderUrl);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            finalChannelFutureWrappers.addAll(newChannelFutureWrapper);
            //最终更新服务在这里，更新缓存信息
            CONNECT_MAP.put(urlChangeWrapper.getServiceName(),finalChannelFutureWrappers);
        }
    }
}
