import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Treenode{
	private int key;
	private Treenode  left;
	private Treenode right;
	public Treenode(int key) {
		this.key = key;
		this.left=null;
		this.right=null;
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
  
class Treeutil{
	private ArrayList<Integer> infix;
	private ArrayList<Integer>prefix;
	private static int pre=0;
	public Treeutil(ArrayList<Integer> infix, ArrayList<Integer> prefix) {
		this.infix = infix;
		this.prefix = prefix;
	}
	
	public Treenode  Calculate(){
		  Treenode root = ConvesionUtil(infix,prefix,0,infix.size()-1);
		  return root;
	}
	private Treenode ConvesionUtil(List<Integer> infix2, List<Integer> prefix2,int st,int en) {
		  // if(infix2==null)return null;
		if(st>en)return null;
		
		   Treenode lf=null,rf=null;
		  
		  Treenode  root=new Treenode(prefix2.get(pre++));
		  if(st==en)return root;
		    int index= infix2.indexOf(root.getKey());
		            lf= ConvesionUtil(infix2,prefix2,st,index-1);
		            rf= ConvesionUtil(infix2,prefix2,index+1,en);
					root.setLeft(lf);
					root.setRight(rf);
		return root;
		
	}
	 public void trav(Treenode root){
		 
		 if(root== null) return;
		     trav(root.getLeft());
		       System.out.println(root.getKey());
		         trav(root.getRight());
		 
	 }    
	
}




public class InfixUse {

	public static void main(String args[]){
          
		   ArrayList<Integer> infix = new ArrayList<Integer>();
		   ArrayList<Integer>prefix =new ArrayList<Integer>();;
		   Scanner in = new Scanner(System.in);
		      System.out.println("Infix array");
		      for(int i=0;i<6;i++){
		    	  infix.add(in.nextInt());
		      }
		      System.out.println("prefix array");
		      for(int i=0;i<6;i++){
		    	  prefix.add(in.nextInt());
		      }
		      Treeutil tmp = new Treeutil(infix,prefix);
		      Treenode root = tmp.Calculate();
		       tmp.trav(root);
	}
	
}
 