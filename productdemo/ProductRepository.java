package com.ivy.training.productdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@repository used to indicate the class provides the mechanism for storage,retrieval,search,update and delete operations on object

public interface ProductRepository extends JpaRepository<ProductInfo,Long> {

    List<ProductInfo> findByProductnameAndProductprice(String productname,Integer productprice);

}
