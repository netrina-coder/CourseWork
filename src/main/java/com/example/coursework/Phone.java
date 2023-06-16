package com.example.coursework;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {
    private int ID;
    private String surname;
    private String name;
    private String middlename;
    private int accountNumber;
    private float timeForTownTalks;
    private float longDistanceCallTime;
    public Phone (int ID, String surname,String name, String middlename,
                  int accountNumber, float timeForTownTalks, float longDistanceCallTime ){
        this.ID= ID;
        this.surname=surname;
        this.name=name;
        this.middlename=middlename;
        this.accountNumber=accountNumber;
        this.timeForTownTalks=timeForTownTalks;
        this.longDistanceCallTime=longDistanceCallTime;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMiddlename() {
        return middlename;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public float getTimeForTownTalks() {
        return timeForTownTalks;
    }
    public void setTimeForTownTalks (float timeForTownTalks) {
        this.timeForTownTalks=timeForTownTalks;
    }
    public float getLongDistanceCallTime(){return longDistanceCallTime;}
    public void setLongDistanceCallTime (float longDistanceCallTime){
        this.longDistanceCallTime=longDistanceCallTime;
    }

    public String toString(){
        return "Phone{" + "ID=" + ID +  ",surname=' " + surname +  '\''  +",name='" + name +
                '\'' + ",middlename='"   + middlename +     '\'' + ",account number='" + accountNumber +  '\''
                + ",time for town talks=" + timeForTownTalks + ",long distance call time=" + longDistanceCallTime + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Phone other = (Phone) obj;
        return ID == other.ID &&
                Objects.equals(surname, other.surname) &&
                Objects.equals(name, other.name) &&
                Objects.equals(middlename, other.middlename) &&
                accountNumber == other.accountNumber &&
                Float.compare(timeForTownTalks, other.timeForTownTalks) == 0 &&
                Float.compare(longDistanceCallTime, other.longDistanceCallTime) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, surname, name, middlename, accountNumber, timeForTownTalks, longDistanceCallTime);
    }


}
