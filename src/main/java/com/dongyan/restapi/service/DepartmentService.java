package com.dongyan.restapi.service;

import com.dongyan.restapi.persistence.Department;
import com.dongyan.restapi.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//business logic
@Service
public class DepartmentService {
    DepartmentRepository repository;
    public DepartmentService(DepartmentRepository repository){
        this.repository = repository;
    }
    public List<Department> getAll(){
        return this.repository.findAll();
    }
    public Department getById(Long id){
        return this.repository.findById(id).get();
    }
    public Department add(Department department){
        return this.repository.save(department);
    }
    public Department update(Long id, Department department){
        Optional<Department> dept = this.repository.findById(id);
        if (dept.isPresent()){
            dept.get().setName(department.getName());
            return this.repository.save(dept.get());
        }
        throw new RuntimeException();
    }
    public void delete(long id){
       this.repository.deleteById(id);
    }
}
