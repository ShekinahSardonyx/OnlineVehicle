package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin updateAdminPassword(int id, String pwd) {
		Admin admin = adminRepository.findById(id).get();
		admin.setAdminPassword(pwd);
		adminRepository.flush();
		return admin;
	}
	
	public Admin updateAdminName(int id, String adminFirstName) {
		Admin admin = adminRepository.findById(id).get();
		admin.setAdminFirstName(adminFirstName);
		adminRepository.flush();
		return admin;
	}
	public List<Admin> deleteAdmin(int id) {
		adminRepository.deleteById(id);
		return adminRepository.findAll();
	}
	
	
}
