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
class TreeCompare{
	
	private Treenode root1;
	private Treenode root2;
	public TreeCompare(Treenode root1, Treenode root2) {
		this.root1 = root1;
		this.root2 = root2;
	}
	
	public void comp(){
		
		   System.out.println(compareTrees(root1,root2));
	}

	private boolean compareTrees(Treenode root12, Treenode root22) {
		
		if(root12==null && root22==null) return true;
		if(root12== null || root22==null) return false;
		
		return ((root12.getKey()== root22.getKey()?true:false) &&(compareTrees(root12.getLeft(), root22.getRight()) &&
				    compareTrees(root12.getRight(), root22.getLeft())));
	}
	
	
	
	
}
public class Mirror {

	   public static void main(String args[]){
		   Treenode root1= new Treenode(1);
		   root1.setLeft(new Treenode(3));
		   root1.setRight(new Treenode(2));
		   root1.getRight().setLeft(new Treenode(5));
		   root1.getRight().setRight(new Treenode(4));
		   
		   Treenode root2= new Treenode(1);
		   root2.setLeft(new Treenode(2));
		   root2.setRight(new Treenode(3));
		   root2.getLeft().setLeft(new Treenode(4));
		   root2.getLeft().setRight(new Treenode(5));
		   
		   TreeCompare tmp = new TreeCompare(root1,root2);
		   tmp.comp();
	   }
}
