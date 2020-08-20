package com.minghui.entity.defaults.oauth.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;

public class OauthClientDetails extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5291356039927454720L;

    /**
     * 主键
     */
    private Integer oauthClientDetailsId;

    /**
     * 应用标识
     */
    private String clientId;

    /**
     * 资源限定串(逗号分割)
     */
    private String resourceIds;

    /**
     * 应用密钥(bcyt) 加密
     */
    private String clientSecret;

    /**
     * 应用密钥(明文)
     */
    private String clientSecretStr;

    /**
     * 范围
     */
    private String scope;

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    private String authorizedGrantTypes;

    /**
     * 回调地址 
     */
    private String webServerRedirectUri;

    /**
     * 权限
     */
    private String authorities;

    /**
     * access_token有效期
     */
    private Integer accessTokenValidity;

    /**
     * refresh_token有效期
     */
    private Integer refreshTokenValidity;

    /**
     * {}
     */
    private String additionalInformation;

    /**
     * 是否自动授权 是-true
     */
    private String autoapprove;

    public Integer getOauthClientDetailsId() {
        return oauthClientDetailsId;
    }

    public void setOauthClientDetailsId(Integer oauthClientDetailsId) {
        this.oauthClientDetailsId = oauthClientDetailsId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecretStr() {
        return clientSecretStr;
    }

    public void setClientSecretStr(String clientSecretStr) {
        this.clientSecretStr = clientSecretStr;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}