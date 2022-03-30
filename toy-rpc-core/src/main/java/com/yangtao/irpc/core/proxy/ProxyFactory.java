package com.yangtao.irpc.core.proxy;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.proxy
 * @Version: 1.0
 */
public interface ProxyFactory {

    <T> T getProxy(final Class clazz) throws Throwable;
}