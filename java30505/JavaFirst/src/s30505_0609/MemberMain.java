package s30505_0609;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		MemberDAO member = new MemberDAO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴를 선택하세요: 1. 멤버 추가 2. 멤버 수정 3. 멤버 삭제 4. 멤버 조회(id) 5. 멤버전체조회 6. 멤버전체조회withList 7. 종료");
		int menu = sc.nextInt();
		
		switch (menu) {
			case 1: insertMember(sc); break;
			case 2: updateMember(sc); break;
			case 3: deleteMember(sc); break;
			case 4: selectMember(sc); break;
			case 5: selectAll(); break;
			case 6: selectAllList(); break;
			case 7: System.exit(0); break;
			default: System.out.println("메뉴 선택 에러"); break;
		}

	}

	private static void selectAllList() {
		// System.out.println("전체 조회");		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.selectAllList();
		for(MemberVO vo : list)
			System.out.println(vo.toString());
		
	}

	private static void deleteMember(Scanner sc) {
		System.out.println("삭제할 아이디 입력");
		int id = sc.nextInt();
		
		MemberDAO dao = new MemberDAO();
		
		dao.deleteMember(id);
		
	}

	private static void selectAll() {
		System.out.println("전체 조회");		
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
		System.out.println("수정할 정보입력");
		System.out.println("id 입력: ");
		int id = sc.nextInt();
		System.out.println("name 입력: ");
		String name = sc.next();
		System.out.println("pw 입력: ");
		String pw = sc.next();
		System.out.println("email 입력: ");
		String email = sc.next();
		System.out.println("join date 입력: ");
		String joinDate = sc.next();
		
		MemberVO vo = new MemberVO(id, pw, name, email, joinDate);
		dao.insertMember(vo);
		
	}

}
