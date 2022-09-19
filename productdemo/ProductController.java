package com.ivy.training.productdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RestController-used for making restful web services

@RequestMapping("/product_api")
//@RequestMapping-maps a specific request path on to a controller

public class ProductController {

//@autowired is used for dependency injection
@Autowired

    private ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @Autowired
    private ProductRepository repo;



    @GetMapping("/product_lst")
    //@GetMapping-Get-request matched with the url

    public List<ProductInfo> list() {

        return productservice.getProductList();
    }

    @PostMapping("/product_map")
    //@PostMapping-values will send with the url as name and value pair
    public void insertion(@RequestBody ProductInfo entry) {
//@RequestBody-maps the httprequest body to a transfer or domainobject (allows us to retrieve the request's body)
        productservice.addProduct(entry);
    }

    @GetMapping("/product/{productid}")
    public ProductInfo getPerson(@PathVariable(name = "productid") Integer productid) {
        return productservice.retrieveinfo(productid);
    }

    @DeleteMapping("/prod/{productid}")
    public void delperson(@PathVariable(name="productid")Integer productid){

        productservice.delinfo(productid);
    }

    @PutMapping("/update/{productid}")
    public ProductInfo updateproduct(@PathVariable long productid,@RequestBody ProductInfo updatebyId){
        return productservice.updateproductbyId(productid,updatebyId);
    }

    @GetMapping("/pers/productnameandproductprice")
    public ResponseEntity<List<ProductInfo>>getBynameandprice(@RequestParam String productname,
                                                              @RequestParam Integer productprice ) {
        return new ResponseEntity<>(repo.findByProductnameAndProductprice(productname, productprice), HttpStatus.OK);
    }
}
