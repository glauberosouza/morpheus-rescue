package com.rescue.demo.model.service.impl;

import com.rescue.demo.model.entity.Gun;
import com.rescue.demo.model.repository.GunPaginatedRepository;
import com.rescue.demo.model.repository.GunRepository;
import com.rescue.demo.model.service.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GunServiceImplementation implements GunService {
    @Autowired
    GunRepository repository;
    @Autowired
    GunPaginatedRepository paginatedRepository;

    @Override
    public void saveGun(Gun gun) {
        repository.save(gun);
    }

    @Override
    public void deleteGunById(Integer id) {
        Optional<Gun> gunById = repository.findById(id);
        if (gunById.isPresent()) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateGun(Integer id, Gun gun) {
        var gunToUpdate = repository.findById(id).orElseThrow();
        gunToUpdate.setName(gun.getName());
        gunToUpdate.setWeight(gun.getWeight());
        gunToUpdate.setCaliber(gun.getCaliber());
        gunToUpdate.setGunSizeEnum(gun.getGunSizeEnum());
        gunToUpdate.setAutomatic(gunToUpdate.isAutomatic());
        repository.save(gunToUpdate);
    }

    @Override
    public Gun findGunById(Integer id) {
        var gun = repository.findById(id).orElseThrow();
        return gun;
    }

    @Override
    public List<Gun> findAllGuns() {
        List<Gun> allGuns = repository.findAll();
        return allGuns;
    }

    @Override
    public Page<Gun> findAllGunsPaginated(PageRequest pageRequest) {

        return paginatedRepository.findAll(pageRequest);
    }
}