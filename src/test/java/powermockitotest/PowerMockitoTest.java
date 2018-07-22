package powermockitotest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import powerMockPackage.PowerMockitoClass;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "powerMockPackage.*")
public class PowerMockitoTest {

	@Mock
	PowerMockitoClass pmClass;

	@Test@Ignore
	public void verifyNew() throws Exception {
		PowerMockito.whenNew(PowerMockitoClass.class).withNoArguments().thenReturn(pmClass);
		PowerMockitoClass powerMockitoClass = new PowerMockitoClass();
		PowerMockito.verifyNew(PowerMockitoClass.class).withNoArguments();
	}

	@Test
	public void verifyStatic() throws Exception {
		PowerMockito.mockStatic(PowerMockitoClass.class);
		PowerMockito.when(PowerMockitoClass.method(Mockito.anyString())).thenReturn("vall");
		
	}
}
