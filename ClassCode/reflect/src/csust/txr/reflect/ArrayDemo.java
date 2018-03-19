package csust.txr.reflect;

import java.lang.reflect.Array;

public class ArrayDemo {

	public static void main(String[] args) {
		// 创建int类型的数组
		Object arr = Array.newInstance(int.class, 5);
		// int[] arr=new int[5];

		// 为数组赋值
		Array.set(arr, 0, 1);
		Array.set(arr, 1, 11);
		Array.set(arr, 2, 11);
		Array.set(arr, 3, 12);
		Array.set(arr, 4, 15);

		// 数组长度
		System.out.println(Array.getLength(arr));

		// 获取元素
		System.out.println(Array.get(arr, 1));

		// 遍历
		for (int i = 0; i < Array.getLength(arr); i++) {

			System.out.println(Array.get(arr, i));
		}
	}

}
