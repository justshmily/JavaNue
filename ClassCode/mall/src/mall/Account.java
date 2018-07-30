package csust.txr.mall;

import java.util.ArrayList;

/**
 * 账号
 * @author 谭笑然
 *
 */
public class Account {
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 订单
	 */
	private ArrayList<Order> orders= new ArrayList<>();
	
	/**
	 * @param name
	 */
	public Account(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrders(Order or) {
		this.orders.add(or);
	}

	public void addProduct(Product pro1) {
		
	}
	
	public void showInfo() {
		System.out.println("用户"+name+"的订单"+orders.toString());
	}
}
