package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.Address;
import uz.pdp.datarestpcmarket.projection.CustomAddress;

@RepositoryRestResource(path = "address",collectionResourceRel = "Address",excerptProjection = CustomAddress.class)
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @RestResource(path = "ByCity")
    public Page<Address> findByCity(@Param("city") String city, Pageable pageable);

}
