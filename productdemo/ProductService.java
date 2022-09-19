package com.ivy.training.productdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
@Service
//@service - allows developers to add business functionalities

public class ProductService {
    @Autowired
    //@autowired is used for dependency injection

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {

        this.repository = repository;
    }
    public List<ProductInfo> getProductList() {

        return repository.findAll();
    }

    public void addProduct(ProductInfo entry) {
    repository.save(entry);
        System.out.println("Entry added");
    }
    public  ProductInfo retrieveinfo(Integer productid) {
        return repository.findById(Long.valueOf((Integer) productid)).get();
    }
    public void delinfo(Integer productid) {
        repository.deleteById(Long.valueOf((Integer) productid));
    }

    public ProductInfo updateproductbyId(long productid, ProductInfo updatebyId) {
        return  repository.save(updatebyId);
    }
}
