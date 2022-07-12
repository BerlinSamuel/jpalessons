package com.chainsys.jpa.application.doctor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DoctorService {
	@Autowired
	private DoctorRepository repo;
//	@Bean
//	public void setRepo(DoctorRepository repo) {
//		this.repo=repo;
//	}
	@GetMapping("/getdoctor")
	public Doctor getDoctor(int id) {
		return repo.findById(id);
	}
	@PostMapping(value="/newdoctor", consumes="application/json" )
	// we need give from where to read data from the HTTP request and also the content type("application/json")

	public String addNewDoctor(@RequestBody Doctor dr) {
		//System.out.println("Doctor:"+dr.getDoctor_id()+" "+dr.getDoctor_name());
		repo.save(dr);
		return "redirect:/getalldoctor";
	}
	@DeleteMapping("/deletedoctor")
	public String deleteDoctor(int id) {
		repo.deleteById(id);
		return "redirect:/getalldoctor";
	}
	@GetMapping("/getalldoctor")
	public List<Doctor> getAllDoctor(){
		return repo.findAll();
	}
	@PostMapping(value="/updatedoctor", consumes="application/json" )
	// we need give from where to read data from the HTTP request and also the content type("application/json")
	public String modifyDoctor(Doctor dr) {
		repo.save(dr);
		return "redirect:/getalldoctor";
	}
}
