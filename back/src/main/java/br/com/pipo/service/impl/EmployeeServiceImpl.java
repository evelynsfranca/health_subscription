package br.com.pipo.service.impl;

import br.com.pipo.model.Address;
import br.com.pipo.model.Employee;
import br.com.pipo.model.enumeration.PartnerName;
import br.com.pipo.repository.AddressRepository;
import br.com.pipo.repository.EmployeeRepository;
import br.com.pipo.repository.ProductRepository;
import br.com.pipo.service.EmployeeService;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public EmployeeServiceImpl(
        EmployeeRepository employeeRepository,
        AddressRepository addressRepository,
        ProductRepository productRepository
    ) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Employee save(Employee employee) {

        employee.getProducts().stream()
            .map(it -> productRepository.findById(it.getId())
                .orElseThrow(() -> new NotFoundException("Product not found.")))
            .filter(it -> it.getPartner().getName().equals(PartnerName.PAMPULHA_INTRAMEDICA))
            .findAny()
            .ifPresent(it -> {
                Address address = addressRepository.save(employee.getAddress());
                employee.setAddress(address);
            });

        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(String id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Employee not found."));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
