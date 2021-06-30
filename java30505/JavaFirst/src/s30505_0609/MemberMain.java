package s30505_0609;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		MemberDAO member = new MemberDAO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�޴��� �����ϼ���: 1. ��� �߰� 2. ��� ���� 3. ��� ���� 4. ��� ��ȸ(id) 5. �����ü��ȸ 6. �����ü��ȸwithList 7. ����");
		int menu = sc.nextInt();
		
		switch (menu) {
			case 1: insertMember(sc); break;
			case 2: updateMember(sc); break;
			case 3: deleteMember(sc); break;
			case 4: selectMember(sc); break;
			case 5: selectAll(); break;
			case 6: selectAllList(); break;
			case 7: System.exit(0); break;
			default: System.out.println("�޴� ���� ����"); break;
		}

	}

	private static void selectAllList() {
		// System.out.println("��ü ��ȸ");		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.selectAllList();
		for(MemberVO vo : list)
			System.out.println(vo.toString());
		
	}

	private static void deleteMember(Scanner sc) {
		System.out.println("������ ���̵� �Է�");
		int id = sc.nextInt();
		
		MemberDAO dao = new MemberDAO();
		
		dao.deleteMember(id);
		
	}

	private static void selectAll() {
		System.out.println("��ü ��ȸ");		
		MemberDAO dao = new MemberDAO();
		
		dao.selectAll();
		
	}

	private static void selectMember(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void updateMember(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void insertMember(Scanner sc) {
		MemberDAO dao = new MemberDAO();
		System.out.println("������ �����Է�");
		System.out.println("id �Է�: ");
		int id = sc.nextInt();
		System.out.println("name �Է�: ");
		String name = sc.next();
		System.out.println("pw �Է�: ");
		String pw = sc.next();
		System.out.println("email �Է�: ");
		String email = sc.next();
		System.out.println("join date �Է�: ");
		String joinDate = sc.next();
		
		MemberVO vo = new MemberVO(id, pw, name, email, joinDate);
		dao.insertMember(vo);
		
	}

}
