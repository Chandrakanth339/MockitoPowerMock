package mockitotest;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import defaultpack.SuperClass;
import defaultpack.SuperClass2;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVerify {

	@Mock
	public SuperClass superClass;

	@InjectMocks
	public SuperClass2 superClass2;

	@Ignore
	@Test
	public void testVerify() {
		// Mockito... when.. then
		Mockito.when(superClass.getMethod()).thenReturn("abc");
		// calling mock method
//		System.out.println(superClass.getMethod());

		Assert.assertEquals("abc", superClass.getMethod());

		Mockito.verify(superClass).getMethod();

	}

	// this test demonstrates how to return values based on the input
	@Ignore
	@Test
	public void testReturnValueDependentOnMethodParameter() {
		Comparable<String> c = Mockito.mock(Comparable.class);

		Mockito.when(c.compareTo("Mockito")).thenReturn(1);
		Mockito.when(c.compareTo("Eclipse")).thenReturn(2);

		Assert.assertEquals(1, c.compareTo("Mockito"));
	}

	// this test demonstrates how to return values independent of the input value
	@Ignore
	@Test
	public void testReturnValueInDependentOnMethodParameter() {

		Comparable<Integer> c = Mockito.mock(Comparable.class);
		Mockito.when(c.compareTo(Mockito.anyInt())).thenReturn(-1);

		Assert.assertEquals(-1, c.compareTo(9));
	}

	// return a value based on the type of the provide parameter

	@Ignore
	@Test
	public void testReturnValueInDependentOnMethodParameter2() {
		Comparable<SuperClass> c = Mockito.mock(Comparable.class);
		Mockito.when(c.compareTo(Mockito.isA(SuperClass.class))).thenReturn(0);
		// assert
		Assert.assertEquals(0, c.compareTo(new SuperClass()));
	}

	@Ignore
	@Test
	public void testThrowException() {

		try {
			Properties mockObj = Mockito.mock(Properties.class);
			Mockito.when(mockObj.getProperty("av")).thenThrow(Exception.class);
			mockObj.getProperty("av");
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void testVerifyDiffScenarios() {

		Mockito.when(superClass.getMethod()).thenReturn("nullValue");

		// No interactions were made within this test method above the Line:93
		Mockito.verifyZeroInteractions(superClass);
		superClass.getMethod();

		// Throws NoInteractionsWanted exception as an interaction of mock object
		// occured@Line 94
//		Mockito.verifyZeroInteractions(superClass);

		// Alternative to method verifyZeroInteractions(Object obj)
		Mockito.verify(superClass, Mockito.never()).getString();
		// To Verify that the particular method is called atleast once
		Mockito.verify(superClass, Mockito.atLeastOnce()).getMethod();

		// To verify that a particular method is called atleast by no. of times
		// specified
		Mockito.verify(superClass, Mockito.atLeast(3)).getString();
		// To verify that a particular method is called times mentioned
		Mockito.verify(superClass, Mockito.times(3)).getString();
		// To verify that a partiular method is called by atmost number of times
		// specified
		Mockito.verify(superClass, Mockito.atMost(3)).getString();

	}

}
