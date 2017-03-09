package com.restfull.callTest;

public class User {


	public String userName;
    public String userId;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId
				+ ", toString()=" + super.toString() + "]";
	}
    
}
