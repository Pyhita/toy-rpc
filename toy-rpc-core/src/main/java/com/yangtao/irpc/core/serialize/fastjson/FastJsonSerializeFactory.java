package com.yangtao.irpc.core.serialize.fastjson;

import com.alibaba.fastjson.JSON;
import com.yangtao.irpc.core.serialize.SerializeFactory;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.serialize.fastjson
 * @Version: 1.0
 */
public class FastJsonSerializeFactory implements SerializeFactory {

    @Override
    public <T> byte[] serialize(T t) {
        String jsonStr = JSON.toJSONString(t);
        return jsonStr.getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data),clazz);
    }

}