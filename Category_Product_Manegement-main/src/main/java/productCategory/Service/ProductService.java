package productCategory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import productCategory.entities.CategoryEntity;
import productCategory.entities.ProductEntity;
import productCategory.repositories.CategoryRepository;
import productCategory.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
   
   /* // 1 createProduct
    @Transactional
    public ProductEntity createProduct(ProductEntity product) 
    {
        // Perform validation before saving
    	
        if (isValidProduct(product)) 
        {
            return productRepository.save(product);
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid product data");
        }
    }

   
    private boolean isValidProduct(ProductEntity product) 
    {
        // Add validation logic here (e.g., check if required fields are not null or empty)
    	System.out.println("inside product servide "+product);
    	
        return   product != null && product.getName() != null && 
        		!product.getName().isEmpty() && product.getDescription() != null &&
        		!product.getDescription().isEmpty() && product.getPrice() >= 0;
    }
 */
    @Autowired
    private CategoryRepository categoryRepository; // Inject CategoryRepository

    // Create a new product
    @Transactional
    public ProductEntity createProduct(ProductEntity product) {
        // Validate product and category before saving
        if (isValidProduct(product) && isValidCategory(product.getCategory())) 
        {
            return productRepository.save(product);
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid product data or category not found");
        }
    }

    // Validate the product entity
    private boolean isValidProduct(ProductEntity product) {
        return product != null && product.getName() != null && !product.getName().isEmpty() &&
                product.getDescription() != null && !product.getDescription().isEmpty() &&
                product.getPrice() >= 0;
    }

    // Validate the category entity
    private boolean isValidCategory(CategoryEntity category) {
        return category != null && category.getId() != null && categoryRepository.existsById(category.getId());
    }

    public boolean isProductExists(String name)
	{
		// TODO Auto-generated method stub		
		return productRepository.existsByName(name);
	}
    
 // 2 getProductById
    @Transactional
    public ProductEntity getProductById(Long productId) 
    {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    // 3 getAllProducts
    @Transactional
    public List<ProductEntity> getAllProducts() 
    {
        return productRepository.findAll();
    }
    
    // 4 updateProduct
    @Transactional
    public ProductEntity updateProduct(Long productId, ProductEntity product) 
    {
        Optional<ProductEntity> existingProductOptional = productRepository.findById(productId);
        if (existingProductOptional.isPresent())
        {
            ProductEntity existingProduct = existingProductOptional.get();
            // Update only if the product is valid
            
            if (isValidProduct(product)) 
            {
                product.setId(productId);
                return productRepository.save(product);
            } 
            else 
            {
                throw new IllegalArgumentException("Invalid product data");
            }
        } 
        
	        else 
	        {
	            throw new IllegalArgumentException("Product not found");
	        }
    }
    	
    // 5 deleteProduct
	    	@Transactional
	    public void deleteProduct(Long productId) 
	    {
	        productRepository.deleteById(productId);
	    }
}
