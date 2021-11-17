package uz.pdp.datarestpcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.datarestpcmarket.entity.Product;
import uz.pdp.datarestpcmarket.payload.ApiResponse;
import uz.pdp.datarestpcmarket.payload.ProductDto;
import uz.pdp.datarestpcmarket.repository.CategoryRepository;
import uz.pdp.datarestpcmarket.repository.ProductRepository;
import uz.pdp.datarestpcmarket.repository.PropertyRepository;
import uz.pdp.datarestpcmarket.repository.WareHouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getProduct(){
        List<Product> allByProduct = productRepository.getAllByProduct();
        return allByProduct;
    }

    public Product getProductById(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(product.getName());
        product.setCategory(categoryRepository.getById(productDto.getCategory()));
        product.setPrice(product.getPrice());
        product.setWareHouse(wareHouseRepository.getById(productDto.getWareHouse()));
        product.setBrend(product.getBrend());
        product.setProperty(propertyRepository.getById(productDto.getProperty()));
        product.setActive(product.isActive());
        productRepository.save(product);
        return new ApiResponse("Product saqlandi!",true);
    }

    public ApiResponse editProduct(Integer id, ProductDto productDto) {
        boolean existsByNameAndIdNot = productRepository.existsByNameAndIdNot(productDto.getName(), id);
        if (existsByNameAndIdNot){
            return new ApiResponse("Bunday product mavjud emas!",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isEmpty()){
            Product product = optionalProduct.get();
            product.setName(product.getName());
            product.setCategory(categoryRepository.getById(productDto.getCategory()));
            product.setPrice(product.getPrice());
            product.setWareHouse(wareHouseRepository.getById(productDto.getWareHouse()));
            product.setBrend(product.getBrend());
            product.setProperty(propertyRepository.getById(productDto.getProperty()));
            product.setActive(product.isActive());
            productRepository.save(product);
            return new ApiResponse("Product tahrirlandi!",true);
        }
        return new ApiResponse("Error",false);

    }

    public ApiResponse deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new ApiResponse("Product ochirildi!",true);
    }
}
