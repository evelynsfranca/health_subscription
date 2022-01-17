package br.com.pipo.service.impl;

import br.com.pipo.model.Employee;
import br.com.pipo.repository.EmployeeRepository;
import br.com.pipo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.findById(employee.getId())
            .map(it -> {
                it.setCpf(employee.getCpf());
                it.setName(employee.getName());
                it.setEmail(employee.getEmail());
                it.setAdmissionDate(employee.getAdmissionDate());
                it.setHeight(employee.getHeight());
                it.setWeight(employee.getWeight());
                it.setMeditationHours(employee.getMeditationHours());

                return it;
            }).map(employeeRepository::save)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found."));
    }

    @Override
    public Employee get(String id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found."));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(String id) {
        employeeRepository.findById(id)
            .ifPresent(employeeRepository::delete);
    }
}
