package com.elsa.OnlineShop.repository;

import com.elsa.OnlineShop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {


}
