package First;
import First.TreeLinkNode;

public class W0116PopulatingNextRight {
	public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        
        TreeLinkNode curr = root;
        
        while (curr != null) {
        	TreeLinkNode saveCurrNode = curr;
        	while (saveCurrNode != null) {
        		if (saveCurrNode.left != null) {
        			saveCurrNode.left.next = saveCurrNode.right;
        			if (saveCurrNode.next != null) 
        				saveCurrNode.right.next = saveCurrNode.next.left;
        		}
        		saveCurrNode = saveCurrNode.next;
        	}
        	curr = curr.left;
        }
    }
	
	public static void main(String[] args) {
		TreeLinkNode t0 = new TreeLinkNode(0);
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		
		t0.left = t1;
		t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		W0116PopulatingNextRight testcase = new W0116PopulatingNextRight();
		testcase.connect(t0);
	}
}