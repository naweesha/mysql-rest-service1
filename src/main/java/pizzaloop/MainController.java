package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;
    private static final String SUCCESS= "Saved";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private PaymentRepository paymentRepository;




    /*
    read operation
    this method will list all the pizza in the table
    URI to access this: http://localhost:8080/demo/allpizza
     */


    @GetMapping(path="/allpizza")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }

    @GetMapping(path="/alluser")
    public @ResponseBody Iterable<UserDetails> getUserDetails() {
        return userRepository.findAll();
    }

    @GetMapping(path="/allorder")
    public @ResponseBody Iterable<PizzaOrderDetails> getPizzaOrderDetails() {
        return pizzaOrderRepository.findAll();
    }

    @GetMapping(path="/allpayment")
    public @ResponseBody Iterable<PaymentDetails> getPaymentDetails() {
        return paymentRepository.findAll();
    }




    /*READ operation based on pizza Id
     this method will retutn the details of aorder specified by the id
     URL to access this: http://lcalhost:8080/demo/findByPizzaId?id=2

     */

    @GetMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }

    @GetMapping(path="/findByUserId")
    public @ResponseBody List<UserDetails> getUserById(@RequestParam Integer id) {
        return userRepository.findByUserId(id);

    }

    @GetMapping(path="/findByOrderId")
    public @ResponseBody List<PizzaOrderDetails> getOrderById(@RequestParam Integer id) {
       return pizzaOrderRepository.findByOrderId(id);
    }


   @GetMapping(path="/findByPaymentId")
    public @ResponseBody List<PaymentDetails> getPaymentById(@RequestParam Integer id) {
       return paymentRepository.findByPaymentId(id);
    }





   /*Create operation
   this will create new payment in the database
   and retrn success message
   uri to the accept this: hhtp://localhost:8080/addpizza?vegipizza&description=vegiSuperme&price2500.75
    */

    @GetMapping(path="/addpizza")
    public @ResponseBody String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }


    @GetMapping(path="/addpayment")
    public @ResponseBody String addNewPayment(@RequestParam String cardno, @RequestParam String pinno, @RequestParam Date dateofexp) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCardNo(cardno);
        paymentDetails.setCrdpinNo(pinno);
        paymentDetails.setDateOfexp(dateofexp);
        paymentRepository.save(paymentDetails);
        return SUCCESS;
    }


    @GetMapping(path="/addorder")
    public @ResponseBody String addNewPizzaOrder(@RequestParam String name, @RequestParam String address, @RequestParam String contactNo) {
        PizzaOrderDetails pizzaOrderDetails = new PizzaOrderDetails();
        pizzaOrderDetails.setName(name);
        pizzaOrderDetails.setAddress(address);
        pizzaOrderDetails.setContactNo(contactNo);
        pizzaOrderRepository.save(pizzaOrderDetails);
        return SUCCESS;
    }









    /*DELETE operation
       this method will delete existing pizza item by finding it use the id and returns the return items
      URI  TO ACCESS this : http://localhost:8080/demo/deleteById?id=2
   */


    @GetMapping(path="/deleteByPizzaId")
    public @ResponseBody List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }

/*
    @GetMapping(path="/deleteByUserId")
    public @ResponseBody List<UserDetails> deleteUserById(@RequestParam Integer id) {
        return UserRepository.deleteByUserId(id);
    }
*/


/*
    @GetMapping(path="/deleteByOrderId")
    public @ResponseBody List<PizzaOrderDetails> deleteOrderById(@RequestParam Integer id) {
        return PizzaOrderRepository.deleteByOrderId(id);
    }
*/





    /*UPDATE operation
    this method will  update exisrting  pizza details by finding it using the ID
    AND RETURN THE UPDATE data
    URI  to access this :http://localhost:8080/demo/update?id=1&name=updatename&description=updated&rice=1230.00

     */



    @GetMapping(path="/updatepizza")
    public @ResponseBody List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        //first get all the pizza details according to the provided ID
        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if(!pizzaDetailsList.isEmpty()) {
            //iTERATE through the pizza list
            for(PizzaDetails pizzaDetails: pizzaDetailsList) {

                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                //update existing pizza item
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }


    @GetMapping(path="/updateOrder")
    public @ResponseBody List<PizzaOrderDetails> updatePizzaOrderDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String address, @RequestParam String contactNo) {
        //first get all the pizza details according to the provided ID
        List<PizzaOrderDetails> pizzaOrderDetailsList = pizzaOrderRepository.findByOrderId(id);
        if(!pizzaOrderDetailsList.isEmpty()) {
            //iTERATE through the pizza list
            for(PizzaOrderDetails pizzaOrderDetails: pizzaOrderDetailsList) {

                pizzaOrderDetails.setOrderId(id);
                pizzaOrderDetails.setName(name);
                pizzaOrderDetails.setAddress(address);
                //PizzaOrderDetails. setContactNo(contactNo);
                //update existing pizza item
                pizzaOrderRepository.save(pizzaOrderDetails);
            }
        }
        return pizzaOrderRepository.findByOrderId(id);
    }







}
