package com.jr.fakestoreapiswithmaven.DTO;

import com.jr.fakestoreapiswithmaven.Model.Category;
import com.jr.fakestoreapiswithmaven.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String ImageURL;
    private String category;

    public Product ToProduct(){
        Product p = new Product();
        p.setId(this.id);
        p.setName(this.title);
        p.setPrice(this.price);
        p.setDescription(this.description);
        p.setImageURL(this.ImageURL);

        Category c = new Category();
        c.setCategoryName(this.category);
        p.setCategory(c);

        return p;
    }
}
