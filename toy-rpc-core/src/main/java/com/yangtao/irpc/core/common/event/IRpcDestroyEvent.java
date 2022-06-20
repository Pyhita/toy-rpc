package com.yangtao.irpc.core.common.event;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.common.event
 * @Version: 1.0
 */
// 服务销毁事件
public class IRpcDestroyEvent implements IRpcEvent{

    private Object data;

    public IRpcDestroyEvent(Object data) {
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