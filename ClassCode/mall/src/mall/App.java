package csust.txr.mall;

public class App {

	public static void main(String[] args) {
		
		//初始化
		//9个商品、4个厂商、3个分类
		
		//2个用户来买东西
		
		Category c1=new Category("食物");
		Category c2=new Category("服装");
		Category c3=new Category("家具");
		System.out.println(c1.toString());
		
		Product p1=new Product("薯片", 3.14, c1);
		Product p2=new Product("外套", 3.14, c2);
		Product p3=new Product("桌子", 3.14, c3);
		Product p4=new Product("豆子", 3.14, c1);
		Product p5=new Product("辣条", 3.14, c1);
		Product p6=new Product("衣柜", 3.14, c3);
		Product p7=new Product("衬衫", 3.14, c2);
		Product p8=new Product("苹果", 3.14, c1);
		Product p9=new Product("皮鞋", 3.14, c2);
		System.out.println(c1.toString());
		
		Company com1=new Company("特步");
		Company com2=new Company("金拱门");
		Company com3=new Company("宜家");
		System.out.println(com1.toString());
		com1.addProduct(p2);
		System.out.println(com1.toString());
		
		Account ac1=new Account("拉拉");
		Account ac2=new Account("菜菜");
		
	}

}
