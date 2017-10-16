package com.example.serializationClass;
/**
 * Created by Mayur on 08-10-2017.
 */
public class SerializeUserData
{
    private String RollNumber;
    private String FingerPrint;
    private Boolean Authenticated;


    public SerializeUserData(){

    }
    public SerializeUserData(String rollNumber, String fingerPrint) {
        RollNumber = rollNumber;
        FingerPrint = fingerPrint;
        Authenticated = Boolean.TRUE;
    }

    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }

    public String getFingerPrint() {
        return FingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        FingerPrint = fingerPrint;
    }

    public Boolean getAuthenticated() {
        return Authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.Authenticated = authenticated;
    }
}
