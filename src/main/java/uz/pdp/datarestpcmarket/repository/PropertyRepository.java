package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.datarestpcmarket.entity.Property;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property,Integer> {

    @Query(value = "select * from property",nativeQuery = true)
    List<Property> findByProperty();

    boolean existsByMemoryAndIdNot(Integer memory, Integer id);

}
