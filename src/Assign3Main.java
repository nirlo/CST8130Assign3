import java.util.Scanner;

public class Assign3Main {

	public static void main(String[] args) {
		College c = new College("Algonquin");
		
		Scanner kb = new Scanner(System.in);
		boolean cont = true;

		while(cont) {
			System.out.println("Enter 1 to display the college courses:\n"
					+"2 to add a new course: \n"
					+"3 to add a new Block:\n"
					+"4 to verify a chain:\n"
					+"5 to fix a chian:\n" 
					+"6 to quit");
			
			String choice = kb.next();
			
			switch(choice) {
			case "1":
				System.out.println(c.toString());
				break;
			case "2":
				System.out.println("Enter name of course to add: ");
				c.newCourse(kb.next());
				break;
			case "3":
				c.newBlock(kb);
				break;
			case "4":
				c.verifyChains();
				break;
			case "5":
				c.fixChain(kb);
				break;
			case "6":
				cont = false;
				break;
			}
		}
	}
}
