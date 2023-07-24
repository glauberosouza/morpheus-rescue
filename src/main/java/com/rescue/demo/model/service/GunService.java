package com.rescue.demo.model.service;

import com.rescue.demo.controller.request.PostGunRequest;
import com.rescue.demo.model.entity.Gun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface GunService {
    void saveGun(Gun gun);
    void deleteGunById(Integer id);
    void updateGun(Integer id, Gun gun);
    Gun findGunById(Integer id);
    List<Gun> findAllGuns();
    Page<Gun> findAllGunsPaginated(PageRequest pageRequest);
}
