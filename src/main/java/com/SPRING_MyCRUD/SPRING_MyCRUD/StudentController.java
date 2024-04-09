package com.SPRING_MyCRUD.SPRING_MyCRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Student> student=service.getAll();
		model.addAttribute("students",student);
		return "index";
	}
	
	@GetMapping("/AddStudentCall")
	public String AddStudentCall(Model model) {		
		model.addAttribute("students",new Student());
		return "AddStudentPage";		
	}
	
	@PostMapping("/save-students")
	public String saveStudents(@ModelAttribute Student students) {
		String name=students.getName();
		String email=students.getEmail();		
		
		service.save(students);		
		System.out.println(" name :"+name);			
		System.out.println(" email :"+email);	

		return "redirect:/";
	}
	
		
	@GetMapping("/student-update/{id}")
	public String editStudent(Model model,@PathVariable("id") Integer id) {		
		
		Student student=service.getById(id);
		model.addAttribute("students",student);		
		return "addEditStudentsPage";
	}
	
	
	@PostMapping("/saveStudentsEdited")
	public String saveStudentsEditeds(@ModelAttribute  Student students) {
		
		String name=students.getName();
		String email=students.getEmail();
		
		System.out.println(" name :"+name);			
		System.out.println(" email :"+email);
		
		service.save(students);
		return "redirect:/";
	}
		
	@GetMapping("/student-delete/{id}")
	public String deleteStudent(Model model,@PathVariable("id") Integer id) {
		Student student=service.getById(id);
		service.delete(student);
		
		return "redirect:/";
	}
	
	
	
	
}
