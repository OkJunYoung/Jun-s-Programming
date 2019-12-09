import java.util.*;

// �л� Ŭ����
class Student {
	private static Scanner scanner = new Scanner(System.in);

	private int number; // �й� ��� ����
	private String name; // �̸� ��� ����
	private String major; // �а� ��� ����
	private String phone; // �޴��� ��ȣ ��� ����

	// �й��� ��ȯ�ϴ� �޼ҵ�
	public int getNumber() {
		return this.number;
	}

	// �̸��� ��ȯ�ϴ� �޼ҵ�
	public String getName() {
		return this.name;
	}

	// �а��� ��ȯ�ϴ� �޼ҵ�
	public String getMajor() {
		return this.major;
	}

	// �޴��� ��ȣ�� ��ȯ�ϴ� �޼ҵ�
	public String getPhoneNumber() {
		return this.phone;
	}

	// �⺻ ������
	public Student() {
		System.out.print("�й�>> ");
		this.number = scanner.nextInt();
		System.out.print("�̸�>> ");
		this.name = scanner.next();
		scanner.nextLine();
		System.out.print("�а�>> ");
		this.major = scanner.nextLine();
		System.out.print("�޴��� ��ȣ>> ");
		this.phone = scanner.nextLine();
	}

	// ����� ���� toString()�޼ҵ� �������̵�
	public String toString() {
		return "�̸�>> " + name + ", �й�>> " + number + ", �а�>> " + major + ", �޴��� ��ȣ>> " + phone;
	}
}

public class StudentTest {
	private static Scanner scanner; // ������� �Է� �ޱ� ���� Scanner ��ü
	private static ArrayList<Student> sList; // �л� ��ü���� ������ �迭����Ʈ

	public static void main(String args[]) {
		scanner = new Scanner(System.in); // Scanner ��ü �Ҵ�
		sList = new ArrayList<Student>(); // �迭����Ʈ ��ü �Ҵ�

		System.out.println("-------------------------------");
		System.out.println("�л� �������� ���� ���α׷��Դϴ�");
		System.out.println("-------------------------------");

		while (true) { // ���� ������ ������ ��� �ݺ�
			System.out.print("�Է�: 1, ã��:2, ����:3, ��ü����:4, ����:5 >> ");
			int sel = scanner.nextInt();

			switch (sel) {
			case 1:
				inputStudent(); // �л� �Է��ϴ� �޼ҵ� ȣ��
				break;
			case 2:
				searchStudent(); // �л� ã�� �޼ҵ� ȣ��
				break;
			case 3:
				deleteStudent(); // �й����� �л� �����ϴ� �޼ҵ� ȣ��
				break;
			case 4:
				printAllStudent(); // ��ü �л��� ���� �����ִ� �޼ҵ� ȣ��
				break;
			case 5:
				System.out.println("���α׷��� �����ϰڽ��ϴ�");
				System.exit(1);
			}
			System.out.println();
		}
	}

	// �л� �Է��ϴ� �޼ҵ�
	private static void inputStudent() {
		Iterator<Student> it = sList.iterator(); // ���� �й� �ִ��� �˻��ϱ� ���� Iterator ����
		Student student = new Student(); // �л� ���� �Է� �� ����

		while (it.hasNext()) { // ��ü �л��� ����
			Student s = it.next();
			if (s.getNumber() == student.getNumber()) { // �й��� ���� �л��� ������ �� ����.
				System.out.println("�й��� ���� �л��� �̹� �����մϴ�!");
				System.out.println("�ٽ� �Է����ּ���!");
				return;
			}
		}
		sList.add(student); // �й� ���� �л��� ������ �迭����Ʈ�� �߰����ش�.
	}

	// �л� ã�� �޼ҵ�
	private static void searchStudent() {
		Iterator<Student> it = sList.iterator(); // ������ �´� �л� ã�� ���� Iterator ����
		boolean success = false; // �л��� ã�Ҵ��� �˻��� ����

		System.out.print("�й����� ã��: 1, �̸����� ã��:2, �а��� ã��:3, �޴��� ��ȣ�� ã��:4 >> ");
		int sel = scanner.nextInt();
		scanner.nextLine();
		switch (sel) { // ������ ��ȣ�� ���� ������ ã�⸦ �����Ѵ�.
		case 1:
			System.out.print("�й�-> ");
			int number = scanner.nextInt();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getNumber() == number) { // �й� ������ �´� �л��� ����Ѵ�.
					success = true;
					System.out.println(s);
					break; // �й��� ��� �ٸ��Ƿ� �� �� ��� �� ������.
				}
			}
			break;
		case 2:
			System.out.print("�̸�-> ");
			String name = scanner.next();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getName().equals(name)) { // �̸� ������ �´� �л����� ����Ѵ�.
					success = true;
					System.out.println(s);
				}
			}
			break;
		case 3:
			System.out.print("�а�-> ");
			String major = scanner.nextLine();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getMajor().equals(major)) { // �а� ������ �´� �л����� ����Ѵ�.
					success = true;
					System.out.println(s);
				}
			}
			break;
		case 4:
			System.out.print("�޴��� ��ȣ-> ");
			String phone = scanner.nextLine();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getPhoneNumber().equals(phone)) { // �޴��� ��ȣ ������ �´� �л����� ����Ѵ�.
					success = true;
					System.out.println(s);
				}
			}
			break;
		}

		if (!success) { // ������ �´� �л��� �� �� ������ �޽����� ����Ѵ�.
			System.out.println("�ش� ������ �л��� �������� �ʽ��ϴ�!");
		}
	}

	// �й����� �л� �����ϴ� �޼ҵ�
	private static void deleteStudent() {
		Iterator<Student> it = sList.iterator(); // �й��� �´� �л� ã�� ���� Iterator ����

		System.out.print("�й�-> ");
		int delNum = scanner.nextInt();
		while (it.hasNext()) {
			if (it.next().getNumber() == delNum) { // �й��� �����ϸ� �ش� �л� �����.
				it.remove();
				break;
			}
		}
	}

	// ��ü �л��� ���� �����ִ� �޼ҵ�
	private static void printAllStudent() {
		Iterator<Student> it = sList.iterator(); // ��ü �л� ����ϱ� ���� Iterator ����
		while (it.hasNext()) { // ��ü �л� ��� ���
			System.out.println(it.next());
		}
	}
}
