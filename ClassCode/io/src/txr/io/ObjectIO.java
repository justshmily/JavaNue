package txr.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectIO {

	public static class Address implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -4204473796272866730L;
		
	}
	public static class Person implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5195792629471255278L;
		String name;
		int age;
		Address address;
		
		public Person(String name,int age,Address address) {
			super();
			this.name=name;
			this.age=age;
			this.address=address;
		}
	}
	public static void main(String[] args) {
		
		//write();
		read();
	}

	private static void read() {
	
		try (ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("data.txt")))){
			
			//读取对象
			ArrayList<Person> o=(ArrayList<Person>) in.readObject();
			
			for(Person person: o) {
				System.out.println(person.name+","+person.age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void write() {
		
		try (ObjectOutputStream out =new ObjectOutputStream(
				new FileOutputStream("data.txt"))){
			
			Person p1=new Person("lala",18,new Address());
			Person p2=new Person("ffd",18,new Address());
			Person p3=new Person("ss",18,new Address());
			
			ArrayList<Person> list=new ArrayList<>();
			list.add(p1);
			list.add(p2);
			list.add(p3);
			
			//序列化
			out.writeObject(list);
			
			System.out.println("ok");
			
		} catch (Exception e) {
			
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
