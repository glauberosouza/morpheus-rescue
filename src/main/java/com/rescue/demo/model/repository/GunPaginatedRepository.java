package com.rescue.demo.model.repository;

import com.rescue.demo.model.entity.Gun;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GunPaginatedRepository extends PagingAndSortingRepository<Gun, Integer> {
}
