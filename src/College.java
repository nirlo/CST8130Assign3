import java.util.ArrayList;
import java.util.Scanner;

public class College {
	private ArrayList<BlockChain> blockChain;
	private String collegeName;
	
	public College(String name) {
		collegeName = name;
		blockChain = new ArrayList<>();
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder("For College: "+collegeName+"\n");
		for(BlockChain bc: blockChain) {
			string.append(bc.toString());
		}
		return string.toString();
	}
	
	public void newCourse(String courseName) {
		BlockChain course = new BlockChain(courseName);
		blockChain.add(course);
	}
	
	public void newBlock(Scanner kb) {
		System.out.println("Enter which course to add: ");
		for(int i = 0; i < blockChain.size(); i++) {
			System.out.println(i + " " + blockChain.get(i).getName());
		}
		String choice = kb.next();
		boolean success = false;
		while(!success) {
			try {
				BlockChain bc = blockChain.get(Integer.parseInt(choice));
				System.out.println("Add good block or bad? (g for good, anything else for bad): ");
				if(kb.next().equals("g")) {
					bc.addBlock(kb);
				} else {
					bc.addBadBlock(kb);
				}
				success = true;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("That course doesn't exist, try one that does");  //I like this, simply ensures user compliance
			}
		}
	}
	
	public void verifyChains() {
		for(BlockChain bc: blockChain) {
			if(bc.verifyChain())
				System.out.println("Chain for " + bc.getName()+ "is Verified");
			else
				System.out.println("Chain for " + bc.getName()+ "is not Verified");
		}
	}
	/*
	 * I have to make a few changes in here at the moment, some difficulty in
	 * actually choosing the correct one to fix.
	 * 
	 */
	public void fixChain(Scanner kb) {
		System.out.println("Enter which course to fix: ");
		for(int i = 0; i < blockChain.size(); i++) {
			System.out.println(i + blockChain.get(i).getName());
		}
		try {
			blockChain.get(Integer.parseInt(kb.next())).removeBadBlocks();;
		}catch(IndexOutOfBoundsException|NumberFormatException e) {
			System.out.println("Sorry, you chose wrong. Back to main menu");
		}
	}

}
