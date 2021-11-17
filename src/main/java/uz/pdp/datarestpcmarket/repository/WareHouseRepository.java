package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.WareHouse;
import uz.pdp.datarestpcmarket.projection.CustomWareHouse;

@RepositoryRestResource(path = "wareHouse",collectionResourceRel = "WareHouse",excerptProjection = CustomWareHouse.class)
public interface WareHouseRepository extends JpaRepository<WareHouse, Integer> {
    @RestResource(path = "ByName")
    public Page<WareHouse> findByName(@Param("name") String name, Pageable pageable);
}
