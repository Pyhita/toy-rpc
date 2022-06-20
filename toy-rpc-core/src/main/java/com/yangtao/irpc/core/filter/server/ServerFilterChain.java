package com.yangtao.irpc.core.filter.server;

import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.filter.IServerFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.server
 * @Version: 1.0
 */
public class ServerFilterChain {

    private static List<IServerFilter> iServerFilters = new ArrayList<>();

    public void addServerFilter(IServerFilter iServerFilter) {
        iServerFilters.add(iServerFilter);
    }

    public void doFilter(RpcInvocation rpcInvocation) {
        for (IServerFilter iServerFilter : iServerFilters) {
            iServerFilter.doFilter(rpcInvocation);
        }
    }

}
