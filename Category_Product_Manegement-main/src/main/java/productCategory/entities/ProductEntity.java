package productCategory.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;

    
    @JoinColumn(name = "category_id", nullable = false)
    
    @JsonIgnore
    @ManyToOne
    private CategoryEntity category;

    // Constructors
    public ProductEntity() 
    {
        super();
    }

    public ProductEntity(Long id, String name, String description, double price, CategoryEntity category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	// getters and setters
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public CategoryEntity getCategory() 
    {
        return category;
    }

    public void setCategory(CategoryEntity category) 
    {
        this.category = category;
    }

    @Override
    public String toString() 
    {
        return "ProductEntity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", category=" + category + "]";
    }
}
