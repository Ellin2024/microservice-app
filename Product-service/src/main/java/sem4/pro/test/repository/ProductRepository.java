package sem4.pro.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sem4.pro.test.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {



}
