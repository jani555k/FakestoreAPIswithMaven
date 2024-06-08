package com.jr.fakestoreapiswithmaven.Controller;

import com.jr.fakestoreapiswithmaven.DTO.ProductDTO;
import com.jr.fakestoreapiswithmaven.Model.Product;
import com.jr.fakestoreapiswithmaven.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product GetProductByID(@PathVariable ("id") int id) {
        return productService.GetProductById(id);
    }

    @GetMapping("/products/")
    public List<Product> GetAllProducts(){
        return productService.GetAllProducts();
    }

    @GetMapping("/products/category/{categoryName}")
    public List<Product> GetProductsByCategoryName(@PathVariable ("categoryName") String categoryName) {
        return productService.GetAllProductsByCategoryName(categoryName);
    }

    @GetMapping("/products/category/")
    public List<String> GetAllCategories() {
        return productService.GetAllCategories();
    }

    @PostMapping("/products/")
    public Product AddProduct(@RequestBody Product product) {
        return productService.AddProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product UpdateProduct(@PathVariable ("id") int id, @RequestBody Product product){
        return productService.UpdateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void DeleteProduct(@PathVariable ("id") int id){
        productService.DeleteProduct(id);
    }

}
