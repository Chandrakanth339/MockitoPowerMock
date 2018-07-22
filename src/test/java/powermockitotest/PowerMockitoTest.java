package powermockitotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import powerMockPackage.PowerMockitoClass;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "powerMockPackage.*")
public class PowerMockitoTest {

	@Test
	public void powerMockitoTest() throws Exception {
		PowerMockitoClass pmClass = PowerMockito.mock(PowerMockitoClass.class);
		PowerMockito.whenNew(PowerMockitoClass.class).withNoArguments().thenReturn(pmClass);
		PowerMockitoClass powerMockitoClass = new PowerMockitoClass();
		PowerMockito.verifyNew(PowerMockitoClass.class).withNoArguments();
	}

}
