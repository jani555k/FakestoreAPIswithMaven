package com.jr.fakestoreapiswithmaven.Services;


import com.jr.fakestoreapiswithmaven.Model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    public Product GetProductById(int id);
    public List<Product> GetAllProducts();
    public List<Product> GetAllProductsByCategoryName(String categoryName);
    public List<String> GetAllCategories();
    public Product AddProduct(Product product);
    public Product UpdateProduct(int id, Product product);
    public void DeleteProduct(int id);
}
