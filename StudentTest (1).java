import java.util.*;

// 학생 클래스
class Student {
	private static Scanner scanner = new Scanner(System.in);

	private int number; // 학번 멤버 변수
	private String name; // 이름 멤버 변수
	private String major; // 학과 멤버 변수
	private String phone; // 휴대폰 번호 멤버 변수

	// 학번을 반환하는 메소드
	public int getNumber() {
		return this.number;
	}

	// 이름을 반환하는 메소드
	public String getName() {
		return this.name;
	}

	// 학과를 반환하는 메소드
	public String getMajor() {
		return this.major;
	}

	// 휴대폰 번호를 반환하는 메소드
	public String getPhoneNumber() {
		return this.phone;
	}

	// 기본 생성자
	public Student() {
		System.out.print("학번>> ");
		this.number = scanner.nextInt();
		System.out.print("이름>> ");
		this.name = scanner.next();
		scanner.nextLine();
		System.out.print("학과>> ");
		this.major = scanner.nextLine();
		System.out.print("휴대폰 번호>> ");
		this.phone = scanner.nextLine();
	}

	// 출력을 위한 toString()메소드 오버라이딩
	public String toString() {
		return "이름>> " + name + ", 학번>> " + number + ", 학과>> " + major + ", 휴대폰 번호>> " + phone;
	}
}

public class StudentTest {
	private static Scanner scanner; // 사용자의 입력 받기 위한 Scanner 객체
	private static ArrayList<Student> sList; // 학생 객체들을 저장할 배열리스트

	public static void main(String args[]) {
		scanner = new Scanner(System.in); // Scanner 객체 할당
		sList = new ArrayList<Student>(); // 배열리스트 객체 할당

		System.out.println("-------------------------------");
		System.out.println("학생 인적사항 관리 프로그램입니다");
		System.out.println("-------------------------------");

		while (true) { // 종료 선택할 때까지 계속 반복
			System.out.print("입력: 1, 찾기:2, 삭제:3, 전체보기:4, 종료:5 >> ");
			int sel = scanner.nextInt();

			switch (sel) {
			case 1:
				inputStudent(); // 학생 입력하는 메소드 호출
				break;
			case 2:
				searchStudent(); // 학생 찾는 메소드 호출
				break;
			case 3:
				deleteStudent(); // 학번으로 학생 삭제하는 메소드 호출
				break;
			case 4:
				printAllStudent(); // 전체 학생의 정보 보여주는 메소드 호출
				break;
			case 5:
				System.out.println("프로그램을 종료하겠습니다");
				System.exit(1);
			}
			System.out.println();
		}
	}

	// 학생 입력하는 메소드
	private static void inputStudent() {
		Iterator<Student> it = sList.iterator(); // 동일 학번 있는지 검사하기 위해 Iterator 생성
		Student student = new Student(); // 학생 정보 입력 및 생성

		while (it.hasNext()) { // 전체 학생을 돌며
			Student s = it.next();
			if (s.getNumber() == student.getNumber()) { // 학번이 같은 학생은 존재할 수 없다.
				System.out.println("학번이 같은 학생이 이미 존재합니다!");
				System.out.println("다시 입력해주세요!");
				return;
			}
		}
		sList.add(student); // 학번 같은 학생이 없으면 배열리스트에 추가해준다.
	}

	// 학생 찾는 메소드
	private static void searchStudent() {
		Iterator<Student> it = sList.iterator(); // 정보에 맞는 학생 찾기 위해 Iterator 생성
		boolean success = false; // 학생을 찾았는지 검사할 논리값

		System.out.print("학번으로 찾기: 1, 이름으로 찾기:2, 학과로 찾기:3, 휴대폰 번호로 찾기:4 >> ");
		int sel = scanner.nextInt();
		scanner.nextLine();
		switch (sel) { // 선택한 번호에 따른 정보로 찾기를 수행한다.
		case 1:
			System.out.print("학번-> ");
			int number = scanner.nextInt();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getNumber() == number) { // 학번 정보에 맞는 학생을 출력한다.
					success = true;
					System.out.println(s);
					break; // 학번은 모두 다르므로 한 명만 출력 후 나간다.
				}
			}
			break;
		case 2:
			System.out.print("이름-> ");
			String name = scanner.next();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getName().equals(name)) { // 이름 정보에 맞는 학생들을 출력한다.
					success = true;
					System.out.println(s);
				}
			}
			break;
		case 3:
			System.out.print("학과-> ");
			String major = scanner.nextLine();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getMajor().equals(major)) { // 학과 정보에 맞는 학생들을 출력한다.
					success = true;
					System.out.println(s);
				}
			}
			break;
		case 4:
			System.out.print("휴대폰 번호-> ");
			String phone = scanner.nextLine();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getPhoneNumber().equals(phone)) { // 휴대폰 번호 정보에 맞는 학생들을 출력한다.
					success = true;
					System.out.println(s);
				}
			}
			break;
		}

		if (!success) { // 정보에 맞는 학생이 한 명도 없으면 메시지를 출력한다.
			System.out.println("해당 정보의 학생이 존재하지 않습니다!");
		}
	}

	// 학번으로 학생 삭제하는 메소드
	private static void deleteStudent() {
		Iterator<Student> it = sList.iterator(); // 학번에 맞는 학생 찾기 위해 Iterator 생성

		System.out.print("학번-> ");
		int delNum = scanner.nextInt();
		while (it.hasNext()) {
			if (it.next().getNumber() == delNum) { // 학번이 동일하면 해당 학생 지운다.
				it.remove();
				break;
			}
		}
	}

	// 전체 학생의 정보 보여주는 메소드
	private static void printAllStudent() {
		Iterator<Student> it = sList.iterator(); // 전체 학생 출력하기 위해 Iterator 생성
		while (it.hasNext()) { // 전체 학생 모두 출력
			System.out.println(it.next());
		}
	}
}
