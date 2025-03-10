package dev.nishant.productservicejan25.repositories;

import dev.nishant.productservicejan25.models.product;
import dev.nishant.productservicejan25.projections.productWithIdAndPriceProjection;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<product, Long> {
    @Override
    List<product> findAll();

    @Override
    Page<product> findAll(Pageable pageable);

    product save(product product);

    @Override
    Optional<product> findById(Long aLong);

    List<product> findAllByCategory_Title(String categoryTitle);

    List<product> findByCategoryId(Long categoryId);

    @Query("select p.id, p.price from product p where p.category.title = :categoryName")
    List<productWithIdAndPriceProjection> getProductTitlesAndPricesAndAGivenCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "select * from products p where p.title = :title", nativeQuery = true)
    List<productWithIdAndPriceProjection> getIdAndPricesOfAllProductsWithGivenTitle(@Param("title") String title);
}
