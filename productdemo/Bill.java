package com.ivy.training.productdemo;

import javax.persistence.*;

@Entity
@Table
public class Bill {
    private int productCost;
@Id
@SequenceGenerator(name="bill_seq",sequenceName = "bill_seq",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bill_seq")

private int productid;


    public Bill() {

    }

    public Bill(int productCost) {
        this.productCost = productCost;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }
}
