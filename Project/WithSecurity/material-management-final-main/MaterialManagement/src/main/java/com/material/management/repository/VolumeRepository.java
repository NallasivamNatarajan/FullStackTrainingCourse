package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.Volume;
@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

}
