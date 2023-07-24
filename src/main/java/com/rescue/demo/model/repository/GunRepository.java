package com.rescue.demo.model.repository;

import com.rescue.demo.model.entity.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GunRepository extends JpaRepository<Gun, Integer> {
}
