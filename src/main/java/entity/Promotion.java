/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author trant
 */
public class Promotion {
    private int id;
    private int productID;
    private double discountRate;
    private String startDate;
    private String endDate;

    // Constructors
    public Promotion() {}

    public Promotion(int id, int productID, double discountRate, String startDate, String endDate) {
        this.id = id;
        this.productID = productID;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", productID=" + productID +
                ", discountRate=" + discountRate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
