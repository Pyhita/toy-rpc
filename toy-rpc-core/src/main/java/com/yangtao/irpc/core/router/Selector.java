package com.yangtao.irpc.core.router;

/**
 * @Author: pyhita
 * @Date: 2022/4/12
 * @Descrption: com.yangtao.irpc.core.router
 * @Version: 1.0
 */
public class Selector {

    /**
     * 服务命名
     * eg: com.sise.test.DataService
     */
    private String providerServiceName;


    public String getProviderServiceName() {
        return providerServiceName;
    }

    public void setProviderServiceName(String providerServiceName) {
        this.providerServiceName = providerServiceName;
    }
}