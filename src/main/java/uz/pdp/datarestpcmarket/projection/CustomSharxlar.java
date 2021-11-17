package uz.pdp.datarestpcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.datarestpcmarket.entity.Client;
import uz.pdp.datarestpcmarket.entity.Sharxlar;

@Projection(types = Sharxlar.class)
public interface CustomSharxlar {
    Integer getId();

    Client getClient();
}
