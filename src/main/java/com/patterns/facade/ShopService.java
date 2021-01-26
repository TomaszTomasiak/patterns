package com.patterns.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ShopService {

    private final List<Order> orders = new ArrayList<>();

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private ProductService productService;

    public Long openOrder(long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long) orders.stream()
                    .mapToInt(order -> order.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(long orderId, long productId, double qty) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(long orderId, Long productId) throws Exception {

//        Iterator<Order> orderIterator = orders.stream()
//                .filter(order -> order.getOrderId().equals(orderId))
//                .iterator();

        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
            for (Item tmpItem : theOrder.getItems()) {
                if (tmpItem.getProductId().equals(productId)) {
                    theOrder.getItems().remove(tmpItem);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(long orderId) throws Exception {

        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
            return theOrder.calculateValue();
        } else {
            return BigDecimal.ZERO;
        }
    }

    public boolean doPayment(long orderId) throws Exception {
        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
            return theOrder.isPaid();
        } else {
            Random generator = new Random();
            theOrder.setPaid(generator.nextBoolean());

            return theOrder.isPaid();
        }
    }

    public boolean verifyOrder(long orderId) throws Exception {
        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
            boolean result = theOrder.isPaid();
            Random gen = new Random();
            if(!theOrder.isVerified()) {
                theOrder.setVerified(result && gen.nextBoolean());
            }
            return theOrder.isVerified();
        }

        return false;
    }

    public boolean submitOrder(long orderId) throws Exception {

        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
            if(theOrder.isVerified()) {
                theOrder.setSubmitted((true));
            }
            return theOrder.isSubmitted();
        }

        return false;
    }

    public void cancelOrder(long orderId) throws Exception {
        Order theOrder = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst().orElseThrow(Exception::new);

        if (theOrder != null) {
           orders.remove(theOrder);
        }
    }
}
