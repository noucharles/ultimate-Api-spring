package com.charlesnk.ultimateapi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    public int id;

    public float amount;

    public Date sentAt;

    public String status;

    //Pour éviter la suppression en cascade on a retiré CascadeType.REMOVE
    //On n'a pas fait @JoinColunm(name="customer_id") parce que c'est fait automatiquement
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.MERGE, CascadeType.REFRESH})
    public Customer customer;

    public Invoice() {
    }

    public Invoice(int id, float amount, Date sentAt, String status) {
        this.id = id;
        this.amount = amount;
        this.sentAt = sentAt;
        this.status = status;
    }

    public Invoice(int id, float amount, Date sentAt, String status, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.sentAt = sentAt;
        this.status = status;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
