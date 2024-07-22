package com.elsa.MongoDB_SpringBoot.service;

import com.elsa.MongoDB_SpringBoot.model.Expense;
import com.elsa.MongoDB_SpringBoot.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){

        expenseRepository.insert(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
}
