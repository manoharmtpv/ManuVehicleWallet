package com.mtpv.manohar.my_vehicle_wallet.model;

import java.io.Serializable;

/**
 * Created by MANOHAR on 5/10/2017.
 */

public class AadharDetailsPojo implements Serializable {

    public String Name;
    public String CareOf;
    public String BildingName;
    public String Street;
    public String Village;
    public String Mandal;
    public String District;
    public String pinCode;
    public String MobileNo;
    public String Gender;
    public String DOB;
    public String UID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCareOf() {
        return CareOf;
    }

    public void setCareOf(String careOf) {
        CareOf = careOf;
    }

    public String getBildingName() {
        return BildingName;
    }

    public void setBildingName(String bildingName) {
        BildingName = bildingName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getVillage() {
        return Village;
    }

    public void setVillage(String village) {
        Village = village;
    }

    public String getMandal() {
        return Mandal;
    }

    public void setMandal(String mandal) {
        Mandal = mandal;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getAadhaarPhoto() {
        return AadhaarPhoto;
    }

    public void setAadhaarPhoto(String aadhaarPhoto) {
        AadhaarPhoto = aadhaarPhoto;
    }

    public String EID;
    public String AadhaarPhoto;




}




