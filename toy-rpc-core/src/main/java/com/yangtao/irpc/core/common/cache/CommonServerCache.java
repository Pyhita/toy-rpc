package com.yangtao.irpc.core.common.cache;

import com.yangtao.irpc.core.common.config.ServerConfig;
import com.yangtao.irpc.core.filter.server.ServerFilterChain;
import com.yangtao.irpc.core.registy.RegistryService;
import com.yangtao.irpc.core.registy.URL;
import com.yangtao.irpc.core.serialize.SerializeFactory;
import com.yangtao.irpc.core.server.ServiceWrapper;
import io.netty.util.internal.ConcurrentSet;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.common.cache
 * @Version: 1.0
 */
public class CommonServerCache {

    public static final Map<String,Object> PROVIDER_CLASS_MAP = new ConcurrentHashMap<>();
    public static final Set<URL> PROVIDER_URL_SET = new ConcurrentSet<>();
    public static RegistryService REGISTRY_SERVICE;
    public static SerializeFactory SERVER_SERIALIZE_FACTORY;
    public static ServerConfig SERVER_CONFIG;
    public static ServerFilterChain SERVER_FILTER_CHAIN;
    public static final Map<String, ServiceWrapper> PROVIDER_SERVICE_WRAPPER_MAP = new ConcurrentHashMap<>();
}