package com.rescue.demo.controller;

import com.rescue.demo.controller.converter.GunRequestConverter;
import com.rescue.demo.controller.request.PostGunRequest;
import com.rescue.demo.controller.response.PostGunResponse;
import com.rescue.demo.model.entity.Gun;
import com.rescue.demo.model.service.GunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/guns")
public class GunController {
    @Autowired
    GunService gunService;

    @Autowired
    GunRequestConverter gunRequestConverter;

    @PostMapping
    public void registerGun(@Valid @RequestBody PostGunRequest gunRequest) {
        var gunRequestToGunEntity = gunRequestConverter.toGunEntity(gunRequest);
        gunRequestToGunEntity.setCreatedAt(LocalDateTime.now()); // Colocar no service
        gunService.saveGun(gunRequestToGunEntity);
    }

    @GetMapping
    public List<PostGunResponse> AllGunsRegistered() {
        List<Gun> allGuns = gunService.findAllGuns();
        List<PostGunResponse> gunResponse = gunRequestConverter.toGunResponse(allGuns);
        return gunResponse;
    }

    @GetMapping("/{gun-id}")
    public PostGunResponse findGunById(@PathVariable("gun-id") Integer gunId) {
        var gunById = gunService.findGunById(gunId);
        PostGunResponse gunResponse = gunRequestConverter.toGunResponse(gunById);
        return gunResponse;
    }

    @GetMapping("/page/{number}")
    public Page<Gun> allGunsPaginated(@PathVariable Integer number) {
        var page = PageRequest.of(number, 5);
        return gunService.findAllGunsPaginated(page);
    }

    @PutMapping("/{gun-Id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGun(@PathVariable("gun-id") Integer gunId, @Valid @RequestBody PostGunRequest gunRequest) {
        Gun gunEntity = gunRequestConverter.toGunEntity(gunRequest);
        gunService.updateGun(gunId, gunEntity);
    }

    @DeleteMapping("/{gun-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGunById(@PathVariable("gun-id") Integer gunId) {
        gunService.deleteGunById(gunId);
    }
}