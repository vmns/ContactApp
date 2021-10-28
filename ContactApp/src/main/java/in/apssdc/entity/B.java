package in.apssdc.entity;

public class B {

	public static void main(String[] args) {
		A a = new A();
		User u = a.m1();
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getLoginName());
		System.out.println(u.getPassword());
		System.out.println(u.getPhone());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());
		System.out.println(u.getUserId());
	}
}
