package com.minghui.entity.defaults.oauth.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;

public class OauthClientServer extends BaseModel implements Serializable {

    private static final long serialVersionUID = 4479750541464669696L;

    /**
     * 应用标识
     */
    private Integer clientId;

    /**
     * 服务权限标识
     */
    private Integer serviceId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}