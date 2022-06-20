package com.yangtao.irpc.core.filter;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;

import java.util.List;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter
 * @Version: 1.0
 */
public interface IClientFilter extends IFilter {

    void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation);
}
