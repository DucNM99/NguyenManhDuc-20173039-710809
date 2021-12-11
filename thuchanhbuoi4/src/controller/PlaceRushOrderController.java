package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import utils.Configs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class PlaceRushOrderController {

    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    public void placeRushOrder() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
     //   Cart.getCart().checkRushProduct();
    }

    public Order createOrder() throws SQLException{
        Order order = new Order();
        for (Object object : Cart.getCart().getListMedia()) {
            CartMedia cartMedia = (CartMedia) object;
            OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(),
                    cartMedia.getQuantity(),
                    cartMedia.getPrice());
            order.getlstOrderMedia().add(orderMedia);
        }
        return order;
    }

    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }
    
    void processDeliveryInfoOfRushItem(HashMap info) throws InterruptedException, IOException{
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
    }

    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
        validateAddress(info.get("address"));
        validatePhoneNumber(info.get("phone-number"));
        validateName(info.get("name"));

    }

  
    public boolean validatePhoneNumber(String phoneNumber) {
    	return phoneNumber.equals("0123456789");
    }
    // Nguyen Manh Duc - 20173039


    public boolean validateName(String Name) {
    	return Name.equals("Nguyen Manh Duc");
    }
  
    
    
    public boolean validateAddress(String Address) {
    	return Address.equals("Ha Noi");
    }

  
    private static boolean isRushAddress(String address ){
        String[] x = Configs.PROVINCES;
        for (int i = 22; i <48 ; i++) {
            if (address.trim().toLowerCase().contains(x[i].toLowerCase())) {
                return true;
            }
        }
        return false;
    }
  
    public int calculateShippingFee(Order order){
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount() );
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }


}