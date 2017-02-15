import java.util.*;

//Please implement a program that lists the nodes of a random binary tree by nodes at the same depth.
public class Q2 {
	
	// the sameDepth will contains List with same-depth nodes. 
	public void BFSHelper(TreeNode root, List<List<TreeNode>> sameDepth){
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<TreeNode> cur = new ArrayList<>();
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				cur.add(node);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			sameDepth.add(cur);
		}
		
		
	}
	public class TreeNode {
	     int val;
	     TreeNode right;
	     TreeNode left;
	     TreeNode(int val){
	    	 this.val=val;
	     }
	     
	 }
}
