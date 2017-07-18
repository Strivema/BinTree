package Ray.Tree;

import java.util.Scanner;

/**
 * 
 * @author Marie
 *
 */

public class Tree {
	static final int MAXLEN =50;
	static Scanner input =new Scanner(System.in);
	
	
	
	//-----³õÊ¼»¯
	public TreeType init(){
		TreeType node;
		if((node = new TreeType())!=null){
			System.out.println("input a root data:");
			node.data = input.next();
			node.left = null;
			node.right =null;
			if(node!=null){
				return node;
			}else
				return null;
		}
		return null;
		
	}
	public void AddTreeNode(TreeType treeNode){
		TreeType pnode,parent;
		String data;
		int men;
		if((pnode=new TreeType())!=null){
			System.out.println("input a node data:");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right =null;
			
			System.out.println("input the node's parent node");
			data = input.next();
			parent = TreeFindNode(treeNode,data);
			
			if(parent==null){
				System.out.println("not found parent node");
				pnode = null;
				return ;
			}
			System.out.println("1.add the node's left node");
			System.out.println("2.add the node's right node");
			
			do {
				men = input.nextInt();
				if(men==1||men==2){
					if(parent==null){
						System.out.println("not exist parent'node setting");
					}else{
						switch(men){
						case 1:
							if(parent.left!=null){
								System.out.println("left's node not empty");
							}else
								parent.left =pnode;
							break;
						case 2:
							if(parent.right!=null){
								System.out.println("right's node not empty");
							}else{
								parent.right = pnode;
							}
							break;
							default:
								System.out.println("not parameter");
						}
					}
				}
			} while (men!=1&&men!=2);
		}
	}
	private TreeType TreeFindNode(TreeType treeNode, String data) {
		// TODO Auto-generated method stub
		TreeType ptr;
		if(treeNode==null){
			return null;
		}else{
			if(treeNode.data.equals(data)){
				return treeNode;
			}else{
				if((ptr=TreeFindNode(treeNode.left, data))!=null){
					return ptr;
				}else if((ptr=TreeFindNode(treeNode.right,data))!=null){
					return ptr;
				}else
					return null;
			}
		}
	}
	public TreeType TreeLeftNode(TreeType treeNode){
		if(treeNode!=null){
			return treeNode.left;
		}else{
			return null;
		}
	}
	public TreeType TreeRightNode(TreeType treeNode){
		if(treeNode!=null){
			return treeNode.right;
		}else
			return null;
	}
	public int isEmpty(TreeType treeNode){
		if(treeNode!=null)
			return 0;
		else
			return 1;
	}
	public int TreeDeepth(TreeType treeNode){
		int deleft,deright;
		if(treeNode==null){
			return 0;
		}else{
			deleft = TreeDeepth(treeNode.left);
			deright = TreeDeepth(treeNode.right);
			if(deleft>deright){
				return deleft+1;
			}else
				return deright+1;
		}
	}
	public void clearTree(TreeType treeNode){
		if(treeNode!=null){
			clearTree(treeNode.left);
			clearTree(treeNode.right);
			treeNode = null;
		}
	}
	public void showTreeNode(TreeType treeNode){
		System.out.printf("%s",treeNode.data);
	}
	
	public void levelTree(TreeType treeNode){
		TreeType p;
		TreeType []q =new TreeType[MAXLEN];
		int head =0,tail=0;
		if(treeNode!=null){
			tail = (tail+1)%MAXLEN;
			q[tail] = treeNode;
		}
		while(head!=tail){
			head = (head+1)%MAXLEN;
			p = q[head];
			showTreeNode(p);
			if(p.left!=null){
				tail = (tail+1)%MAXLEN;
				q[tail] = p.left;
			}
			if(p.right!=null){
				tail = (tail+1)%MAXLEN;
				q[tail] = p.right;
			}
		}
	}
	public void preTree(TreeType treeNode){
		if(treeNode!=null){
			showTreeNode(treeNode);
			preTree(treeNode.left);
			preTree(treeNode.right);
		}
	}
	public void inTree(TreeType treeNode){
		if(treeNode!=null){
			inTree(treeNode.left);
			showTreeNode(treeNode);
			inTree(treeNode.right);
		}
	}
	public void postTree(TreeType treeNode){
		if(treeNode!=null){
			postTree(treeNode.left);
			postTree(treeNode.right);
			showTreeNode(treeNode);
		}
	}
}
