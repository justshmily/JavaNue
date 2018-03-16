package type3;

/**
 * 使用泛型方法求最大值和最小值
 * 
 * @author 15295
 *
 */
public class MaxMinUtil {

	public static <T extends Comparable<T>> MaxMin<T> getMaxMin(T[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}

		T max = arr[0];
		T min = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (max.compareTo(arr[i]) < 0) {
				max = arr[i];
			}
			if (min.compareTo(arr[i]) >= 0) {
				min = arr[i];
			}
		}

		MaxMin<T> maxMin = new MaxMin<T>(max, min);
		return maxMin;
	}

	public static void main(String[] args) {
		String[] str = { "A", "B", "C" };
		Integer[] num = { 23, 44, 55 };
		MaxMin<String> mx = MaxMinUtil.getMaxMin(str);
		System.out.println(mx.getMax());
		System.out.println(mx.getMin());

		MaxMin<Integer> mx2 = MaxMinUtil.getMaxMin(num);
		System.out.println(mx2.getMax());
		System.out.println(mx2.getMin());
	}
}
