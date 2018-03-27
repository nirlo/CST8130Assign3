import java.util.*;

public class BlockChain {
	private String courseName = "NotEntered";
	private LinkedList<Block> blockChain;
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
		blockChain = new LinkedList<>();
	}
	
	public String printBlockChain() {
		StringBuilder sb = new StringBuilder("For Course: " + courseName);
		for (Block b: blockChain) {
			sb.append("["+b.toString()+"]");
		}
		return sb.toString();
	}
	
	public boolean verifyChain() {
		
		boolean success = false;
		
		for(Block b: blockChain) {
			try {
			if(blockChain.get(blockChain.indexOf(b) +1) == null) {
				break;
			}
			if(blockChain.get(blockChain.indexOf(b) +1).equals(b)) {
				success = true;
			} else {
				return false;
			}
			}catch(IndexOutOfBoundsException e) {
				success = true;
			}
		}
		
		return success;
	}
	
	public void addBlock(Scanner keyboard) {
		Block newOne = new Block();
		try {
		if(newOne.addInfoToBlock(keyboard, blockChain.getLast().getCurrentHash())) {
			blockChain.push(newOne);
		}
		}catch(NoSuchElementException e) {
			newOne.addInfoToBlock(keyboard, 0.0f);
			blockChain.push(newOne);
		}
	}
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			blockChain.push(newOne);			
		}
		
	}
	
	public void removeBadBlocks() {
		
		for(Block b: blockChain) {
			if(blockChain.get(blockChain.indexOf(b) -1) == null) {
				continue;
			}
			if(!b.equals(blockChain.get(blockChain.indexOf(b)-1))) {
				blockChain.get(blockChain.indexOf(b) +1).updatePreviousHash(blockChain.get(blockChain.indexOf(b)-1).getCurrentHash());
				blockChain.remove(b);
			} 
		}
		
	}
	
	public String getName() {
		return courseName;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("For course " +courseName + "\n[\n");
		for(Block b: blockChain) {
			sb.append(b.toString()+ ", \n");
		}
		sb.append("]\n");
		return sb.toString();
	}
		
}
