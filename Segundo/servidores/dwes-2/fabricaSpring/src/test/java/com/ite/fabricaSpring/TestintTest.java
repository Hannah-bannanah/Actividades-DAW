package com.ite.fabricaSpring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestintTest {
	private static int testCounter = 0;
	@BeforeAll
	static void hello() {
		System.out.println("We are getting started");
	}
	
	@AfterAll
	static void bye() {
		System.out.println("You will be missed");
	}
	
	@BeforeEach
	void starting() {
		++testCounter;
		System.out.println("Comencing test #" + testCounter);
	}
	
	@AfterEach
	void ending() {
		System.out.println("Completed test #" + testCounter);
	}
	
	@Test
	void trueFalse() {
		assertEquals(!true, false);
	}
	
	@Test
	void trueTrue() {
		assertTrue(true);
	}

}
