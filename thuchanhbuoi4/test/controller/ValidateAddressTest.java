package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateAddressTest {
	
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		
		placeOrderController = new PlaceOrderController();
	}
	// Nguyen Manh Duc - 20173039
	@ParameterizedTest
	@CsvSource ({
		"so 2, Hai Ba Trung, Ha Noi true",
		"Ha Noi, true",
		"abc 123, false",
		"Dong Da @@, false"
	})
	void test(String Address, boolean valid) {
		boolean isValid = placeOrderController.validateAddress(Address);
		assertEquals(isValid, valid);
	}

}
