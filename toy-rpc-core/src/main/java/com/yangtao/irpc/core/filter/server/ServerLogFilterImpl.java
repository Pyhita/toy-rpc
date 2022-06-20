package com.yangtao.irpc.core.filter.server;

import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.filter.IServerFilter;
import com.yangtao.irpc.core.serialize.SerializeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.server
 * @Version: 1.0
 */
public class ServerLogFilterImpl implements IServerFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerLogFilterImpl.class);

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        System.out.println(rpcInvocation.getAttachments().get("c_app_name") + " do invoke -----> " +
                rpcInvocation.getTargetServiceName() + "#" +
                rpcInvocation.getTargetMethod());
    }
}
