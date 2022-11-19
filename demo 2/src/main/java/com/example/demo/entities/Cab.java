package com.example.demo.entities;

public class Cab {
    public String getDriver_name() {
        return driver_name;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    private String driver_name;
    private String type;
    private String number;

    String[] cabInfo = new String[3];
    public Cab(String driver_name, String type, String number){
        this.driver_name=driver_name;
        this.type=type;
        this.number=number;
    }
    public String[] getValue(){
        cabInfo[0]=this.driver_name;
        cabInfo[1]=this.type;
        cabInfo[2]=this.number;
        return this.cabInfo;
    }
    @Override
    public String toString() {
//        return User;
        return "cab{" +
                "driverName=" + driver_name +
                ", CabType=" + type +
                ", CabNumber='" + number + '\'' +
                '}';

    }


}
