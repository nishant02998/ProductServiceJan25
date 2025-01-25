package dev.nishant.productservicejan25.repositories;

import dev.nishant.productservicejan25.models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoryRepository extends JpaRepository<category, Long> {

    category findByTitle(String title);
    category save(category category);
}
