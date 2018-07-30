package csust.txr.mall;

import java.util.ArrayList;
/**
 * 产品的生产商
 * @author 谭笑然
 *
 */
public class Company {

	/**
	 * 生产商
	 */
	private String title;
	
	/**
	 * 产品表单
	 */
	private ArrayList<Product> products= new ArrayList<>();

	
	/**
	 * @param title
	 */
	public Company(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product pro) {
		this.products.add(pro);
		pro.setCompany(this);
	}

	@Override
	public String toString() {
		return "Company [title=" + title + ", products=" + products.size() + "]";
	}
	
	
}
