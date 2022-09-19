package com.ivy.training.productdemo;

import javax.persistence.*;

@Entity
@Table
public class Cart {
    private int items_in_cart;
    @Id
    @SequenceGenerator(name="cart_seq",sequenceName = "cart_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_seq")
    private int productid;




    public Cart() {

    }

    public Cart( int items_in_cart) {

        this.items_in_cart = items_in_cart;
    }





    public int getItems_in_cart() {
        return items_in_cart;
    }

    public void setItems_in_cart(int items_in_cart) {
        this.items_in_cart = items_in_cart;
    }
}
