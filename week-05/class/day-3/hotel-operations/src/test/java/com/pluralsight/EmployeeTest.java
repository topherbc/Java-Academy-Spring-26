package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn_sets_a_startime() {
        //arrange
        int startTime = 8;
        int endTime = 16;
        Employee testEmployee = new Employee(1, "Test", "Test", 100, 0);

        //act
        testEmployee.punchIn(startTime);

        //assert
        assertEquals(startTime, testEmployee.getStartTime());
    }

    @Test
    void punchOut_should_add_hours_worked() {
        //arrange
        int startTime = 8;
        int endTime = 16;
        int testHoursWorked = endTime-startTime;
        Employee testEmployee = new Employee(1, "Test", "Test", 100, 0);

        //act
        testEmployee.punchIn(startTime);
        testEmployee.punchOut(endTime);

        //assert
        assertEquals(testHoursWorked, testEmployee.getRegularHours());
    }

    @Test
    public void punchTimeCard_add_time_to_hours_worked() {
        //arrange
        int startTime = 8;
        int endTime = 16;
        int testHoursWorked = endTime-startTime;
        Employee testEmployee = new Employee(1, "Test", "Test", 100, 0);

        //act
        testEmployee.punchTimeCard(startTime);
        testEmployee.punchTimeCard(endTime);

        //assert
        assertEquals(testHoursWorked, testEmployee.getRegularHours());
    }
}