package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.models.product;
import dev.nishant.productservicejan25.repositories.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class selfProductService implements productService {
    private productRepository productRepository;

    public selfProductService(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<product> getAllProducts() {
        //get All products form product table
        List<product> products = productRepository.findAll();
        return products;
    }
}
