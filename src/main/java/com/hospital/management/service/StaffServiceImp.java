package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Receptionist;
import com.hospital.management.error.GlobalException;
import com.hospital.management.repository.StaffRepository;

@Service
public class StaffServiceImp implements StaffService{
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public List<Receptionist> getAllStaff(){
		return staffRepository.findAll();
	}
	
	@Override
	public Receptionist getStaffById(Integer id) {
		return staffRepository.findById(id).orElse(null);
	}
	
	@Override
	public Receptionist saveStaff(Receptionist r) {
		return staffRepository.save(r);
	}
	
	@Override
	public void deleteStaff(Integer id) throws GlobalException {
		Optional<Receptionist> rec = staffRepository.findById(id);
		if(!rec.isPresent()) {
			throw new GlobalException("Receptionist Not Found with ID: " + id);
		}
		staffRepository.delete(rec.get());
	}

	@Override
	public List<Receptionist> saveAllStaff(List<Receptionist> receptionists) {
		return staffRepository.saveAll(receptionists);
	}
}
