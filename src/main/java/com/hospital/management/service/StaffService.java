package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dao.Receptionist;
import com.hospital.management.error.GlobalException;

public interface StaffService {

	List<Receptionist> getAllStaff();

	Receptionist getStaffById(Integer id);

	Receptionist saveStaff(Receptionist r);

	void deleteStaff(Integer id) throws GlobalException;

	List<Receptionist> saveAllStaff(List<Receptionist> receptionists);

}
