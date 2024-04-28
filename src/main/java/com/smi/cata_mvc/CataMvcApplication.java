package com.smi.cata_mvc;

import com.smi.cata_mvc.dao.ProductRepository;
import com.smi.cata_mvc.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvcApplication {

    public static void main(String[] args) {
       ApplicationContext ctx= SpringApplication.run(CataMvcApplication.class, args);

        ProductRepository productRepo=ctx.getBean(ProductRepository.class);
//
//        // fill the database with some products
//        productRepo.save(new Product("HP 670", 9000, 10));
//        productRepo.save(new Product("Dell 670", 8000, 10));
//        productRepo.save(new Product("Asus 670", 7000, 10));
//        productRepo.save(new Product("Lenovo 670", 6000, 10));
//        productRepo.save(new Product("Mac 670", 5000, 10));
//        productRepo.save(new Product("Acer 670", 4000, 10));
//        productRepo.save(new Product("Samsung 670", 3000, 10));
//        productRepo.save(new Product("Sony 670", 2000, 10));
//        productRepo.save(new Product("Toshiba 670", 1000, 10));

          productRepo.findAll().forEach(p->{
                System.out.println(p.getDesignation());
          });


    }

}
