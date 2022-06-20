package com.yangtao.irpc.core.filter.client;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.common.utils.CommonUtils;
import com.yangtao.irpc.core.filter.IClientFilter;

import java.util.List;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.client
 * @Version: 1.0
 */
public class GroupFilterImpl implements IClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String group = String.valueOf(rpcInvocation.getAttachments().get("group"));
        for (ChannelFutureWrapper channelFutureWrapper : src) {
            if (!channelFutureWrapper.getGroup().equals(group)) {
                src.remove(channelFutureWrapper);
            }
        }
        if (CommonUtils.isEmptyList(src)) {
            throw new RuntimeException("no provider match for group " + group);
        }
    }
}