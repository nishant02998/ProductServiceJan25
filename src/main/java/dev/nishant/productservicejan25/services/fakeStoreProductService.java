package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.dtos.fakeStoreProductDto;
import dev.nishant.productservicejan25.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class fakeStoreProductService implements productService{

    private RestTemplate restTemplate;// Rest Template is use for calling 3rd party API's
    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<product> getAllProducts() {
        return List.of();
    }

    @Override
    public product getSingleProduct(long id) {
        /*
        call the external fake Store API "https://fakestoreapi.com/products/1"
         */
        fakeStoreProductDto product = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class);
        return product.toProduct();
    }

    @Override
    public product createProduct(createProductRequestDto createProductRequestDto) {
        return null;
    }
}
