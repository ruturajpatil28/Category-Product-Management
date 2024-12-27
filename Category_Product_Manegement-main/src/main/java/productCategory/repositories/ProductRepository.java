package productCategory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productCategory.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> 
{


	 boolean existsByName(String name);
    // You can add custom query methods here if needed
}
