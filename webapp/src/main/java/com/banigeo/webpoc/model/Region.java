package com.banigeo.webpoc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "regions")
@NoArgsConstructor
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    private String regionName;

    public Region(String name) {
        this.regionName = name;
    }

}
