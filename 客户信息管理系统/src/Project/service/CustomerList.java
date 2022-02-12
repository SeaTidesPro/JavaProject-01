package Project.service;

import Project.bean.Customer;

/*
 *@Description CustomerListΪCustomerListģ���ṩ����Ĺ���ģ�顣 
 *@author SeaTides Email:981637700@qq.com
 *@version
 *@date 2022��02��13�� 
 * 
 */

public class CustomerList {
	private Customer[] customers; // �����������
	private int total = 0; // ��¼���������

	/**
	 * ���ڳ�ʼ��Customer����Ĺ�����
	 * 
	 * @param totalCustomer��ָ������ĳ���
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	/**
	 * ��ָ���Ŀͻ���ӵ�������
	 * 
	 * @param customer
	 * @return true����ӳɹ� false�����ʧ��
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
	 * �޸�ָ���������Ŀͻ���Ϣ
	 * 
	 * @param index
	 * @param cust
	 * @return true����ӳɹ� false�����ʧ��
	 */

	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	/**
	 * ɾ��ָ��λ���ϵĿͻ�
	 * @param index
	 * @return true����ӳɹ� false�����ʧ��
	 */

	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for(int i = index; i < total - 1;i++) {
			customers[i] = customers[i + 1];
		}
		//�����Ԫ�ص���Ҫ�ÿ�
		customers[total - 1] = null;
		total--;
		return true;
	}

	/*
	 * ��ȡ�û���Ϣ
	 */
	public Customer[] getAllCustomer() {
		Customer[] custs = new Customer[total];
		for (int i = 0;i < total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * ��ȡָ�������ϵ��û�
	 * @param index
	 * @return �ҵ��򷵻أ�û�ҵ��򷵻�null
	 */
	public Customer getCustomer(int index) {
		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * ��ȡ�洢�Ŀͻ�������
	 * @return
	 */
	public int getTotal() {
		return total;
	}

}
