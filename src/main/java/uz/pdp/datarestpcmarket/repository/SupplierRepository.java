package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.Supplier;
import uz.pdp.datarestpcmarket.projection.CustomSupplier;

@RepositoryRestResource(path = "supplier",collectionResourceRel = "Supplier",excerptProjection = CustomSupplier.class)
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    @RestResource(path = "buName")
    public Page<Supplier> findByName(@Param("name") String name, Pageable pageable);
}
