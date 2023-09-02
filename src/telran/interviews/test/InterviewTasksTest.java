package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.InterviewTasks;
import telran.interviews.InterviewTasks.DateRole;

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
@Test
void  rolesInDateTest() {
	List<InterviewTasks.DateRole> datesRoles = new ArrayList<>();
	datesRoles.add(new DateRole(LocalDate.of(2017, 10, 12), "Developer"));
    datesRoles.add(new DateRole(LocalDate.of(2020, 1, 1), "Team leader"));
    datesRoles.add(new DateRole(LocalDate.of(2023, 8, 15), "Project Manager"));
    List<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.of(2015, 01,01));
    dates.add(LocalDate.of(2018, 01, 01));
    dates.add(LocalDate.of(2023, 01, 01));
    List<InterviewTasks.DateRole> expected = new ArrayList<>();
    expected.add(new DateRole(LocalDate.of(2015, 01,01), null));
    expected.add(new DateRole(LocalDate.of(2018, 01, 01), "Developer"));
    expected.add(new DateRole(LocalDate.of(2023, 01, 01), "Team leader"));
    assertEquals(expected, InterviewTasks.rolesInDates(datesRoles, dates));
}


}
