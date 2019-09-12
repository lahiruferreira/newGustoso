package com.example.administrator.gustoso;

public class order_new {

    double order_size_price;
    double cooldrink_price = 0;
    double salad_price = 0;
    double pudding_price = 0;

    public order_new() {
    }

    public double getOrder_size_price() {
        return order_size_price;
    }

    public void setOrder_size_price(double order_size_price) {
        this.order_size_price = order_size_price;
    }

    public double getCooldrink_price() {
        return cooldrink_price;
    }

    public void setCooldrink_price(double cooldrink_price) {
        this.cooldrink_price = cooldrink_price;
    }

    public double getSalad_price() {
        return salad_price;
    }

    public void setSalad_price(double salad_price) {
        this.salad_price = salad_price;
    }

    public double getPudding_price() {
        return pudding_price;
    }

    public void setPudding_price(double pudding_price) {
        this.pudding_price = pudding_price;
    }
}

