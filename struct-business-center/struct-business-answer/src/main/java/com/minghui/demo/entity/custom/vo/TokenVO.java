package com.minghui.demo.entity.custom.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mh
 * @version 1.0
 * @description token 信息
 * @date 2020/8/20 16:22
 **/
@Data
public class TokenVO implements Serializable {

    public TokenVO() {
    }

    public TokenVO(String tokenHead, String token) {
        this.tokenHead = tokenHead;
        this.token = token;
    }

    /*token头*/
    private String tokenHead;

    /*token*/
    private String token;
}
