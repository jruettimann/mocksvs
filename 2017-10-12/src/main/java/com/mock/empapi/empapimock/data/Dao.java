package com.mock.empapi.empapimock.data;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@Component
public class Dao {

    private HashMap<Integer, Employee> data = new HashMap<>();

    @PostConstruct
    public void addData() throws IOException {
        Employee e1 = new Employee(1);
        e1.setFirstName("Hans");
        e1.setLastName("Muster");
        e1.setJobTitle("Applikationsentwickler");
        e1.setJobRole("Mitarbeiter");
        e1.setDepartment("IT");
        e1.setEmail("hans.muster@company.biz");
        e1.setPhone("+41711234567");
        e1.setBankNumber("8000");
        data.put(e1.getId(), e1);

        Employee e2 = new Employee(2);
        e2.setFirstName("Adriana");
        e2.setLastName("Bernasconi");
        e2.setJobTitle("Kundenberaterin");
        e2.setJobRole("Mitarbeiter");
        e2.setDepartment("Zentrale");
        e2.setEmail("adriana.bernasconi@company.biz");
        e2.setPhone("+41711234568");
        e2.setBankNumber("8000");
        data.put(e2.getId(), e2);
    }

    public Collection<Employee> findAll() {
        return data.values();
    }

    public Employee find(Integer id) {
        return data.get(id);
    }
}
