package com.yangtao.irpc.core.common;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.common
 * @Version: 1.0
 */

// 封装了具体的请求数据：目标方法+目标类+参数+uuid+response对象
public class RpcInvocation {

    private String targetMethod;

    private String targetServiceName;

    private Object[] args;

    public Map<String, Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, Object> attachments) {
        this.attachments = attachments;
    }

    private String uuid;

    private Object response;

    private Map<String, Object> attachments = new ConcurrentHashMap<>();

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetServiceName() {
        return targetServiceName;
    }

    public void setTargetServiceName(String targetServiceName) {
        this.targetServiceName = targetServiceName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }


    @Override
    public String toString() {
        return "RpcInvocation{" +
                "targetMethod='" + targetMethod + '\'' +
                ", targetServiceName='" + targetServiceName + '\'' +
                ", args=" + Arrays.toString(args) +
                ", uuid='" + uuid + '\'' +
                ", response=" + response +
                '}';
    }

    public static void main(String[] args) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        Map.Entry<Integer, int[]> entry = map.floorEntry(1);

    }
}