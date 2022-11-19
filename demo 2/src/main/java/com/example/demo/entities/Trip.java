package com.example.demo.entities;

public class Trip {
    private Integer source;
    private Integer destination;
    private Integer price;
    private String rider_name;
    private String driver_name;
    private String cab_number;

    String[] tripInfo = new String[6];
    public Trip(Integer source, Integer destination, Integer price, String rider_name, String driver_name,String cab_number) {
        this.source=source;
        this.destination=destination;
        this.price=price;
        this.rider_name=rider_name;
        this.driver_name=driver_name;
        this.cab_number=cab_number;
    }

    public String[] getValue() {
        tripInfo[0]=this.source.toString();
        tripInfo[1]=this.destination.toString();
        tripInfo[2]=this.price.toString();
        tripInfo[3]=this.rider_name;
        tripInfo[4]=this.driver_name;
        tripInfo[5]=this.cab_number;
        return this.tripInfo;
    }
    @Override
    public String toString() {
        return "trip{" +
                "source=" + source +
                ", destination=" + destination +
                ", price=" + price +
                ", rider_name=" + rider_name +
                ", driver_name=" + driver_name +
                ", cab_number='" + cab_number + '\'' +
                '}';

    }
}
