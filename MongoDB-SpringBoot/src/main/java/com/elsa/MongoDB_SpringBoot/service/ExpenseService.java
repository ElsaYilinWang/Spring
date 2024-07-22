package com.elsa.MongoDB_SpringBoot.service;

import com.elsa.MongoDB_SpringBoot.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
}
