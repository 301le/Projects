public class TreeNode<T> {

	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;


	public TreeNode(T dataNode) {
		this.data = dataNode;
		leftChild = null;
		rightChild = null;
	}


	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.rightChild = node.rightChild;
		this.leftChild = node.leftChild;
	}


	public T getData() {
		return data;
	}

	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}


	public TreeNode<T> getRightChild() {
		return rightChild;
	}


	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}