package controller.rushorder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceRushOrderController;

class validateRushAddressTest {
	private PlaceRushOrderController placeRushOrderController;

	@BeforeEach
    void setUp() throws Exception {
        placeRushOrderController = new PlaceRushOrderController();

    }
    // Nguyen Manh Duc - 20173039
    @ParameterizedTest
    @CsvSource({
            "Ha Noi,true",
            "Ha Noi 0,false",
            "@@,false",

    })

    void test(String address, boolean expected){
        boolean isValided = placeRushOrderController.validateAddress(address);
        assertEquals(expected, isValided);
    }
}