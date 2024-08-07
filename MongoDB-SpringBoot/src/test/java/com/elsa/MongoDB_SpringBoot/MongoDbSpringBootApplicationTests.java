package com.elsa.MongoDB_SpringBoot;

import com.elsa.MongoDB_SpringBoot.model.Expense;
import com.elsa.MongoDB_SpringBoot.model.ExpenseCategory;
import com.elsa.MongoDB_SpringBoot.repository.ExpenseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class MongoDbSpringBootApplicationTests {

	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.12");

	{
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry){
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Autowired
	private ExpenseRepository expenseRepository;


	@Test
	@DisplayName("Test WhetherExpenses are pre-populated")
	void shouldReturnPrePopulatedExpenses() {
		List<Expense> expenses = expenseRepository.findAll();
		assertEquals(5, expenses.size());
	}

	@Test
	@DisplayName("Should Find Expense By Name")
	void shouldFindExpenseByName(){
		Expense expectedExpense = new Expense();
		expectedExpense.setExpenseName("Evening Drinks");
		expectedExpense.setExpenseCategory(ExpenseCategory.MISC);
		expectedExpense.setExpenseAmount(BigDecimal.TEN);
		expenseRepository.save(expectedExpense);

		Expense actualExpense = expenseRepository.findByName("Evening Drinks").orElseThrow();
		assertEquals(expectedExpense.getExpenseName(), actualExpense.getExpenseName());
		assertEquals(expectedExpense.getExpenseCategory(), actualExpense.getExpenseCategory());
		assertEquals(expectedExpense.getExpenseAmount(), actualExpense.getExpenseAmount());
	}

}
