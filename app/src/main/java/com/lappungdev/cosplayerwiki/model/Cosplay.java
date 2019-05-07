package com.lappungdev.cosplayerwiki.model;

public class Cosplay {
    private String cosplayBirthday;
    private String cosplayCountry;
    private String cosplayID;
    private String cosplayGender;
    private String cosplayNickname;
    private String cosplayPhoto;
    private String cosplayZID;

    public Cosplay(String cosplayBirthday, String cosplayCountry, String cosplayID, String cosplayGender, String cosplayNickname, String cosplayPhoto, String cosplayZID) {
        this.cosplayBirthday = cosplayBirthday;
        this.cosplayCountry = cosplayCountry;
        this.cosplayID = cosplayID;
        this.cosplayGender = cosplayGender;
        this.cosplayNickname = cosplayNickname;
        this.cosplayPhoto = cosplayPhoto;
        this.cosplayZID = cosplayZID;
    }

    public String getCosplayBirthday() {
        return cosplayBirthday;
    }

    public void setCosplayBirthday(String cosplayBirthday) {
        this.cosplayBirthday = cosplayBirthday;
    }

    public String getCosplayCountry() {
        return cosplayCountry;
    }

    public void setCosplayCountry(String cosplayCountry) {
        this.cosplayCountry = cosplayCountry;
    }

    public String getCosplayID() {
        return cosplayID;
    }

    public void setCosplayID(String cosplayID) {
        this.cosplayID = cosplayID;
    }

    public String getCosplayGender() {
        return cosplayGender;
    }

    public void setCosplayGender(String cosplayGender) {
        this.cosplayGender = cosplayGender;
    }

    public String getCosplayNickname() {
        return cosplayNickname;
    }

    public void setCosplayNickname(String cosplayNickname) {
        this.cosplayNickname = cosplayNickname;
    }

    public String getCosplayPhoto() {
        return cosplayPhoto;
    }

    public void setCosplayPhoto(String cosplayPhoto) {
        this.cosplayPhoto = cosplayPhoto;
    }

    public String getCosplayZID() {
        return cosplayZID;
    }

    public void setCosplayZID(String cosplayZID) {
        this.cosplayZID = cosplayZID;
    }
}
