package com.elsa.MongoDB_SpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MongoDbSpringBootApplicationTests {

	@Test
	void contextLoads() {
	}

}
