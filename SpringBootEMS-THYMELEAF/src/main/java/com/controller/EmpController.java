package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Employee;
import com.service.EmpService;

import ch.qos.logback.core.model.Model;
import jakarta.websocket.server.PathParam;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	@GetMapping("/")
	public String home(org.springframework.ui.Model m) {
		List<Employee> emp = empService.getAllEmployee();
		m.addAttribute("emp", emp);
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) {
		System.out.println(e);
		empService.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id,org.springframework.ui.Model m) {
		Employee e=empService.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		empService.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		empService.deleteEmp(id);
		return "redirect:/";
	}
	
	
}
