package mockitotest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import defaultpack.SuperClass;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVerify {

	@Mock
	public SuperClass superClass;

	@Test
	public void testVerify() {
		// Mockito... when.. then
		Mockito.when(superClass.getMethod()).thenReturn("abc");
		// calling mock method
		System.out.println(superClass.getMethod());

		Assert.assertEquals("abc", superClass.getMethod());

		
		
	}

}
