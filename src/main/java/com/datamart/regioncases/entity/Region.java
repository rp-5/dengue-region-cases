package com.datamart.regioncases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "region")
@Entity(name = "region")

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "address")
    private String address;

    @NotBlank
    @Column(name = "district")
    private String district;

    @NotBlank
    @Column(name = "city")
    private String city;

    @Column(name = "santading_water")
    private String santading_water;

    @Column(name = "mosquito_larva")
    private String mosquito_larva;

    public Region(String address, String district, String city, String santading_water, String mosquito_larva) {
        this.address = address;
        this.district = district;
        this.city = city;
        this.santading_water = santading_water;
        this.mosquito_larva = mosquito_larva;
    }
}
