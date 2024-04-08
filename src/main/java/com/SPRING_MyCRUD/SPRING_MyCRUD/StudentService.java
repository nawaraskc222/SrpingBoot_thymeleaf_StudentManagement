package com.SPRING_MyCRUD.SPRING_MyCRUD;

import java.util.List;

public interface StudentService {
	
	void save(Student student);
	List<Student> getAll();
	
	Student getById(Integer id);
	void delete(Student student);

}
