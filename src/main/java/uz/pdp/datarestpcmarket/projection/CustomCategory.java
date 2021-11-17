package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();
}
