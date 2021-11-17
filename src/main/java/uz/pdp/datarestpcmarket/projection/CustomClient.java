package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Client;

@Projection(types = Client.class)
public interface CustomClient {

    Integer getId();

    String getName();

    String getPhoneNumber();

    String getEmail();

    Integer getPassword();

    boolean getActive();
}
