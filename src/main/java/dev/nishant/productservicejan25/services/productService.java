package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.models.product;

import java.util.List;

public interface productService {
//    List<product> getAllProducts();
//    product getSingleProduct(long id);
//    product createProduct(String title,
//                          String description,
//                          double price,
//                          String imageUrl,
//                          String category);

    product getSingleProduct(long id);
    List<product> getAllProducts();

}
