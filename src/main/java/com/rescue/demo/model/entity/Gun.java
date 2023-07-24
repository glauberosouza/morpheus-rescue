package com.rescue.demo.model.entity;

import com.rescue.demo.controller.request.PostGunRequest;
import com.rescue.demo.model.enums.GunSizeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Gun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String weight;
    private String caliber;
    private GunSizeEnum gunSizeEnum;
    private boolean automatic;
    private LocalDateTime createdAt;

    public static Gun from(PostGunRequest postGunRequest){
        Gun gun = new Gun();
        gun.setName(postGunRequest.getName());
        gun.setWeight(postGunRequest.getWeight());
        gun.setCaliber(postGunRequest.getCaliber());
        gun.setGunSizeEnum(postGunRequest.getGunSize());
        gun.setAutomatic(postGunRequest.getAutomatic());
        return gun;
    }
}