package com.yangtao.irpc.core.registy.zookeeper;

/**
 * @Author: pyhita
 * @Date: 2022/4/3
 * @Descrption: com.yangtao.irpc.core.registy.zookeeper
 * @Version: 1.0
 */
public class ProviderNodeInfo {

    private String serviceName;

    private String address;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ProviderNodeInfo{" +
                "serviceName='" + serviceName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}