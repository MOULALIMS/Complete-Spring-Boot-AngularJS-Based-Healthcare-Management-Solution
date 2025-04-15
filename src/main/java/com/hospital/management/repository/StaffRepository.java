package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Receptionist;

@Repository
public interface StaffRepository extends JpaRepository<Receptionist, Integer>{

}
