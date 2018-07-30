package csust.txr.mall;

/**
 * 商品
 * @author 谭笑然
 *
 */
public class Product {
	
	/**
	 * 名称
	 */
	private String title;
	
	/**
	 * 价格
	 */
	private double price;
	
	/**
	 * 产商
	 */
	private Company company;
	
	/**
	 * 产品类别
	 */
	private Category category;

	
	/**
	 * @param title
	 * @param price
	 * @param company
	 * @param category
	 */
	public Product(String title, double price, Category ca) {
		super();
		this.title = title;
		this.price = price;
		this.category = ca;
		ca.addProduct(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", company=" + company + ", category=" + category + "]";
	}
	
}
