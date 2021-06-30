package s30505_0609;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		
		list.add("석진");
		list.add("윤기");
		list.add("남준");
		list.add("정국");
		
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+"\t");
		System.out.println("\n");
		
		String str = list.remove(1);
		System.out.println("deleted data: "+str);
		System.out.println("\n");
		
		for(String i : list)
			System.out.print(i+"\t");
		System.out.println("\n");
	}

}
