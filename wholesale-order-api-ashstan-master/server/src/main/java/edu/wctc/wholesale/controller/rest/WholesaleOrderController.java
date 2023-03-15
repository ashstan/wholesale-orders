package edu.wctc.wholesale.controller.rest;

import edu.wctc.wholesale.dto.Order;
import edu.wctc.wholesale.entity.Customer;
import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.service.CustomerServiceImpl;
import edu.wctc.wholesale.service.ProductServiceImpl;
import edu.wctc.wholesale.service.WholesaleOrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins="http://localhost:63342")
public class WholesaleOrderController {

    @GetMapping
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        List<WholesaleOrder> wholesaleOrderList = wholesaleOrderService.getAllOrders();
        for(WholesaleOrder wholesaleOrder : wholesaleOrderList) {
            list.add(convertToDto(wholesaleOrder));
        }
        return list;
    };

    @Autowired
    private WholesaleOrderServiceImpl wholesaleOrderService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ModelMapper modelMapper;

    //books example
    private Order convertToDto(WholesaleOrder wholesaleOrder) {
        Order order = modelMapper.map(wholesaleOrder, Order.class);
        return order;
    }

    private WholesaleOrder convertToEntity(Order order) throws ResourceNotFoundException {
        WholesaleOrder wholesaleOrder = modelMapper.map(order, WholesaleOrder.class);
        Product product = productService.getProduct(order.getProductName());
        Customer customer = customerService.getCustomer(order.getCustomerName());
        wholesaleOrder.setProduct(product);
        wholesaleOrder.setCustomer(customer);
        return wholesaleOrder;
    }
}
