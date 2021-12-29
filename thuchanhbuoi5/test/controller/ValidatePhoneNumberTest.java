package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatePhoneNumberTest {
	
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
		
	}
	//Nguyen Manh Duc - 20173039
	@ParameterizedTest
	@CsvSource ({
		"0123456789, true",
		"01234, false",
		"abc123, false",
		"1234567890, false"
	})
	void test(String phonenumber, boolean valid) {
		boolean isValid = placeOrderController.validatePhoneNumber(phonenumber);
		assertEquals(isValid, valid);
	}

}
