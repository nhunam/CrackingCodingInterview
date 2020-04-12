package SystemDesign9.SocialNetwork92;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
	public Queue<PathNode> toVisit = new LinkedList<>();
	public HashMap<Integer, PathNode> visited = new HashMap<>();
	
	public BFSData(Person root) {
		PathNode srcPath = new PathNode(root, null);
		toVisit.add(srcPath);
		visited.put(root.getPersonId(), srcPath);
	}
	
	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}
