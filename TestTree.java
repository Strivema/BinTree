package Ray.Tree;

import java.util.Scanner;

public class TestTree {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		TreeType root = null;
		int men;
		Tree tree = new Tree();
		root = tree.init();
		do{
			System.out.println("select menu add node");
			System.out.println("0.exit");
			System.out.println("1.add a node");
			men = in.nextInt();
			switch(men){
			case 1:
				tree.AddTreeNode(root);
				break;
			case 0:
				break;
				default:
					;
			}
		}while(men!=0);
		
		do{
			System.out.println("ergodic the tree");
			System.out.println("1.preorder tree");
			System.out.println("2.inorder tree");
			System.out.println("3.postorder tree");
			System.out.println("4.level tree");
			men = in.nextInt();
			switch(men){
			case 0:
				break;
			case 1:
				System.out.println("preOrder:");
				tree.preTree(root);
				break;
			case 2:
				System.out.println("inOrder:");
				tree.inTree(root);
				break;
			case 3:
				System.out.println("postOrder:");
				tree.postTree(root);
				break;
			case 4:
				System.out.println("levelOrder:");
				tree.levelTree(root);
				break;
			default:
				;			
			}
			
		}while(men!=0);
		System.out.print("the deepth:");
		System.out.println(tree.TreeDeepth(root));
		tree.clearTree(root);
		root = null;
	}
	
	
}
