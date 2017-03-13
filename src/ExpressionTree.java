class Treenode{
	private String key;
	private Treenode left;
	private Treenode right;
	public Treenode(String key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
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
class TreeCal{
	private Treenode root;

	public TreeCal(Treenode root) {
		this.root = root;
	}
	public void cal(){
		
		  System.out.println(Cal_util(root));
	}
	private int  Cal_util(Treenode root){
		
		if(root.getLeft()== null && root.getRight()==null)return Integer.parseInt(root.getKey());
		    int left_val= Cal_util(root.getLeft());
		    int right_val=Cal_util(root.getRight());
		       switch(root.getKey()){
		          case "+":{return left_val+right_val;}
		          case "*":{return left_val*right_val;}
		          case "-":{return left_val-right_val;}
		          case "/":{return left_val/right_val;}
		       }
		       
		      return -1; 
		   
	}
	
}

public class ExpressionTree {

	
	public static void main(String args[]){
	  Treenode root = new Treenode("+");	
	      root.setLeft(new Treenode("*"));
	      root.getLeft().setLeft(new Treenode("5"));
	      root.getLeft().setRight(new Treenode("4"));
	      root.setRight(new Treenode("-"));
	      root.getRight().setLeft(new Treenode("100"));
	      root.getRight().setRight(new Treenode("20"));
	      
     		TreeCal trp= new TreeCal(root);
     		trp.cal();
	}
	
	
	
}
