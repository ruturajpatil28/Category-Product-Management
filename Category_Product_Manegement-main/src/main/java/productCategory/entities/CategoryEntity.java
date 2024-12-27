package productCategory.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    // Constructors
    public CategoryEntity() {
        this.products = new ArrayList<>();
    }

    public CategoryEntity(Long id, String name, List<ProductEntity> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryEntity [id=" + id + ", name=" + name + ", products=" + products + "]";
    }
}
