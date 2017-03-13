class Treenode{
	
	int key;
	private Treenode left;
    private Treenode right;
	
	public Treenode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Treenode getLeft() {
		return left;
	}

	public void setLeft(Treenode left) {
		this.left = left;
	}

	public Treenode getRight() {
		return right;
	}

	public void setRight(Treenode right) {
		this.right = right;
	}
	
}

class Tree{
	
	private Treenode root;

	public Tree(Treenode root) {
		this.root = root;
	}
	public Treenode  flip(){
		
		Treenode tr=fliputil(root);
		return tr;
	}
	private Treenode fliputil(Treenode root2) {
		
		if(root2== null)return root2;
		
		if(root2.getLeft()==null && root2.getRight()==null)return root2;
		
		Treenode temp= fliputil(root2.getLeft());
		
		root2.getLeft().setLeft(root2.getRight());
		root2.getLeft().setRight(root2);
		root2.setLeft(null);
		root2.setRight(null);
		 
		return temp;
		
		
	}
	 public void trav(Treenode root){
		 
		 if(root== null) return;
		     trav(root.getLeft());
		       System.out.println(root.getKey());
		         trav(root.getRight());
		 
	 } 
}

public class FlipTree {

	public static void main (String argss[]){
		
		Treenode root = new Treenode(1);
		root.setLeft(new Treenode(2));
		root.getLeft().setLeft(new Treenode(4));
		root.getLeft().setRight(new Treenode(5));
		root.setRight(new Treenode(3));
		root.getRight().setLeft(new Treenode(6));
		root.getRight().setRight(new Treenode(7));
		Tree trp = new Tree(root);
		Treenode root1= trp.flip();
		 trp.trav(root1);
		
	}
}
