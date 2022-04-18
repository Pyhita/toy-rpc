package com.yangtao.irpc.core.common.event;

/**
 * @Author: pyhita
 * @Date: 2022/4/4
 * @Descrption: com.yangtao.irpc.core.common.event
 * @Version: 1.0
 */
public interface IRpcEvent {

    Object getData();

    IRpcEvent setData(Object data);
}