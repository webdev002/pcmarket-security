package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.Client;
import uz.pdp.datarestpcmarket.entity.Sharxlar;
import uz.pdp.datarestpcmarket.projection.CustomSharxlar;

@RepositoryRestResource(path = "sharxlar",collectionResourceRel = "Sharxlar",excerptProjection = CustomSharxlar.class)
public interface SharxlarRepository extends JpaRepository<Sharxlar,Integer> {
    @RestResource(path = "ByClient")
    public Page<Sharxlar> findByClient(@Param("client") Client client, Pageable pageable);
}
