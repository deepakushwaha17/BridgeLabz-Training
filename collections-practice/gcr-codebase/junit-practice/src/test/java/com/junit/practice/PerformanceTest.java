package com.junit.practice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

	PerformanceTask task = new PerformanceTask();
	
	@Test
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void testTask() throws InterruptedException{
        assertEquals("Completed", task.longRunningTask());
	}
}
