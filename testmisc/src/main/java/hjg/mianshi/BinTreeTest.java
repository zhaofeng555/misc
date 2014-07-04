package hjg.mianshi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinTreeTest {

	public static void main(String[] args) throws IOException {
		BinTree tree = new BinTree();

		while (true) {
			int choose = Integer.valueOf(mInput("\n\t\t1.创建二叉树\n\t\t2.修改节点"
					+ "\n\t\t3.插入节点\n\t\t4.反推二叉树\n\t\t0.退出"));
			switch (choose) {
			case 1:
				/**
				 * 创建二叉树
				 */
				String str = mInput("输入一个字符串，如：adb###ce##h##.");
		//		tree.setString(str);
				tree.createTree(str.toCharArray());
				// tree.createTree(str.toCharArray());
				tree.showTree(tree.getRoot());// , str.length());
				/**
				 * 遍历二叉树
				 */
				tree.mPrintln("\n 层数 : " + tree.getDepth(tree.getRoot()));
				traverseByThreeWays(tree.getRoot(), tree);
				break;
			case 2:

				/**
				 * 修改指定的节点
				 */
				tree.update(mInput("\n 输入要修改节点的置 位:").charAt(0), mInput(
						"\n修改后的值。如：修改节点'a'，则输入‘a'").charAt(0));
				tree.showTree(tree.getRoot());// , str.length());
				traverseByThreeWays(tree.getRoot(), tree);
			//	tree.mPrintln("\n 输入要删除节点的置位 。如：删除节点'a'，则输入‘a'");
				break;
			case 3:
				/**
				 * 插入一个节点
				 */
				tree.insert(mInput("\n 插入位置：").charAt(0), mInput("\n 插入值：")
						.charAt(0));
				tree.showTree(tree.getRoot());// , str.length() + 1);
			//	tree.mPrintln("\n\n");
			//	tree.preOrder(tree.getRoot());
				tree.mPrintln("\n 层数 : " + tree.getDepth(tree.getRoot()));
				traverseByThreeWays(tree.getRoot(),tree);
				break;
			case 4:
				/**
				 * 根据给出的中序和后序序列推导出二叉树
				 */
				String strInorder = mInput("\n 输入一个中序序列: ");
			//	tree.setString(strInorder);
				String strPostorder = mInput("\n 输入一个后序序列: ");
				tree.setRoot(tree.createTreeByInorderAndPostorder(strInorder,
						strPostorder));
				tree.showTree(tree.getRoot());
				traverseByThreeWays(tree.getRoot(), tree);

				break;
		//	case 9:
		//		Runtime.getRuntime().exec(".\cls");
		//		break;
			case 0:
				System.exit(0);
				break;
			default:
				
				break;
			}
		}

		/**
		 * 删除指定节点
		 */
	}

	/**
	 * 输入字符串
	 * 
	 * @param str01
	 *            提示用户输入的内容
	 * @return 返回用户输入的内容
	 * @throws IOException
	 *             当输入出错时抛出异常
	 */
	private static String mInput(String str01) throws IOException {
		System.out.println(str01);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	/**
	 * 遍历二叉树的三种方法（前、中、后）
	 * 
	 * @param node
	 *            二叉树的根节点
	 * @param tree
	 *            类BinTree的对象
	 */
	private static void traverseByThreeWays(BinTree node, BinTree tree) {
		tree.mPrintln("\n先序:  ");
		tree.preOrder(tree.getRoot());
		tree.mPrintln("\n\n中序:  ");
		tree.inOrder(tree.getRoot());
		tree.mPrintln("\n\n后序:  ");
		tree.posOrder(tree.getRoot());
		tree.mPrintln("\n 按层遍历 ： ");
		tree.levelOrderTraverse(tree.getRoot());
	}
}



