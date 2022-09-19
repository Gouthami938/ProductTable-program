package com.ivy.training.productdemo;

import javax.persistence.*;

@Entity
//@Entity specifies class is an entity and is mapped to a database table

@Table
//@Table allows you to specify the details of the table that will be used to persist the entity in the db

public class ProductInfo {
    private String productname;
    private int productprice;
@Id
//@Id indicates the member field below is the primary key of the current entity

@SequenceGenerator(name="product_seq",sequenceName = "product_seq",allocationSize = 1)
//@SequenceGenerator defines the primary key generator that may be referenced by name when generated element is specified for the generated value annotation

@GeneratedValue(strategy = GenerationType.AUTO,generator = "product_seq")
    private Long productid;
    public ProductInfo() {

    }

    public ProductInfo(String productname, int productprice) {
        this.productname = productname;
        this.productprice = productprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }
}
