package com.yangtao.irpc.core.filter.client;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.filter.IClientFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.client
 * @Version: 1.0
 */
public class ClientFilterChain {

    private static List<IClientFilter> iClientFilterList = new ArrayList<>();

    public void addClientFilter(IClientFilter iClientFilter) {
        iClientFilterList.add(iClientFilter);
    }

    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        for (IClientFilter iClientFilter : iClientFilterList) {
            iClientFilter.doFilter(src, rpcInvocation);
        }
    }
}
