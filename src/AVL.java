class Treenode{
	
	int key;
	int height;
	private Treenode left;
    private Treenode right;
	
	public Treenode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		height=1;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
	
	private Treenode root ;

	public Tree(Treenode root) {
		this.root = root;
	}
	public Treenode insert(int key,Treenode root){
		
		root=avlUtil_insert(key,root);
		
		return root;
	}
	private Treenode avlUtil_insert(int key, Treenode root2) {
		  if(root2==null){
		      root2=getnode(key);
		        return root2;
		  }
		    if(key<root2.getKey()){
		    root2.setLeft(avlUtil_insert(key,root2.getLeft()));
		    }
		    else{
		    root2.setRight(avlUtil_insert(key,root2.getRight()));
		    }
		    root2.setHeight(Math.max(getheight(root2.getLeft()), getheight(root2.getRight()))+1);
		   int balance= getBalance(root2.getLeft(),root2.getRight());
	
      
		 if(balance>1){
			  if(key<root2.getLeft().getKey()){
				  return rightRotate(root2);
			  }
			  else{
				  root2.setLeft(leftRotate(root2.getLeft()));
				  return rightRotate(root2);
				  
			  }
			 
		 }
		 else if(balance<-1){
			 if(key>root2.getRight().getKey()){
				 return leftRotate(root2);
			 }
			 else{
				 root2.setRight(root2.getRight());
				 return rightRotate(root2);
				 
			 }
			 
		 }
		return root2;
	}
	
	private Treenode leftRotate(Treenode par) {
	
          Treenode ch= par.getRight();
          Treenode T1=par.getLeft();
          ch.setLeft(par);
          par.setRight(T1);
          
        par.setHeight(Math.max(getheight(par.getLeft()), getheight(par.getRight())));
  		ch.setHeight(Math.max(getheight(ch.getLeft()), getheight(ch.getRight())));
  		return ch;
		
	}
	private Treenode rightRotate(Treenode par) {
		Treenode ch= par.getLeft();
		Treenode T1=ch.getRight();
		
		ch.setRight(par);
		par.setLeft(T1);
		  
		
		par.setHeight(Math.max(getheight(par.getLeft()), getheight(par.getRight())));
		ch.setHeight(Math.max(getheight(ch.getLeft()), getheight(ch.getRight())));
		return ch;
		  
		
		
	}
	private int getBalance(Treenode left, Treenode right) {
		
		    int ht1=getheight(left);
		    int ht2=getheight(right);
		return 0;
	}
	private int getheight(Treenode left) {
		if(left==null)return 1;
		   return left.getHeight();
	}
	private Treenode getnode(int key){
		 Treenode temp = new Treenode(key);
		 return temp;
	}

	public void inorder(Treenode root3){
		
		    if(root3==null)return;
		    
		    inorder(root3.getLeft());
		    System.out.println(root3.getKey());
		    inorder(root3.getRight());
	}
	
	
}
public class AVL {

	
	public static void main(String args[]){
		Treenode root= new Treenode(5);
		Tree tr= new Tree(root);
		root=tr.insert(7,root);
		root=tr.insert(4,root);
		root=tr.insert(8, root);
		root=tr.insert(1, root);
		tr.inorder(root);
		
		
	}
}
