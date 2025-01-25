package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.exceptions.productNotFoundException;
import dev.nishant.productservicejan25.models.category;
import dev.nishant.productservicejan25.models.product;
import dev.nishant.productservicejan25.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class selfProductService implements productService {
    private productRepository productRepository;
    private categoryRepository categoryRepository;

    public selfProductService(productRepository productRepository, categoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public product getSingleProduct(long id) throws productNotFoundException{
        Optional<product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new productNotFoundException("Product with given id not found");
        }
        return productOptional.get();
    }

    @Override
    public List<product> getAllProducts() {
        //get All products form product table
        List<product> products = productRepository.findAll();
        return products;
    }

    @Override
    public product createProduct(String title, String description, double price, String imageUrl, String category) {
        product product = new product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        category categoryFromDB = categoryRepository.findByTitle(category);
        if (categoryFromDB == null) {
            category newCategory = new category();
            newCategory.setTitle(category);
            product.setCategory(newCategory);
            categoryRepository.save(newCategory);
        }else {
            product.setCategory(categoryFromDB);
        }

        product createdProduct = productRepository.save(product);
        return createdProduct;
    }


}
