package com.e.bhartiyaparivar.model;

public class SendOTP {
    private String mobileNo;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public SendOTP(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
