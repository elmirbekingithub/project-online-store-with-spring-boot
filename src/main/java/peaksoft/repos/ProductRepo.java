package peaksoft.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import peaksoft.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findFirstByName(String name);
}
