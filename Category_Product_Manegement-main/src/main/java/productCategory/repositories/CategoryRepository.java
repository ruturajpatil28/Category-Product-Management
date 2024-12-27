package productCategory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productCategory.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> 
{

	boolean existsByName(String categoryName);
    // You can add custom query methods here if needed
	
}
