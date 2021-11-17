package uz.pdp.datarestpcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer memory;

    @Column(nullable = false)
    private String processor;

    @Column(nullable = false)
    private String videoCard;

    @Column(nullable = false)
    private String monitor;

    @Column(nullable = false)
    private String color;
}
