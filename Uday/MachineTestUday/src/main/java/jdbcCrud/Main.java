package jdbcCrud;

import java.util.*;
public class Main extends UpdateRecord{
	void getChoices() {
		System.out.println("Enter Your Choice: \n 1:Insert Records\n 2:Display Records\n 3:Update Record \n 4:Delete Record");
		try (Scanner s = new Scanner(System.in)) {
			int ch=s.nextInt();
			switch (ch) {
			case 1:
				insertConnection();
				System.out.println("");
				getChoices();
				break;
			case 2:
				retrieveConnection();
				System.out.println("");
				getChoices();
				break;
			case 3:
				updateConnection();
				System.out.println("");
				getChoices();
				break;
			case 4:
				deleteConnection();
				System.out.println("");
				getChoices();
				break;
			

			default:
				System.out.println("Wrong Choice!");
				getChoices();
				break;
			}
		}
	}
	public static void main(String args[]) {
		Main m=new Main();
		m.getChoices();
	}
	

}
