package com.yangtao.irpc.core.proxy.jdk;

import com.yangtao.irpc.core.proxy.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.proxy.jdk
 * @Version: 1.0
 */
public class JDKProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(final Class clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new JDKClientInvocationHandler(clazz));
    }

}