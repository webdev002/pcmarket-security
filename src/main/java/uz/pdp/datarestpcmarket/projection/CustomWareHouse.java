package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Address;
import uz.pdp.datarestpcmarket.entity.WareHouse;

@Projection(types = WareHouse.class)
public interface CustomWareHouse {
    Integer getId();

    String getName();

    boolean getActive();

    String getPhoneNumber();

    Address getAddress();
}
