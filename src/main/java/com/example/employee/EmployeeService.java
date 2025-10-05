package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> listAll() { return repo.findAll(); }

    public Optional<Employee> getById(Long id) { return repo.findById(id); }

    public Employee create(Employee e) { return repo.save(e); }
}
