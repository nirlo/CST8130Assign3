import java.util.ArrayList;

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

}
