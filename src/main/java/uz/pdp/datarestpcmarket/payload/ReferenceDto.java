package uz.pdp.datarestpcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceDto {
    @NotNull
    private Integer memory;

    @NotNull
    private String processor;

    @NotNull
    private String videoCard;

    @NotNull
    private String monitor;

    @NotNull
    private String color;
}
