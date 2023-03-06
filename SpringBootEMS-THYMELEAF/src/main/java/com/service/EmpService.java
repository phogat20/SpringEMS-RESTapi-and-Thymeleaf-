package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	EmpRepo empRepo;

	public void addEmp(Employee e) {
		empRepo.save(e);
	}

	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	public Employee getEmpById(int id) {

		Optional<Employee> e = empRepo.findById(id);

		if (e.isPresent())
			return e.get();
		else
			return null;
	}

	public void deleteEmp(Integer id) {
		empRepo.deleteById(id);
	}
}