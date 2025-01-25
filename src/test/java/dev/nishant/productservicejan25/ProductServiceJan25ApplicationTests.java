package dev.nishant.productservicejan25;

import dev.nishant.productservicejan25.models.product;
import dev.nishant.productservicejan25.projections.productWithIdAndPriceProjection;
import dev.nishant.productservicejan25.repositories.productRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceJan25ApplicationTests {
    @Autowired
    productRepository productRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void testProductRepository(){
////        List<product> products = productRepository.findAllByCategory_Title("books");
////        System.out.println(products);
//
//        List<productWithIdAndPriceProjection> product = productRepository.getProductTitlesAndPricesAndAGivenCategoryName("books");
//
//        for(productWithIdAndPriceProjection productWithIdAndPriceProjection:product){
//            System.out.println(productWithIdAndPriceProjection.getPrice() + " " + productWithIdAndPriceProjection.getId());
//        }
//        System.out.println();
//    }

}
