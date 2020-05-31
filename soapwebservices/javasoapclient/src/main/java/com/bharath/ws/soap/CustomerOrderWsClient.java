package com.bharath.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.DeleteOrdersRequest;
import com.bharath.ws.trainings.DeleteOrdersResponse;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWsClient {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerOrderWsClient.class);
	
	private static final String WSDL_URL = "http://localhost:8080/wsdlfirstws/customerordersservice?wsdl";
	
	private static Order getOrder() {
		
		List<Product> products = new ArrayList<Product>();
		
		Product product = new Product();
		product.setId("5");
		product.setDescription("product_test");
		product.setQuantity(BigInteger.valueOf(10));
		
		Product product2 = new Product();
		product2.setId("6");
		product2.setDescription("product_test2");
		product2.setQuantity(BigInteger.valueOf(20));
		
		products.add(product);
		products.add(product2);
		
		Order order = new Order();
		
		order.setId(BigInteger.valueOf(10));
		order.getProduct().addAll(products);
		
		return order;
	}
	
	private static void getOrders(CustomerOrdersPortType customerOrdersWsImplPort) {
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		
		logger.debug("Number of orders for the customer are: {}", orders.size());
		
	}
	
	private static void createOrder(CustomerOrdersPortType customerOrdersWsImplPort) {
		
		CreateOrdersRequest request = new CreateOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		request.setOrder(getOrder());
		
		CreateOrdersResponse response = customerOrdersWsImplPort.createOrders(request);
		
		if (response.isResult()) {
			logger.debug("New order has been created with id {}", request.getOrder().getId());
		}
		
	}
	
	private static void deleteOrders(CustomerOrdersPortType customerOrdersWsImplPort) {
		
		DeleteOrdersRequest request = new DeleteOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		
		DeleteOrdersResponse response = customerOrdersWsImplPort.deleteOrders(request);
		
		if (response.isResult()) {
			logger.debug("All orders have been deleted");
		}
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL(WSDL_URL));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		createOrder(customerOrdersWsImplPort);
		
		getOrders(customerOrdersWsImplPort);
		
		deleteOrders(customerOrdersWsImplPort);
		
	}

}
