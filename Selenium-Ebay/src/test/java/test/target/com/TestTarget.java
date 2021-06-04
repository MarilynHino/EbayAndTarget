package test.target.com;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import target.com.IphoneTarget;

public class TestTarget {

	@Test
	public void testTarget() throws IOException {

		IphoneTarget.targetPurchase();
	}

}
