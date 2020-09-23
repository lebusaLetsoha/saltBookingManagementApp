package com.saltsoftware.controller.employee;


import com.saltsoftware.entity.employee.EmployeeRole;
import com.saltsoftware.factory.employee.EmployeeRoleFactory;
import com.saltsoftware.service.employee.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Sakeena Francis
 * Part Time
 * 215006097
 * 22-Sep-2020
 * EmployeeRoleController: created for mapping to employeerole (base), "CRUD" path of the application
 */

import java.util.Set;

@RestController
@RequestMapping("/employeerole")
public class EmployeeRoleController {

    @Autowired //used to create a connection to the service package
    private EmployeeRoleService employeeRoleService;

    //@RequestMapping("/create")
    @PostMapping("/create")
    public EmployeeRole create(@RequestBody EmployeeRole employeeRole){
        EmployeeRole newEmployeeRole = EmployeeRoleFactory.buildEmployeeRole(employeeRole.getEmpID());
        return employeeRoleService.create(newEmployeeRole);
    }

    //read
    @GetMapping("/read/{id}")
    @ResponseBody
    public EmployeeRole read(@PathVariable String id){
        return employeeRoleService.read(id);
    }

    //getall
    @GetMapping("/all")
    public Set<EmployeeRole> getall(){
       return employeeRoleService.getAll();
    }

    //update
    @PostMapping("/update")
    public EmployeeRole update(@RequestBody EmployeeRole employeeRole){
        return employeeRoleService.update(employeeRole);
    }

    //delete
    @DeleteMapping ("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        employeeRoleService.delete(id);
    }
}