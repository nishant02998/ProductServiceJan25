package dev.nishant.productservicejan25.services;

import dev.nishant.productservicejan25.dtos.createProductRequestDto;
import dev.nishant.productservicejan25.dtos.fakeStoreProductDto;
import dev.nishant.productservicejan25.models.product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class fakeStoreProductService implements productService{

    private RestTemplate restTemplate;// Rest Template is use for calling 3rd party API's
    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<product> getAllProducts() {
        fakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", fakeStoreProductDto[].class);
        List<product> allProducts = new ArrayList<>();
        for (fakeStoreProductDto product : fakeStoreProductDtos) {
            allProducts.add(product.toProduct());
        }
        return allProducts;
//        return null;
    }

    @Override
    public product getSingleProduct(long id) {
        /*
        call the external fake Store API "https://fakestoreapi.com/products/1"
         */
//        fakeStoreProductDto product = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class);
        ResponseEntity<fakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class);
        if(fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatusCode.valueOf(200)) {
            //Handle Exception
            System.out.println("Error!!");
        }
        fakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null) {
            return null;
        }
        return fakeStoreProductDto.toProduct();
//        return null;
    }

    @Override
    public product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {
        fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto, fakeStoreProductDto.class);
        return fakeStoreProductDto1.toProduct();
    }
}
