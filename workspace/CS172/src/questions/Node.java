package questions;

public class Node {

	private String key;

	private Node left;

	private Node right;

	public Node(String key) {
		this.key = key;
	}

	public Node(String key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
	
	public String getKey() {
		return key;
	}

	public boolean isLeaf() {
		if (left == null & right == null)
			return true;
		return false;
	}

	public int height() {
		if (isLeaf()) {
			return 0;
		} else {
			int leftHeight = left.height() + 1;
			int rightHeight = right.height() + 1;

			if (leftHeight > rightHeight)
				return leftHeight;
			else
				return rightHeight;
		}
	}

	public void learn(String correct, String question) {
		left = new Node(correct);
		right = new Node(key);
		key = question;
	}
	
	public String toString(String indent) {
		String currentNode = key + "\n";
		indent += "  ";

		if (isLeaf())
			return indent + currentNode;

		return indent + currentNode + left.toString(indent) + right.toString(indent);
	}
	
	@Override
	public String toString() {
		String currentNode = key + "\n";
		String indent = "";

		if (isLeaf())
			return currentNode;

		return currentNode + left.toString(indent) + right.toString(indent);

		// if (isLeaf())
		// return "  " + key + "\n";
		// else
		// return key + "\n  " + left.toString() + "  " + right.toString();
	}

}
