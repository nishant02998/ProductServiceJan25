package dev.nishant.productservicejan25.repositories;

import dev.nishant.productservicejan25.models.product;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<product, Long> {
    @Override
    List<product> findAll();
}
