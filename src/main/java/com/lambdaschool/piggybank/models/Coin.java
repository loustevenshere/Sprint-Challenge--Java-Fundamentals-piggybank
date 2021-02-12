package com.lambdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

//    (coinid, name, nameplural, value, quantity)
// Fields
    private long coinid;
    private int quantity;
    private double value;
    private String name;
    private String nameplural;

    // Constructors

    public Coin() {

    }

    public Coin(int quantity, double value, String name, String nameplural) {
        this.quantity = quantity;
        this.value = value;
        this.name = name;
        this.nameplural = nameplural;
    }

//    public Coin(String nameplural) {
//        this.nameplural = nameplural;
//    }

    // Getters and Setters

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int numofcoins) {
        this.quantity = numofcoins;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double coinvalue) {
        this.value = coinvalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String coinname) {
        this.name = coinname;
    }

    public String getNameplural() {
        return nameplural;
    }

    public void setNameplural(String coinnameplural) {
        this.nameplural = coinnameplural;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", numofcoins=" + quantity +
                ", coinvalue=" + value +
                ", coinname='" + name + '\'' +
                ", coinnameplural='" + nameplural + '\'' +
                '}';
    }
}
