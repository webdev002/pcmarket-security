package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.datarestpcmarket.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product p inner  join property on p.property_id=property.id where property.monitor='Full HD' and property.processor='Intel core i5'",nativeQuery = true)
    List<Product> getAllByProduct();

    boolean existsByNameAndIdNot(String name, Integer id);
}
