package com.mock.empapi.empapimock.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class Dao {

    @Autowired
    private EmployeeDataGenerator dataGenerator;

    private HashMap<Integer, Employee> data = new HashMap<>();

    @PostConstruct
    public void addData() throws IOException {
        List<Employee> employees = dataGenerator.generateEmployees(100);
        for (Employee employee : employees) {
            data.put(employee.getId(), employee);
        }
    }

    public Collection<Employee> findAll() {
        return data.values();
    }

    public Employee find(Integer id) {
        return data.get(id);
    }
}
