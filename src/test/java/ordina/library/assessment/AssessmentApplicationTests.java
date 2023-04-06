package ordina.library.assessment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ordina.library.assessment.Controllers.LibraryCalculationController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AssessmentApplicationTests {

	@Autowired
	private LibraryCalculationController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
