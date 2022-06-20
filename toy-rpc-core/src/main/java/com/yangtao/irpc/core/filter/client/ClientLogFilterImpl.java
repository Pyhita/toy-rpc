package com.yangtao.irpc.core.filter.client;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.common.config.ClientConfig;
import com.yangtao.irpc.core.filter.IClientFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.yangtao.irpc.core.common.cache.CommonClientCache.CLIENT_CONFIG;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.client
 * @Version: 1.0
 */
public class ClientLogFilterImpl implements IClientFilter {

    static final Logger LOGGER = LoggerFactory.getLogger(ClientLogFilterImpl.class);


    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        rpcInvocation.getAttachments().put("cpp_app_name", CLIENT_CONFIG.getApplicationName());
        LOGGER.info(rpcInvocation.getAttachments().get("c_app_name")+" do invoke -----> "+rpcInvocation.getTargetServiceName());
    }
}
