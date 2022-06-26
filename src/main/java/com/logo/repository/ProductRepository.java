package com.logo.repository;

import com.logo.model.Product;
import com.logo.model.RealWorldService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
   private static final List<Product> productList = new ArrayList<>();
   private static int nextId = 0;

   public Product save(Product product){
       product.setId(nextId);
       nextId +=1;
       productList.add(product);
       return product;
   }
   public Optional<Product> findById(int id){
        return productList.stream().filter(it -> it.getId() == id).findFirst();
    }

    public List<Product> getAll() {
        return productList;
    }

    public void  delete(Product product){
        productList.remove(product);
    }

    public Optional<Product> findByBarcode(String code) {
       return productList.stream().filter(it -> it.getBarcode().equals(code)).findFirst();
    }

    public List<Product> getProductsStartingWith(String searchQuery) {
       return productList.stream().filter(it -> it.getName().startsWith(searchQuery)).toList();
    }
}

