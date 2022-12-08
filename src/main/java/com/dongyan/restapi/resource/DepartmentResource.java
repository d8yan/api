package com.dongyan.restapi.resource;

import com.dongyan.restapi.persistence.Department;
import com.dongyan.restapi.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentResource {
    DepartmentService service;
    //Constructor
    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }
    @GetMapping(value = "/departments")
    public List<Department> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getbyId(@PathVariable Long id){
        return this.service.getById(id);
    }

    @PostMapping(value = "/departments", consumes = "application/json")
    public Department add(@RequestBody Department department){
        return this.service.add(department);
    }

    @PutMapping(value = "/departments/{id}",consumes = "application/json")
    public Department update( @PathVariable Long id, @RequestBody Department department){
        return this.service.update(id,department);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }
}
