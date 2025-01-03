package com.maiia.pro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ProApplicationTests {

	@Test
	void contextLoads() {
		ProApplication.main(new String[] {});
	}

}
