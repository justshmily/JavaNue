package csust.txr.mall;

import java.util.ArrayList;

/**
 * 产品分类
 * @author 谭笑然
 *
 */
public class Category {

	/**
	 * 分类名
	 */
	private String title;
	
	/**
	 * 属于分类的产品
	 */
	private ArrayList<Product> products=new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * @param title
	 * @param products
	 */
	public Category(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Category [title=" + title + ", products=" + products.size() + "]";
	}
	
	public void addProduct(Product pro) {
		this.products.add(pro);
	}
}
