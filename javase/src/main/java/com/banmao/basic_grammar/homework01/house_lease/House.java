package com.banmao.basic_grammar.homework01.house_lease;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/28 下午8:32
 * @description 房屋类
 */
public class House implements Comparable<House>{
    /**
     * 编号
     */
    private int number;

    /**
     * 房主
     */
    private String houseOwner;

    /**
     * 电话
     */
    private String iphone;

    /**
     * 地址
     */
    private String address;

    /**
     * 月租
     */
    private int monthlyRent;

    /**
     * 状态（0-未出租，1-已出租）
     */
    private byte status;

    public House(int number, String houseOwner, String iphone, String address, int monthlyRent, byte status) {
        this.number = number;
        this.houseOwner = houseOwner;
        this.iphone = iphone;
        this.address = address;
        this.monthlyRent = monthlyRent;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "House{" +
                "number=" + number +
                ", houseOwner='" + houseOwner + '\'' +
                ", iphone='" + iphone + '\'' +
                ", address='" + address + '\'' +
                ", monthlyRent='" + monthlyRent + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(House o) {
        if (this.getNumber() < o.getNumber()) {
            return -1;
        } else if (this.getNumber() > o.getNumber()){
            return 1;
        }
        return 0;
    }
}