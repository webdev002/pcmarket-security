package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.Client;
import uz.pdp.datarestpcmarket.projection.CustomClient;

@RepositoryRestResource(path = "client",collectionResourceRel = "Client",excerptProjection = CustomClient.class)
public interface ClientRepository extends JpaRepository<Client,Integer> {

    @RestResource(path = "ByName")
    public Page<Client> findByName(@Param("name") String name, Pageable pageable);
}
