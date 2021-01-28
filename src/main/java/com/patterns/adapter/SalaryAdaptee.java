package com.patterns.adapter;

import com.patterns.adapter.newhrsystem.CompanySalaryProcessor;
import com.patterns.adapter.newhrsystem.Employee;
import com.patterns.adapter.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
        return theProcessor.calculateSalaries(employees);
    }
}
