package productCategory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productCategory.Service.ProductService;
import productCategory.entities.ProductEntity;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new Product
    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody ProductEntity product) 
    {
        System.out.println("Inside ProductController " + product);
        
        try 
        {
            ProductEntity createdProduct = productService.createProduct(product);
            String productDetails = getProductDetails(createdProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully.\n" + productDetails);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create product: " + ex.getMessage());
        }
    }

    // Helper method to get product details
    private String getProductDetails(ProductEntity product) {
        StringBuilder details = new StringBuilder();
        details.append("Product ID: ").append(product.getId()).append("\n");
        details.append("Product Name: ").append(product.getName()).append("\n");
        details.append("Product Description: ").append(product.getDescription()).append("\n");
        details.append("Product Price: ").append(product.getPrice()).append("\n");
        // Add more details if needed
        return details.toString();
    }

    // Retrieve a Product by ID
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") Long productId) {
        ProductEntity product = productService.getProductById(productId);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // Retrieve all Products
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    // Update Product ById
    @PutMapping("{productId}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId, @RequestBody ProductEntity product) {
        try {
            ProductEntity updatedProduct = productService.updateProduct(productId, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Product ById
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
