package jarekprzygodzki;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/beans.xml" })
public class AppTest {

	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void testSetup() {
		Session session = sessionFactory.getCurrentSession();
	}
}
