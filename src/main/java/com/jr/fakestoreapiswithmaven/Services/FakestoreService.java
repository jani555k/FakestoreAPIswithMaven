package com.jr.fakestoreapiswithmaven.Services;

import com.jr.fakestoreapiswithmaven.DTO.ProductDTO;
import com.jr.fakestoreapiswithmaven.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakestoreService implements  ProductService{

    private final RestTemplate restTemplate;

    public FakestoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product GetProductById(int id) {
        ProductDTO pDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDTO.class);

        return pDTO.ToProduct();
    }

    @Override
    public List<Product> GetAllProducts() {
        ProductDTO[] pDTO = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductDTO[].class);
        List<Product> p = new ArrayList<>();
        for (ProductDTO pDTO1 : pDTO) {
            p.add(pDTO1.ToProduct());
        }
        return p;
    }

    @Override
    public List<Product> GetAllProductsByCategoryName(String categoryName) {
        ProductDTO[] pDTO = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + categoryName, ProductDTO[].class);
        List<Product> p = new ArrayList<>();
        for (ProductDTO pDTO1 : pDTO) {
            p.add(pDTO1.ToProduct());
        }
        return p;
    }

    @Override
    public List<String> GetAllCategories() {
        String[] s = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);

        return Arrays.asList(s);
    }

    @Override
    public Product AddProduct(Product product) {
        ProductDTO pDTO = new ProductDTO();
        pDTO.setId(product.getId());
        pDTO.setCategory(product.getCategory().getCategoryName());
        pDTO.setDescription(product.getDescription());
        pDTO.setPrice(product.getPrice());
        pDTO.setImageURL(product.getImageURL());
        pDTO.setTitle(product.getName());

        ProductDTO result = restTemplate.postForObject("https://fakestoreapi.com/products", pDTO, ProductDTO.class);

        return result.ToProduct();
    }

    @Override
    public Product UpdateProduct(int id, Product product) {
        ProductDTO pDTO = new ProductDTO();
        pDTO.setId(product.getId());
        pDTO.setCategory(product.getCategory().getCategoryName());
        pDTO.setDescription(product.getDescription());
        pDTO.setPrice(product.getPrice());
        pDTO.setImageURL(product.getImageURL());
        pDTO.setTitle(product.getName());

        restTemplate.put("https://fakestoreapi.com/products/" + id, pDTO);

        return GetProductById(id);
    }

    @Override
    public void DeleteProduct(int id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }
}
