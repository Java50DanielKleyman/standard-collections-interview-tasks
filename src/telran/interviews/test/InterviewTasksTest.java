package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.InterviewTasks;

class InterviewTasksTest {
	
	@BeforeEach
	void setUp() throws Exception {		
	}

	@Test
	void displayShuffledTest() {
		int[] test = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < 4; i++) {
			InterviewTasks.displayShuffled(test);
			System.out.println(" ");
		}
	}

}
