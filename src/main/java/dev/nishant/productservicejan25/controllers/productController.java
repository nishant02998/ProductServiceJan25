package dev.nishant.productservicejan25.controllers;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.exceptions.productNotFoundException;
import dev.nishant.productservicejan25.models.product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.nishant.productservicejan25.services.*;

import java.util.List;

@RestController
public class productController {

//    public productService productService;
//    public productController(productService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/products")
//    public List<product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<product> getSingleProduct(@PathVariable("id") long id) {
//        product p = productService.getSingleProduct(id);
//        ResponseEntity<product> responseEntity;
//        if (p == null) {
//            responseEntity = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
//        }else {
//            responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
//        }
//        return responseEntity;
//    }
//
//    @PostMapping("/products")
//    public product createProduct(@RequestBody createProductRequestDto createProductRequestDto) {
//        return productService.createProduct(createProductRequestDto.getTitle(),
//                                            createProductRequestDto.getDescription(),
//                                            createProductRequestDto.getPrice(),
//                                            createProductRequestDto.getImage(),
//                                            createProductRequestDto.getCategory());
//    }

    private productService productService;
    public productController(@Qualifier("selfProductService") productService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public product getSingleProduct(@PathVariable("id") long id) throws productNotFoundException {

        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public product createProduct(@RequestBody createProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto.getTitle(),
                                            productRequestDto.getDescription(),
                                            productRequestDto.getPrice(),
                                            productRequestDto.getImage(),
                                            productRequestDto.getCategory());
    }

}
