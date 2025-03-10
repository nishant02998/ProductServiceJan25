package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.exceptions.productNotFoundException;
import dev.nishant.productservicejan25.models.product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface productService {
//    List<product> getAllProducts();
//    product getSingleProduct(long id);
//    product createProduct(String title,
//                          String description,
//                          double price,
//                          String imageUrl,
//                          String category);

    product getSingleProduct(long id) throws productNotFoundException;

    List<product> getAllProducts();

    Page<product> getPaginatedProducts(int pageNo,int pageSize); //Controller class will give page number and page size.
    product createProduct(String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category);

}
