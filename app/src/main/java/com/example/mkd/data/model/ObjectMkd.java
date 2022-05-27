package com.example.mkd.data.model;

import java.io.Serializable;
import java.util.Date;

public class ObjectMkd implements Serializable {

    private Long    id;
    private String  houseNumber;
    private String  houseBlock;
    private String  seria;
    private int 	year;
    private float 	square;
    private int 	houseDoorsCount;
    private int 	minFloorCount;
    private int	 	maxFloorCount;
    private int 	accountsCount;
    private int 	personsCount;
    private int 	flatsCount;
    private int 	roomsCount;
    private float 	areaSquare;
    private String  firstPrivatisationDate;
    private String 	created_at;
    private AddressDTO address;
    private RepairDataDTO repair;
    private CommunicationDTO communication;
    public ObjectMkd(int i, String toString, String selectedItem, String selectedItem1, Object o) {
    }

    public ObjectMkd() {

    }

    public Long getId() {
        return id  == null ? 0 : id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseBlock() {
        if (houseBlock == null || houseBlock.equals("")) return  "-";
        return houseBlock;
    }

    public void setHouseBlock(String houseBlock) {
        this.houseBlock = houseBlock;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public int getHouseDoorsCount() {
        return houseDoorsCount;
    }

    public void setHouseDoorsCount(int houseDoorsCount) {
        this.houseDoorsCount = houseDoorsCount;
    }

    public int getMinFloorCount() {
        return minFloorCount;
    }

    public void setMinFloorCount(int minFloorCount) {
        this.minFloorCount = minFloorCount;
    }

    public int getMaxFloorCount() {
        return maxFloorCount;
    }

    public void setMaxFloorCount(int maxFloorCount) {
        this.maxFloorCount = maxFloorCount;
    }

    public int getAccountsCount() {
        return accountsCount;
    }

    public void setAccountsCount(int accountsCount) {
        this.accountsCount = accountsCount;
    }

    public int getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(int personsCount) {
        this.personsCount = personsCount;
    }

    public int getFlatsCount() {
        return flatsCount;
    }

    public void setFlatsCount(int flatsCount) {
        this.flatsCount = flatsCount;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public float getAreaSquare() {
        return areaSquare;
    }

    public void setAreaSquare(float areaSquare) {
        this.areaSquare = areaSquare;
    }

    public String getFirstPrivatisationDate() {
        return firstPrivatisationDate;
    }

    public void setFirstPrivatisationDate(String firstPrivatisationDate) {
        this.firstPrivatisationDate = firstPrivatisationDate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public AddressDTO getAddress() {
        if (address == null) {
            address = new AddressDTO();
            address.setCountry("");
            address.setRegion("");
            address.setLocality("");
            address.setStreet("");
        }
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public RepairDataDTO getRepair() {
        if (repair == null) {
            repair = new RepairDataDTO();
        }
        return repair;
    }

    public void setRepair(RepairDataDTO repair) {
        this.repair = repair;
    }

    public CommunicationDTO getCommunication() {
        if (communication == null) {
            communication = new CommunicationDTO();
            communication.setData("{}");
        }
        return communication;
    }

    public void setCommunication(CommunicationDTO communication) {
        this.communication = communication;
    }

    @Override
    public String toString() {
        return "ObjectMkd{" +
                "id=" + id +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseBlock='" + houseBlock + '\'' +
                ", seria='" + seria + '\'' +
                ", year=" + year +
                ", square=" + square +
                ", houseDoorsCount=" + houseDoorsCount +
                ", minFloorCount=" + minFloorCount +
                ", maxFloorCount=" + maxFloorCount +
                ", accountsCount=" + accountsCount +
                ", personsCount=" + personsCount +
                ", flatsCount=" + flatsCount +
                ", roomsCount=" + roomsCount +
                ", areaSquare=" + areaSquare +
                ", firstPrivatisationDate='" + firstPrivatisationDate + '\'' +
                ", created_at='" + created_at + '\'' +
                ", address=" + address +
                ", repair=" + repair +
                ", communication=" + communication +
                '}';
    }
}
