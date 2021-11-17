package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Address;

@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();

    String getCity();

    String getStreet();

    Integer getHomeNumber();
}
