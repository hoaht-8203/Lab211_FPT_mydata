package fruitShop;

import java.util.List;
import java.util.Set;

public class Order {
    private String customerName;
    private List<OrderDetail> orderDetails;
    private double total;
    public Order() {
    }

    public Order(String customerName, List<OrderDetail> orderDetails, double total) {
        this.customerName = customerName;
        this.orderDetails = orderDetails;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
