package com.yangtao.irpc.core.filter.client;

import com.yangtao.irpc.core.common.ChannelFutureWrapper;
import com.yangtao.irpc.core.common.RpcInvocation;
import com.yangtao.irpc.core.common.utils.CommonUtils;
import com.yangtao.irpc.core.filter.IClientFilter;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.filter.client
 * @Version: 1.0
 */
public class DirectInvokeFilterImpl implements IClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String url = (String) rpcInvocation.getAttachments().get("url");
        if(CommonUtils.isEmpty(url)){
            return;
        }
        Iterator<ChannelFutureWrapper> channelFutureWrapperIterator = src.iterator();
        while (channelFutureWrapperIterator.hasNext()){
            ChannelFutureWrapper channelFutureWrapper = channelFutureWrapperIterator.next();
            if(!(channelFutureWrapper.getHost()+":"+channelFutureWrapper.getPort()).equals(url)){
                channelFutureWrapperIterator.remove();
            }
        }
        if(CommonUtils.isEmptyList(src)){
            throw new RuntimeException("no match provider url for "+ url);
        }
    }
}
