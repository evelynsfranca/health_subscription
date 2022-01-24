package br.com.pipo.service;

import br.com.pipo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee get(String id);

    List<Employee> getAll();
}
