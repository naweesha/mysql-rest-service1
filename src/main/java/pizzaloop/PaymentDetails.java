package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer paymentId;
    private Integer orderId;
    private String cardNo;
    private String CrdpinNo;
    private Date dateOfexp;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCrdpinNo() {
        return CrdpinNo;
    }

    public void setCrdpinNo(String crdpinNo) {
        CrdpinNo = crdpinNo;
    }

    public Date getDateOfexp() {
        return dateOfexp;
    }

    public void setDateOfexp(Date dateOfexp) {
        this.dateOfexp = dateOfexp;
    }


}
