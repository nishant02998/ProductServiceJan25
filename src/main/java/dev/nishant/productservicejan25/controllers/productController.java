package dev.nishant.productservicejan25.controllers;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.models.product;
import org.springframework.web.bind.annotation.*;
import dev.nishant.productservicejan25.services.*;

import java.util.List;

@RestController
public class productController {

    public productService productService;
    public productController(productService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public product createProduct(@RequestBody createProductRequestDto createProductRequestDto) {
        return productService.createProduct(createProductRequestDto);
    }

}
