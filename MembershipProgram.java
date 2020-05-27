package MembershipProgram_200427;

import java.util.Scanner;

public class MembershipProgram implements Menu, Signup, Memberlist, Delete,
		Modify {

	static Scanner sc = new Scanner(System.in);

	static int i, j;

	static String name, age, email, call;

	static String md[][] = new String[10][4];

	static MembershipProgram mp = new MembershipProgram();

	@Override
	public void modify() {

		System.out.println("수정하실 회원님의 이름을 입력하여 주십시오.");
		name = sc.next();
		for (i = 0; i < md.length; i++) {
			if (md[i][0].equals(name)) {
				System.out.println("수정하실 회원정보를 선택하여 주십시오.");
				System.out.print("1.이름" + "\t\t" + "2.나이" + "\t\t  "
						+ "3.E-mail" + "\t" + "4.전화번호" + "\n");
				int menu2 = sc.nextInt();
				switch (menu2) {
				case 1:
					System.out.println("수정하실 이름을 입력하여 주십시오.");
					md[i][0] = sc.next();
					break;
				case 2:
					System.out.println("수정하실 나이를 입력하여 주십시오.");
					md[i][1] = sc.next();
					break;
				case 3:
					System.out.println("수정하실 E-mail을 입력하여 주십시오.");
					md[i][2] = sc.next();
					break;
				case 4:
					System.out.println("수정하실 전화번호를 입력하여 주십시오.");
					md[i][3] = sc.next();
					break;
				}
				menu();
			}
		}
	}

	@Override
	public void delete() {
		System.out.println("삭제하실 회원님의 이름을 입력하여 주십시오.");
		name = sc.next();
		for (i = 0; i < md.length; i++) {
			for (j = 0; j < 4; j++) {
				if (md[i][j].equals(name)) {
					md[i][j] = null;
					System.out.println("정상적으로 삭제되었습니다.");
				} else
					System.out.println("등록되지 않은 회원입니다.");
			}
			menu();
		}
	}

	@Override
	public void list() {

		System.out.println("확인을 위해서 회원님의 이름을 입력하여 주십시오.");
		name = sc.next();
		for (i = 0; i < md.length; i++) {
			if (md[i][0].equals(name)) {
				System.out.print("이름" + "\t\t" + "나이" + "\t\t  " + "E-mail"
						+ "\t" + "전화번호" + "\n");
				System.out
						.println("=========================================================");

				System.out.print(md[i][0] + "\t\t" + md[i][1] + "\t" + md[i][2]
						+ "\t" + md[i][3] + "\n");
			} else
				System.out.println("등록된 회원이 아니면 조회가 불가능 합니다.");
			menu();
		}
	}

	@Override
	public void signup() {

		for (i = 0; i <= md.length; i++) {
			md[i][0] = null;
			if (md[i][0] == null) {
				System.out.println("이름을 입력하여 주십시오.");
				name = sc.next();
				md[i][0] = name;
				System.out.println("나이를 입력하여 주십시오.");
				age = sc.next();
				md[i][1] = age;
				System.out.println("이메일을 입력하여 주십시오.");
				email = sc.next();
				md[i][2] = email;
				System.out.println("전화번호를 입력하여 주십시오.");
				call = sc.next();
				md[i][3] = call;
				System.out
						.println("=========================================================");
				System.out.println("회원가입이 완료되었습니다.");
				menu();
			} else
				System.out.println("죄송합니다. 회원수가 가득 찼습니다.");
		}
	}

	@Override
	public void menu() {

		System.out
				.println("===========================MENU==========================");
		System.out
				.println("1.회원가입     2.회원목록     3.회원삭제     4.회원정보 수정     5.프로그램 종료");
		System.out
				.println("=========================================================");

		int select = sc.nextInt();

		switch (select) {

		case 1:
			mp.signup();
			break;
		case 2:
			mp.list();
			break;
		case 3:
			mp.delete();
		case 4:
			mp.modify();
		case 5:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		mp.menu();
	}
}