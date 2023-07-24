package com.rescue.demo.controller.converter;

import com.rescue.demo.controller.request.PostGunRequest;
import com.rescue.demo.controller.response.PostGunResponse;
import com.rescue.demo.model.entity.Gun;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GunRequestConverter {
    public Gun toGunEntity(PostGunRequest gunRequest) {
        var gun = Gun.from(gunRequest);
        return gun;
    }

    public List<PostGunResponse> toGunResponse(List<Gun> guns) {
        List<PostGunResponse> gunResponses = new ArrayList<>();
        for (var gun : guns) {
            gunResponses.add(toGunResponse(gun));
        }
        return gunResponses;
    }

    public PostGunResponse toGunResponse(Gun gun) {
        PostGunResponse gunResponse = new PostGunResponse();
        gunResponse.setId(gun.getId());
        gunResponse.setName(gun.getName());
        gunResponse.setWeight(gun.getWeight());
        gunResponse.setCaliber(gun.getCaliber());
        gunResponse.setGunSize(gun.getGunSizeEnum());
        gunResponse.setAutomatic(gun.isAutomatic());
        gunResponse.setCreatedAt(gun.getCreatedAt());
        return gunResponse;
    }
}