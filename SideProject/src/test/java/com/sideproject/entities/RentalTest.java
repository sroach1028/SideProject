package com.sideproject.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rental rental;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("SideProjectPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		rental = em.find(Rental.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rental = null;
	}

	@Test
	void test() {
		assertNotNull(rental);
	}
	@Test
	void testInventoryRelationship() {
		assertEquals("Black", rental.getBook().getAuthor());
	}
	@Test
	void testUserRelationship() {
		assertEquals(2, rental.getReader().getId());
	}

}
