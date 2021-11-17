package uz.pdp.datarestpcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.datarestpcmarket.entity.Category;
import uz.pdp.datarestpcmarket.projection.CustomCategory;

@RepositoryRestResource(path = "category",collectionResourceRel = "Category",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @RestResource(path = "ByName")
    public Page<Category> findByName(@Param("name") String name, Pageable pageable);
}
