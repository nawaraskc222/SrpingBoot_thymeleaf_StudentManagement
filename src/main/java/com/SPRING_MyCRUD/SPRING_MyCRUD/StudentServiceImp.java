package com.SPRING_MyCRUD.SPRING_MyCRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	StudentRepository repo;	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub		
		repo.save(student);		
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub		
		repo.delete(student);
		
	}

}
