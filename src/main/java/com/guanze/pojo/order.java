package com.guanze.pojo;

import java.sql.Timestamp;

public class order {
    int order_id;
    int user_id;
    int goods_id;
    int quantity;
    double price;
    String goods_name;
    Timestamp updated_at;
    int total_quantity;
    @Override
    public String toString() {
        return "order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", goods_name='" + goods_name + '\'' +
                ", updated_at=" + updated_at +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
