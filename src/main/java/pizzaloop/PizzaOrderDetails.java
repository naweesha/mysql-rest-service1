package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PizzaOrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer pizzaId;
    private  Integer orderId;
    private String name;
    private  String address;
    private String contactNo;


    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() { return contactNo; }

    public void setContactNo(String contactNo) { this.contactNo = contactNo; }







}
