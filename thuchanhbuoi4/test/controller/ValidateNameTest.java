package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateNameTest {
	
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	// Nguyen Manh Duc - 20173039

	@ParameterizedTest
	@CsvSource ({
		"Nguyen Manh Duc, true",
		"Manh 1111, false",
		"abc 123, false",
		"Nguyen @@ Duc, false"
	})
	
	void test(String name, boolean valid) {
		boolean isValid = placeOrderController.validateName(name);
		assertEquals(isValid, valid);
	}

}
