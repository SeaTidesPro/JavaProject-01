package Project.service;

import Project.bean.Customer;

/*
 *@Description CustomerList为CustomerList模块提供对象的管理模块。 
 *@author SeaTides Email:981637700@qq.com
 *@version
 *@date 2022年02月13日 
 * 
 */

public class CustomerList {
	private Customer[] customers; // 保存对象数组
	private int total = 0; // 记录对象的数量

	/**
	 * 用于初始化Customer数组的构造器
	 * 
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	/**
	 * 将指定的客户添加到数组中
	 * 
	 * @param customer
	 * @return true：添加成功 false：添加失败
	 */

	public boolean addCustomer(Customer customer) {
		if (total >= customers.length) {
			return false;
		}
		customers[total] = customer;
		total = total + 1;
		return true;
	}

	/**
	 * 修改指定索引处的客户信息
	 * 
	 * @param index
	 * @param cust
	 * @return true：添加成功 false：添加失败
	 */

	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	/**
	 * 删除指定位置上的客户
	 * @param index
	 * @return true：添加成功 false：添加失败
	 */

	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for(int i = index; i < total - 1;i++) {
			customers[i] = customers[i + 1];
		}
		//最后有元素的需要置空
		customers[total - 1] = null;
		total--;
		return true;
	}

	/*
	 * 获取用户信息
	 */
	public Customer[] getAllCustomer() {
		Customer[] custs = new Customer[total];
		for (int i = 0;i < total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 获取指定索引上的用户
	 * @param index
	 * @return 找到则返回，没找到则返回null
	 */
	public Customer getCustomer(int index) {
		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * 获取存储的客户的数量
	 * @return
	 */
	public int getTotal() {
		return total;
	}

}
