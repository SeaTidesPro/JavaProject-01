package Project.ui;

import Project.bean.Customer;
import Project.service.CustomerList;
import Project.util.CMUtility;

/**
 * CustomerViewΪ��ģ�飬�����û�����Ľ������������
 * 
 * @author SeaTides
 * @version
 * @date 2022��02��13��
 */

public class CustomerView {
	private CustomerList custList = new CustomerList(10);

	public CustomerView() {
		Customer customer = new Customer("����", '��', 23, "13012342134", "ken@abc.com");
		custList.addCustomer(customer);

	}

	/**
	 * ����
	 */
	public void enterMainMenu() {

		boolean isFlag = true;
		while (isFlag) {
			System.out.println("------------�ͻ���Ϣ�������-------------");
			System.out.println("		1.����û�");
			System.out.println("		2.�޸��û�");
			System.out.println("		3.ɾ���û�");
			System.out.println("		4.�û��б�");
			System.out.println("		5.�˳�ϵͳ");
			System.out.println();
			System.out.println("������(1-5):");

			char menu = CMUtility.readMenuSelection();
			switch (menu) {

			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				System.out.print("ȷ���Ƿ��˳�(Y/N)");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
				break;
			}

		}

	}

	/**
	 * ��ӿͻ�
	 */
	private void addNewCustomer() {
		System.out.println("---------------------��ӿͻ�---------------------");
		System.out.print("������");
		String name = CMUtility.readString(5);
		System.out.print("�Ա�");
		char gender = CMUtility.readChar();
		System.out.print("���䣺");
		int age = CMUtility.readInt();
		System.out.print("�绰��");
		String phone = CMUtility.readString(15);
		System.out.print("���䣺");
		String email = CMUtility.readString(20);

		// ��װΪһ������
		Customer customer = new Customer(name, gender, age, phone, email);
		// ���˶�����ӵ�CustomerList���������
		boolean flag = custList.addCustomer(customer);
		if (flag) {
			System.out.println("---------------------������---------------------");

		} else {
			System.out.println("�����Ѵ����ޣ����ʧ�ܣ�");
		}
	}

	/**
	 * �޸Ŀͻ��Ĳ���
	 */
	private void modifyCustomer() {
		System.out.println("---------------------�޸Ŀͻ�---------------------");
		Customer customer;
		int index;
		for (;;) {
			System.out.print("��ѡ����޸Ŀͻ����(-1�˳�)��");
			index = CMUtility.readInt();
			if (index == -1) {
				//����ʹ��break
				return;
			}
			// �����û�������������index Ĭ�ϴ�1��ʼ��
			customer = custList.getCustomer(index - 1);
			if (customer == null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			} else {
				break;
			}
		}
		// �޸��û�����Ϣ
		System.out.print("����(" + customer.getName() + "):");
		// ����û��������������򷵻��û��������Ϣ������û�û�����룬ֱ�ӻس����򷵻�customer.getName()
		String name = CMUtility.readString(5, customer.getName());

		System.out.print("�Ա�(" + customer.getGander() + "):");
		char gender = CMUtility.readChar(customer.getGander());

		System.out.print("����(" + customer.getAge() + "):");
		int age = CMUtility.readInt(customer.getAge());

		System.out.print("�绰(" + customer.getPhone() + "):");
		String phone = CMUtility.readString(13, customer.getPhone());

		System.out.print("����(" + customer.getEmil() + "):");
		String email = CMUtility.readString(15, customer.getEmil());
		// ��ȡ�û�����������Ժ󣬵õ������µ�Customer����
		customer = new Customer(name, gender, age, phone, email);
		// �����û�������������index Ĭ�ϴ�1��ʼ��
		boolean flag = custList.replaceCustomer(index - 1, customer);
		if (flag) {
			System.out.println("---------------------�޸����---------------------");
		} else {
			System.out.println("---------------------�޸�ʧ��---------------------");
		}

	}

	/**
	 * ɾ���ͻ��Ĳ���
	 */
	private void deleteCustomer() {
		System.out.println("---------------------ɾ���ͻ�---------------------");
		Customer customer;
		int index;
		for (;;) {

			System.out.print("��ѡ���ɾ���ͻ����(-1�˳�)��");
			// �����ͨ�û���������index�� 1��ʼ
			index = CMUtility.readInt();
			if (index == -1) {
				return;
			}

			customer = custList.getCustomer(index - 1);
			if (customer == null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			} else {
				break;
			}
		}

		// һ���ҵ���Ӧ������λ�õ�customer�Ժ����û������Ƿ�ȷ��ɾ��
		System.out.print("ȷ���Ƿ�ɾ��(Y/N)��");
		char deleteOrNot = CMUtility.readConfirmSelection();
		if (deleteOrNot == 'Y') {
			boolean flag = custList.deleteCustomer(index - 1);
			if (flag) {
				System.out.println("---------------------ɾ�����---------------------");
			} else {
				System.out.println("---------------------ɾ��ʧ��---------------------");
			}
		} else {
			return;
		}
	}

	/**
	 * ��ʾ�ͻ��Ĳ���
	 */
	private void listAllCustomer() {
		System.out.println("---------------------------�ͻ��б�---------------------------");
// ��ȡ���еĿͻ�
		Customer[] customers = custList.getAllCustomer();
		if (customers.length == 0) {
			System.out.println("û���κοͻ���¼��");

		} else {
			System.out.println("���\t����\t�Ա�\t����\t�绰\t\t����");
			for (int i = 0; i < customers.length; i++) {
				Customer cust = customers[i];
				System.out.println((i + 1) + "\t" + cust.info());

			}
		}
		System.out.println("-------------------------�ͻ��б����-------------------------");

	}

	/**
	 * 
	 * @param args ���
	 */
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}
