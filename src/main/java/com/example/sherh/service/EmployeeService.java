package com.example.sherh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sherh.atrbrut.Employee;
import com.example.sherh.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository repo;
	
	public List<Employee> listAll() {
        return repo.findAll();
    }
     
    
     
    public Employee get(long id) {
        return repo.findById(id).get();
    }



public void save(Employee scho) {
    repo.save(scho);
}





public List<Employee> searchByEmployeeNumber(String employeeNumber) {
    return repo.findByEmployeeNumberContainingIgnoreCase(employeeNumber);
}

public List<Employee> searchByName(String name) {
    return repo.findByEnameContainingIgnoreCase(name);
}





public Employee get(Long id) {
    return repo.findById(id).orElse(null);
}

	

public void delete(Long id) {
    repo.deleteById(id);
}

}