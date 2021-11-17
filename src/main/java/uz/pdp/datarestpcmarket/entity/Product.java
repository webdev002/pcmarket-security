package uz.pdp.datarestpcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    private WareHouse wareHouse;

    private String brend;

    private boolean active;
}

