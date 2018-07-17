package com.everis.alicante.courses.beca.java.friendsnet.persistence.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.courses.beca.java.friendsnet.dao.EventDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class EventRepositoryIT {

	@Autowired
	private EventDao repository;
	
	@Test
	@DatabaseSetup("/db/Person/initial.xml")
    public void testFindAll() {
		//Act
		final List<Event> all = (List<Event>) repository.findAll();
				
		//Assert
		Assert.assertEquals(2, all.size());
	} 
	
	
}
