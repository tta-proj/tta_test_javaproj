package tta.pro;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class LoginTest {
	
	private Login log;

	@Before
	public void Setup() {
		MainFrame fm = new MainFrame();
		log = new Login(fm);	
	}

	
	@Test //�α���
	public void testLogin() {
		String result = log.checkedLogin("tta", "tta1234");
		assertEquals("�α��� ����", result);
	}
	

}