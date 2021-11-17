package uz.pdp.datarestpcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.datarestpcmarket.entity.Category;
import uz.pdp.datarestpcmarket.entity.Property;
import uz.pdp.datarestpcmarket.entity.WareHouse;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull
    private String name;

    @NotNull
    private Integer category;

    @NotNull
    private long price;

    @NotNull
    private Integer property;

    @NotNull
    private Integer wareHouse;
    @NotNull
    private String brend;
    @NotNull
    private boolean active;
}
