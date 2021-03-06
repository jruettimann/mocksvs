package com.mock.empapi.empapimock.controller;

import com.google.common.collect.Collections2;
import com.mock.empapi.empapimock.data.Dao;
import com.mock.empapi.empapimock.data.Employee;
import com.mock.empapi.empapimock.data.EmployeeState;
import com.mock.empapi.empapimock.data.PresenceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeesController {

    @Autowired
    private Dao dao;

    @GetMapping("/employees")
    public Collection<Employee> findAll(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "q", required = false) String q) {
        Collection<Employee> all = dao.findAll();
        Collection<Employee> filtered = Collections2.filter(all, (employee -> (q == null || (employee.getFirstName() + " " + employee.getLastName()).toLowerCase().contains(q))));
        return new PageData<>(offset, limit, filtered).getPageValues();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> find(@PathVariable("id") Integer id) {
        try {
            Employee employee = dao.find(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/{id}/state")
    public ResponseEntity<EmployeeState> getState(@PathVariable("id") Integer id) {
        try {
            Employee employee = dao.find(id);
            if (employee == null) {
                throw new Exception("Employee mit ID=" + id + " existiert nicht.");
            }
            PresenceState presence = employee.getPresenceState();
            return ResponseEntity.ok(new EmployeeState(presence));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/{id}/images/portrait")
    public ResponseEntity<Resource> getPortrait(@PathVariable("id") Integer id) {
        try {
            Employee employee = dao.find(id);
            InputStreamResource resource = new InputStreamResource(employee.getImageFile());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
