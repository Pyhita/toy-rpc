package com.yangtao.irpc.core.filter;

import com.yangtao.irpc.core.common.RpcInvocation;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter
 * @Version: 1.0
 */
public interface IServerFilter extends IFilter {

    /**
     * 执行业务的核心逻辑
     */
    void doFilter(RpcInvocation rpcInvocation);
}
