package com.mtpv.manohar.my_vehicle_wallet.model;

import java.io.Serializable;

/**
 * Created by MANOHAR on 5/12/2017.
 */

public class PendingChallansPojo implements Serializable{

    public String ChallanNo;
    public String UnitName;
    public String PSLimits;
    public String Location;
    public String ViolationDate;
    public String ViolationTime;
    public String PaymentStatus;
    public String Violation;
    public String Fine;
    public String UserCharges;
    public String TotalFine;


    public String getChallanNo() {
        return ChallanNo;
    }

    public void setChallanNo(String challanNo) {
        ChallanNo = challanNo;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getPSLimits() {
        return PSLimits;
    }

    public void setPSLimits(String PSLimits) {
        this.PSLimits = PSLimits;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getViolationDate() {
        return ViolationDate;
    }

    public void setViolationDate(String violationDate) {
        ViolationDate = violationDate;
    }

    public String getViolationTime() {
        return ViolationTime;
    }

    public void setViolationTime(String violationTime) {
        ViolationTime = violationTime;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public String getViolation() {
        return Violation;
    }

    public void setViolation(String violation) {
        Violation = violation;
    }

    public String getFine() {
        return Fine;
    }

    public void setFine(String fine) {
        Fine = fine;
    }

    public String getUserCharges() {
        return UserCharges;
    }

    public void setUserCharges(String userCharges) {
        UserCharges = userCharges;
    }

    public String getTotalFine() {
        return TotalFine;
    }

    public void setTotalFine(String totalFine) {
        TotalFine = totalFine;
    }




}
