package com.yangtao.irpc.core.common;

import java.io.Serializable;
import java.util.Arrays;

import static com.yangtao.irpc.core.common.constants.RpcConstants.MAGIC_NUMBER;

/**
 * @Author: pyhita
 * @Date: 2022/3/30
 * @Descrption: com.yangtao.irpc.core.common
 * @Version: 1.0
 *
 * 网络传输协议格式：魔数（用来判断是否是本协议内容）+ length（防止传输的数据过大以及粘包等）
 *  + content（具体的内容：将RpcInvocation对象序列化之后的字节数组）
 */
public class RpcProtocol implements Serializable {

    private static final long serialVersionUID = 5359096060555795690L;

    private short magicNumber = MAGIC_NUMBER;

    private int contentLength;

    private byte[] content;

    public RpcProtocol(byte[] content) {
        this.contentLength = content.length;
        this.content = content;
    }

    public short getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(short magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RpcProtocol{" +
                "contentLength=" + contentLength +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}