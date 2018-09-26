package First;

public class W0117PopulatingNextRightII {
	public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        
        TreeLinkNode headOfEachLine = new TreeLinkNode(0);
        TreeLinkNode preHead = headOfEachLine;
        
        while (root != null) {
        	if (root.left != null) {
        		preHead.next = root.left;
        		preHead = preHead.next;
        	}
        	
        	if (root.right != null) {
        		preHead.next = root.right;
        		preHead = preHead.next;
        	}
        	
        	root = root.next;
        	if (root == null) {
        		preHead = headOfEachLine;
        		root = headOfEachLine.next;
        		headOfEachLine.next = null;
        	}
        }
    }
}