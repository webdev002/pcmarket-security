package uz.pdp.datarestpcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.datarestpcmarket.entity.Product;
import uz.pdp.datarestpcmarket.payload.ApiResponse;
import uz.pdp.datarestpcmarket.payload.ProductDto;
import uz.pdp.datarestpcmarket.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //SUPER_ADMIN
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> product = productService.getProduct();
        return ResponseEntity.ok(product);
    }


    //OPERATOR,MODERATOR
    @PreAuthorize(value = "hasAnyRole('OPERATOR','MODERATOR')")
    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        Product productById = productService.getProductById(id);
        return ResponseEntity.ok(productById);
    }


    //SUPER_ADMIN,MODERATOR
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PostMapping("/api/product")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto){
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }


    //MODERATOR,SUPER_ADMIN
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PutMapping("/api/product/{id}")
    public ResponseEntity<ApiResponse> editProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        ApiResponse apiResponse = productService.editProduct(id, productDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }


    //SUPER_ADMIN
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id){
        ApiResponse apiResponse = productService.deleteProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(apiResponse);
    }
}
