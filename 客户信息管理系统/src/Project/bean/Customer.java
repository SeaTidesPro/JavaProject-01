package Project.bean;


/*
 *@Description Customer为实体对象，封装了用户信息。 
 *@author SeaTides Email:981637700@qq.com
 *@version
 *@date 2022年02月09日 
 * 
 * 
 * 
 */

public class Customer {
	private String name; 			//姓名
	private char gender; 			//性别
	private int age;				//年龄
	private String phone;			//电话号码
	private String email;			//电子邮箱
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGander() {
		return gender;
	}
	public void setGander(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmil() {
		return email;
	}
	public void setEmil(String email) {
		this.email = email;
	}
	public Customer() {
	
	}
	public Customer(String name, char gender, int age, String phone, String email) {

		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
	public String info(){
		return name + "\t" + gender + "\t" + age + "\t" + phone + "\t" + email;
	}
	
	
	
}
