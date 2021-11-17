package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Supplier;

@Projection(types = Supplier.class)
public interface CustomSupplier {

    Integer getId();

    String getName();

    String getPhoneNumber();

    Integer getCode();

    boolean getActive();
}
