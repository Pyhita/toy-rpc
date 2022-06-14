package com.yangtao.irpc.core.serialize;

import java.io.Serializable;

/**
 * @Author: pyhita
 * @Date: 2022/6/14
 * @Descrption: com.yangtao.irpc.core.serialize
 * @Version: 1.0
 */

/**
 * 测试自定义序列化类
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1728196331321496561L;
    private Integer id;

    private Long tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel=" + tel +
                '}';
    }

}