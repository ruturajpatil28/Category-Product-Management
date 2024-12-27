package productCategory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productCategory.entities.CategoryEntity;
import productCategory.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Retrieve all categories with pagination
    public Page<CategoryEntity> getAllCategories(Pageable pageable) 
    {
        
    	return categoryRepository.findAll(pageable);
    }

    // Create a new category
    public CategoryEntity createCategory(CategoryEntity category) {
    	
            return categoryRepository.save(category);
      
    }

    // Retrieve a category by ID
    public Optional<CategoryEntity> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Update a category by ID
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryDetails) 
    {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity category = optionalCategory.get();
            category.setName(categoryDetails.getName());
            return categoryRepository.save(category);
        } 
        
        else
        {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    // Delete a category by ID
    public void deleteCategory(Long id) 
    {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) 
        {
            categoryRepository.deleteById(id);
        } 
        else
        {
            throw new RuntimeException("Category not found with id: " + id);
        }
		
    }
    
    public boolean isCategoryExists(String categoryName) 
    {
        return categoryRepository.existsByName(categoryName);
    }

    
}
