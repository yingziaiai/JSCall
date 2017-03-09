package com.restfull.callTest;
/**
 * Created by fionalyn.ping.fu on 2/24/2017.
 */
public class SessionDomain {


    public String memberId;
    public String appCode;
    public String token;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
