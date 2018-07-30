package csust.txr.mall;

import java.util.ArrayList;
import java.util.Date;

/**
 * 订单
 * @author 谭笑然
 *
 */
public class Order {

	/**
	 * 订单的用户
	 */
	private Account account;
	
	/**
	 * 订单时间
	 */
	private Date time;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 总金额
	 */
	private double total;
	
	private ArrayList<Item> items=new ArrayList<>();
	
	
}
