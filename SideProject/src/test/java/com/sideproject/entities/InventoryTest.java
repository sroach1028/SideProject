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

class InventoryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Inventory inventory;
	
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
		inventory = em.find(Inventory.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		inventory = null;
	}

	@Test
	void test() {
		assertEquals("Black", inventory.getAuthor());
	}
	@Test
	void test2() {
		assertEquals(1988, inventory.getYear());
	}

}
