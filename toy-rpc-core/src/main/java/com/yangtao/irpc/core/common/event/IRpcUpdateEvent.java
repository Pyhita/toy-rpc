package com.yangtao.irpc.core.common.event;

/**
 * @Author: pyhita
 * @Date: 2022/4/4
 * @Descrption: com.yangtao.irpc.core.common.event
 * @Version: 1.0
 */
public class IRpcUpdateEvent implements IRpcEvent {

    private Object data;

    public IRpcUpdateEvent(Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public IRpcEvent setData(Object data) {
        this.data = data;
        return this;
    }
}