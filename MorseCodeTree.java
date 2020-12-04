import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root = null;
	String letterSearched = "";

	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (code.length() == 1) {
			TreeNode<String> node = new TreeNode<String>(letter);

			if (code.equals(".")) {
				root.setLeftChild(node);
			} else if (code.equals("-")) {
				root.setRightChild(node);
			}
			return;
		}

		else if (code.length() > 1) {
			String newCode = code.substring(1);

			if (code.charAt(0) == '.') {
				addNode(root.getLeftChild(), newCode, letter);
			} else if (code.charAt(0) == '-') {
				addNode(root.getRightChild(), newCode, letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		String letter;
		letter = fetchNode(root, code);
		return letter;
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		if (code.length() == 1) {

			if (code.equals(".")) {
				letterSearched = root.getLeftChild().getData();
			} else if (code.equals("-")) {
				letterSearched = root.getRightChild().getData();
			}
		}

		else if (code.length() > 1) {

			String newCode = code.substring(1);

			if (code.charAt(0) == '.') {
				fetchNode(root.getLeftChild(), newCode);
			} else if (code.charAt(0) == '-') {
				fetchNode(root.getRightChild(), newCode);
			}
		}

		return letterSearched;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> arrayListTree = new ArrayList<String>();
		LNRoutputTraversal(root, arrayListTree);
		return arrayListTree;

	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if (root == null) {
			return;
		}

		else {
			LNRoutputTraversal(root.getLeftChild(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}

}