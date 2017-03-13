import java.util.HashMap;

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
 private HashMap<Integer,Integer>hm =new HashMap<Integer, Integer>();
public Tree(Treenode root) {
	this.root = root;
}
    public void diagonal_main(){
    	
    	diagonal_util(root,0,hm);
    	System.out.println(hm.entrySet());
    }
	private void diagonal_util(Treenode root,int dis, HashMap<Integer, Integer> hm) {
		
		     if(root == null){return;}
		     int val=hm.get(dis)!=null?hm.get(dis) :0;
		       hm.put(dis,val+root.getKey());
		       diagonal_util(root.getLeft(),dis-1,hm);
                diagonal_util(root.getRight(),dis,hm);	     
		
	}
	
}



public class DiagonalTree {

	
	public static void main(String args[]){
		
		Treenode root = new Treenode(8);
		root.setLeft(new Treenode(3));
		root.getLeft().setLeft(new Treenode(1));
		root.getLeft().setRight(new Treenode(6));
		root.getLeft().getRight().setLeft(new Treenode(4));
		root.getLeft().getRight().setRight(new Treenode(7));
		root.setRight(new Treenode(10));
		root.getRight().setRight(new Treenode(14));
		root.getRight().getRight().setLeft(new Treenode(13));
		
        Tree tree= new Tree(root);
        tree.diagonal_main();
		
	}
}
