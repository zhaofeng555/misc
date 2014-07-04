package hjg.mianshi;

public class BinTree {

	/** 节点的数据域 */
	private char data;
	/** 节点的左枝 */
	private BinTree left;
	/** 节点的右枝 */
	private BinTree right;
	/** 根节点 */
	private int maxLength = 1000;
	/** 字符在数组中的位置 */
	private int elementPositionInCharArray = 0;
	/***/
	private BinTree root;
	/***/
	MyStack<BinTree> mStack = new MyStack<BinTree>(100);

	/**
	 * 给节点赋值
	 * 
	 * @param c
	 *            char
	 */
	public BinTree(char c) {
		data = c;
	}

	public BinTree() {

	}

	/**
	 * 返回根节点
	 * 
	 * @return
	 */
	public BinTree getRoot() {
		return root;
	}

	/**
	 * 
	 * @param node
	 */
	public void setRoot(BinTree node) {
		root = node;
	}

	public char getData() {
		return data;
	}

	/**
	 * 创建二叉树
	 * 
	 * @param c
	 *            字符数组，存储所有节点数据域的值。如果为“#”则不创建节点
	 * @param elementPosition
	 *            要赋值给当前节点的字符在数组中的位置
	 * @return node 当前节点，最终返回根节点
	 */
	private BinTree createTree(char[] c, int pos) {
		if (c[pos] != '#') {
			BinTree node = new BinTree(c[pos]);
			if ((pos + 1) * 2 <= c.length) {
				node.left = createTree(c, (pos + 1) * 2 - 1);
				if (((pos + 1) * 2 + 1) <= c.length) {
					node.right = createTree(c, (pos + 1) * 2);
				}
			}
			return node;
		}
		return null;
	}

	/**
	 * 递归先序创建二叉树
	 * 
	 * @param c
	 *            输入的数组
	 * @return 当前节点
	 */
	private BinTree createTree01(char[] c) {
		if (c[elementPositionInCharArray] == '#') {
			elementPositionInCharArray++;
			return null;
		} else {
			BinTree node = new BinTree();
			node.data = c[elementPositionInCharArray];
			++elementPositionInCharArray;
			node.left = this.createTree01(c);
			node.right = this.createTree01(c);
			return node;
		}
	}

	/**
	 * 
	 * @param c
	 *            字符串数组
	 */
	public void createTree(char[] c) {
		// root = this.createTree(c, 0);
		root = this.createTree01(c);
	}

	/**
	 * 查找关键字,返回其位置
	 * 
	 * @param c
	 *            被查找字段
	 * @param key
	 *            查找的关键字
	 * @return 返回关键字的位置
	 */
	public int find(char[] c, char key) {
		int position = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == key) {
				position = i;
				break;
			} else
				position = -1;
		}
		return position;
	}

	/**
	 * 通过给出的中序序列和后序序列反推出二叉树。
	 * 
	 * 先判断inStr的长度，若大于1，则找到二叉树的根节点，即postStr字符串中的最后一个字符（假定这‘
	 * a'）。再找到节点a在inStr中的位置（rootPosition）。 当rootPosition不等于-1时（表示在inStr中存在‘a
	 * '），将rootPosition赋值给leftPosition并创建节点。如果inStr的长度大于等于3则以a为分界点
	 * 将inStr分成strInLeft和strInRight两段字符串，再将postStr（去掉’a'后
	 * ）分成strPostLeft和strPostRight（他们的长度分别与strInLeft和strInRight相同）。
	 * 如此递归调用createTreeByInorderAndPostorder（）方法。
	 * 
	 * @param inStr
	 *            中序字符串
	 * @param postStr
	 *            后序字符串
	 * @return 返回节点，最终返回根节点
	 */
	public BinTree createTreeByInorderAndPostorder(String inStr, String postStr) {
		int cLength = postStr.length();
		if (inStr.length() >= 1) {
			/** 根结点在中序数组中的位置 */
			int rootPosition = this.find(inStr.toCharArray(), postStr.charAt(cLength - 1));
			if (rootPosition == -1)
				this.mPrintln("中序序列：" + inStr + "  与 后序序列：" + postStr + "  不属于同一棵二叉。");
			else {
				int leftPosition = rootPosition;
				/** 给当前节点数据域赋值 */
				BinTree node = new BinTree(postStr.charAt(cLength - 1));
				if (inStr.length() >= 3) {
					String strInLeft = inStr.substring(0, leftPosition);
					String strInRight = inStr.substring(rootPosition + 1, cLength);
					String strPostLeft = postStr.substring(0, leftPosition);
					String strPostRight = postStr.substring(rootPosition, cLength - 1);
					node.left = this.createTreeByInorderAndPostorder(strInLeft, strPostLeft);
					node.right = this.createTreeByInorderAndPostorder(strInRight, strPostRight);
				} else {
					if (inStr.length() == 2) {
						if (rootPosition == 0) {
							BinTree right = new BinTree(inStr.charAt(1));
							node.right = right;
						} else {
							BinTree left = new BinTree(inStr.charAt(0));
							node.left = left;
						}

					} else {

					}
				}
				return node;
			}
		}
		return null;
	}

	/**
	 * 判断输入序列是先序、中序、还是后序
	 * 
	 * @param str
	 *            输入序列
	 */
	public void judgeTraverse(String str) {
		BinTree[] tempPreArray = this.getPreorderArray(root, str.length());
		// this.mPrintln("temp.length = " + temp.length);
		if (str.length() > 1 && tempPreArray[0] != null) {
			int pos = 0;
			if (this.isCorrectArray(tempPreArray, str, pos, pos)) {// str.charAt(0)
				// ==
				// tempPreArray[0].data)
				// {
				if (this.isCorrectArray(this.getInorderArray(root, str.length()), str, pos, pos)) {
					this.mPrintln("\n序列 -> " + str + "  既是先序序列，又是中序序列。");
				} else {
					this.mPrintln("\n序列 -> " + str + "  是先序序列");
				}
			} else {
				if (this.isCorrectArray(this.getInorderArray(root, str.length()), str, pos, pos)) {
					if (this.isCorrectArray(tempPreArray, str, pos, str.length() - 1)) {
						this.mPrintln("\n序列 -> " + str + "  既是中序序列，又是后序序列。");
					} else {
						this.mPrintln("\n序列 -> " + str + "  是中序序列。");
					}
				} else {
					this.mPrintln("\n序列 -> " + str + "  是后序序列");
				}
			}
		} else if (str.length() == 1) {
			this.mPrintln("\n 你输入的序列-> " + str + " 只有一个字符，无法判别！");
		} else {
			this.mPrintln("\n 无效!");
		}
	}

	/**
	 * 判断输入序列是否是想要的序列
	 * 
	 * @param array
	 *            参考序列
	 * @param strArray
	 *            输入序列
	 * @param posOfStr
	 *            在输入序列中元素的位置
	 * @param posOfArray
	 *            在参考序列中元素的位置
	 * @return 当输入序列与参考序列一至时返回true；反之，返回false
	 */
	private boolean isCorrectArray(BinTree[] array, String strArray, int posOfStr, int posOfArray) {
		boolean tempBoolean = false;
		if (posOfArray > 0) {
			tempBoolean = true;
		} else {
			tempBoolean = false;
		}
		while (posOfStr < array.length) {
			if (strArray.charAt(posOfStr) != array[posOfArray].data) {
				tempBoolean = false;
				break;
			} else {
				if (posOfStr == array.length - 1) {
					tempBoolean = true;
				}
			}
			posOfStr++;
			if (tempBoolean) {
				posOfArray--;
			} else {
				posOfArray++;
			}
		}
		return tempBoolean;
	}

	/**
	 * 非递归先序遍历二叉树，得到二叉树的先序排列的节点数组
	 * 
	 * @param node
	 *            遍历的节点
	 * @param length
	 *            储存节点的数组的大小
	 * @return 返回一个先序序列
	 */
	private BinTree[] getPreorderArray(BinTree node, int length) {
		BinTree[] preorderList = new BinTree[length];
		int pos = 0;
		// MyStack.golbalStack.setInitialSize(maxLength);
		while (node != null || !mStack.isEmpty()) {// !MyStack.golbalStack.isEmpty()){
			while (node != null) {
				/** 压入所有的左节点，压入前访问它 */
				// visit(node.data);
				preorderList[pos] = node;
				// MyStack.golbalStack.push(node);
				// extracted(node);
				mStack.push(node);
				node = node.left;
				pos++;
			}
			if (!mStack.isEmpty()) {// MyStack.golbalStack.isEmpty()){//
				node = (BinTree) mStack.pop();
				node = node.right;
			}
		}
		return preorderList;
	}

	/*
	 * private void extracted(BinTree node) { MyStack.golbalStack.push(node); }
	 */
	/**
	 * 非递归中序遍历二叉树，得到一个节点数组
	 * 
	 * @param node
	 *            根节点
	 * @param size
	 *            数组inorderArray的大小
	 * @return inorderArray 返回以中序储存的节点数组
	 */
	private BinTree[] getInorderArray(BinTree node, int size) {
		BinTree[] inorderArray = new BinTree[size];
		int pos = 0;
		while (node != null) {
			while (node != null) {
				if (node.right != null)
					mStack.push(node.right);
				mStack.push(node);
				node = node.left;
			}
			node = (BinTree) mStack.pop();
			while (!mStack.isEmpty() && node.right == null) {
				inorderArray[pos] = node;
				pos++;
				node = (BinTree) mStack.pop();
			}
			inorderArray[pos] = node;
			pos++;
			if (!mStack.isEmpty())
				node = (BinTree) mStack.pop();
			else
				node = null;
		}
		return inorderArray;
	}

	/**
	 * 先序递归遍历
	 * 
	 * @param node
	 *            要遍历的节点
	 */
	public void preOrder(BinTree node) {
		if (node != null) {
			visit(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * 中序递归遍历
	 * 
	 * @param node
	 *            要遍历的节点
	 */
	public void inOrder(BinTree node) {
		if (node != null) {
			inOrder(node.left);
			visit(node.data);
			inOrder(node.right);
		}
	}

	/**
	 * 后序递归遍历
	 * 
	 * @param node
	 *            要遍历的节点
	 * 
	 */
	public void posOrder(BinTree node) {
		if (node != null) {
			this.posOrder(node.left);
			this.posOrder(node.right);
			this.visit(node.data);
		}
	}

	/**
	 * 非递归先序查找节点，当遍历到节点的值与key值相等时返回该节点
	 * 
	 * @param node
	 *            已经存在的节点
	 * @param key
	 *            找查的关键字
	 * @return 返回查找到的节点
	 */
	public BinTree find(BinTree node, char key) {
		BinTree theNode = node;
		if (node != null) {
			mStack.push(node);
			while (!mStack.isEmpty()) {
				node = (BinTree) mStack.pop();
				if (node.data == key)
					theNode = node;
				if (node.right != null)
					mStack.push(node.right);
				if (node.left != null)
					mStack.push(node.left);
			}
		}
		return theNode;
	}

	/**
	 * 修改节点的数据域
	 * 
	 * @param key
	 *            修改位置
	 * @param c
	 *            修改后的值
	 */
	public void update(char key, char c) {
		BinTree node = this.find(root, key);
		if (node != null) {
			node.data = c;
			this.mPrintln(" " + c);
		} else {
			this.mPrintln("\n没有找到该节点。");
		}
	}

	/**
	 * 插入一个节点。根据用户输入的key值确定需要插入的节点的位置（parent）。
	 * 如果parent的左枝为空，则将新节点插到parent的左枝；若其左枝不为空、
	 * 但其右枝为空则插到右枝；当parent的左右枝都不为空，则插到其左枝
	 * 
	 * @param key
	 *            节点的插入位置
	 * @param c
	 *            插入节点的值
	 */
	public void insert(char key, char c) {
		BinTree newNode = new BinTree(c);
		if (root == null) {
			root = newNode;
		} else {
			BinTree parent = find(root, key);
			BinTree current = root;
			if (parent != null) {
				if (parent.left == null && parent.right != null) {
					parent.left = newNode;
				} else if (parent.left != null && parent.right == null) {
					parent.right = newNode;
				} else if (parent.left != null && parent.right != null) {
					current = parent.left;
					newNode.left = current;
					parent.left = newNode;
				} else {
					newNode.left = parent.left;
					parent.left = newNode;
				}
			}

		}
	}

	/**
	 * 删除指定节点
	 * 
	 * @param key
	 */
	public void delete(char key) {
		BinTree current = this.find(root, key);
		if (current != null) {
			if (current.left == null && current.right == null) {
				current = null;
			}
		}
	}

	/**
	 * 按层次从左往右依次遍历二叉树，得到一个节点数组
	 * 
	 * @param node
	 *            根节点
	 * @param treeDepth
	 *            二叉树的度
	 * @return 返回一个按层排列的节点数组
	 */
	public BinTree[] getArrayOfTheWholeTree(BinTree node, int treeDepth) {
		int front = 0;
		int rear = 0;
		BinTree current;
		BinTree[] queue = new BinTree[maxLength];
		if (node != null) { // 根结点入队
			queue[rear] = node;
			rear = (rear + 1) % this.maxLength;
		}
		int theTreeRows = 0;
		for (int row = 1; row <= treeDepth; row++) {
			for (int column = 1; column <= power(2, row - 1); column++) {
				current = queue[front];
				front = (front + 1) % this.maxLength;
				if (current == null) {
					queue[rear] = null;
					queue[rear] = null;
					rear = (rear + 2) % this.maxLength;
					continue;
				} else {
					if (current.left != null) {
						queue[rear] = current.left;
						rear = (rear + 1) % this.maxLength;
					} else {
						queue[rear] = null;
						rear = (rear + 1) % this.maxLength;
					}
					if (current.right != null) {
						queue[rear] = current.right;
						rear = (rear + 1) % this.maxLength;
					} else {
						queue[rear] = null;
						rear = (rear + 1) % this.maxLength;
					}
				}

			}
			theTreeRows++;
		}
		return queue;
	}

	/**
	 * 按遍历二叉树，输出各节点的数据值及节点入队的顺序
	 * 
	 * @param node
	 *            根节点
	 * 
	 */
	public void levelOrderTraverse(BinTree node) {
		int front = 0;
		int rear = 0;
		BinTree current;
		BinTree[] queue = new BinTree[this.maxLength];
		if (node != null) { // 根结点入队
			queue[rear] = node;
			rear = (rear + 1) % this.maxLength;
		}

		while (front != rear) {
			current = queue[front];
			front = (front + 1) % this.maxLength;
			if (current != null) {
				this.mPrint(current.data + " ");
				if (current.left != null) {
					queue[rear] = current.left;

					rear = (rear + 1) % this.maxLength;
					this.mPrint("(" + current.left.data + " ");
				} else {
					queue[rear] = null;

					rear = (rear + 1) % this.maxLength;
					this.mPrint("(# ");
				}
				if (current.right != null) {
					queue[rear] = current.right;

					rear = (rear + 1) % this.maxLength;
					this.mPrint(current.right.data + ")");
				} else {
					queue[rear] = null;
					rear = (rear + 1) % this.maxLength;
					this.mPrint(" #)");
				}
			} else {
				continue;
			}
		}
	}

	/**
	 * 求二叉树深度
	 * 
	 * @param node
	 *            根节点
	 */
	public int getDepth(BinTree node) {

		int ldepth = 0, rdepth = 0; // 分别求左右子树的深度，通过加1得到该树的深度，分而治之

		if (node == null)
			return 0;

		if (node.left != null) // 求左子树的深度(均假设深度已求出)
			ldepth = getDepth(node.left);

		if (node.right != null) // 求右子树的深度(均假设深度已求出)
			rdepth = getDepth(node.right);

		int tempDepth = 0; // 关键之处，递归逻辑体(Math.max(ldepth,rdepth)替换之
		if (ldepth >= rdepth)
			tempDepth = ldepth;
		else
			tempDepth = rdepth;
		return tempDepth + 1;

	}

	/**
	 * 将创建的二叉树以倒立的图形方式打印到屏幕上
	 * 
	 * @param root
	 *            根节点
	 */
	public void showTree(BinTree root) {

		/** 当前节点，用于调用每个节点的数据域 */
		BinTree current01 = root;
		/** 当前节点，用于判断各个节点的左右枝是否为空 */
		// BinTree current02 = root;
		/** 队列头指针 */
		int iFront01 = 0;
		/** 队列头指针 */
		int iFront02 = 0;
		/** 记载front02上一次的值 */
		int iOldFront02 = 0;
		/** 队列尾指针 */
		int iRear01 = 0;
		/** 队列尾指针 */
		int iRear02 = 0;
		/** 二叉树的层数（不包括‘/\’） */
		// int length = this.theStringOfData.length();
		int iTreeRows = this.getDepth(root);
		/** 整棵树的长度（包括空节点） */
		int iTreeDepth = iTreeRows;
		/** 按层遍历整棵二叉树后的数组 */
		BinTree[] queue = new BinTree[maxLength];

		if (root != null) { // 根结点入队
			queue = this.getArrayOfTheWholeTree(root, iTreeDepth);
			iRear01 = (iRear01 + 1) % this.maxLength;
			iRear02 = (iRear02 + 1) % this.maxLength;
		}

		/**
		 * 
		 * @param tempRow
		 *            应该打印出节点的行
		 * @param nextTempRow
		 *            与tempRow 相邻的下一行
		 * 
		 */
		/** 将该二叉树打印成一个倒树所需要的总行数（包括‘/\’） */
		int iWholeTreeRows = power(2, iTreeRows - 1) * 3 / 2;
		/** 根节点与子节点之间的“/”或“\”的个数 */
		int iNumOfBole = (iWholeTreeRows - 2) / 2;
		/***/
		int iNodeRow = 2 + iNumOfBole;
		/***/
		int iOldNodeRow = 0;
		/***/
		int iFirstTempRow = iNodeRow;
		/** 2 的 m-1 次方 */
		int iPowerOfBase = 1;
		/** 相邻两个“/” 或两个“\”之间的距离 */
		int iParallelDistanceofNeighborBole = iWholeTreeRows * 2;
		/** 相邻两个“/”与“\”之间的距离 */
		int iDistanceOfNeighborBole = 0;
		/** column 对 parallelDistanceOfNeighborBole 取余的值 */
		int iRemainder = 0;

		/** 行循环 */
		for (int row = 1; row <= iWholeTreeRows; row++) {

			/** 列循环 */
			for (int column = 0; column <= iWholeTreeRows - row; column++) {
				this.mPrint(" ");
			}
			if (row != iNodeRow) {
				for (int column = 1; column <= row * 2 - 1; column++) {

					iDistanceOfNeighborBole = (row - iOldNodeRow) * 2 + 1;
					iRemainder = column % iParallelDistanceofNeighborBole;
					if (((column == 1 || ((iRemainder == 1) && (row > iOldNodeRow && row < iNodeRow))) && row >= 2)) {
						if (queue[iFront02] != null) {// current02 != null) {
							if (queue[iFront02].left != null) {// current02.left
								// != null) {
								// this.mPrint(current02.data + "");
								this.mPrint("/");
							} else {
								this.mPrint(" ");
							}
						} else {
							this.mPrint(" ");
						}
					} else if ((column == row * 2 - 1 || ((iRemainder == iDistanceOfNeighborBole) && (row > iOldNodeRow && row < iNodeRow)))
							&& row >= 2) {

						/**
						 * current02 与
						 * queue【front02】应该是等价的，但为什么current02会在这里被置为null？
						 * 
						 */
						if (queue[iFront02] != null) {// current02 != null) {
							if (queue[iFront02].right != null) {// current02.right
								// != null) {
								this.mPrint("\\");
							} else {
								this.mPrint(" ");
							}
						} else {
							this.mPrint(" ");
							// this.mPrint("" + queue[front02].data);
						}
						/**
						 * firstTempRow 是tempRow的初值，当打印到要节点的左右子节点的上一行时 开始执行下面代码。
						 */
						if (row >= iFirstTempRow - 1) {
							iFront02 = (iFront02 + 1) % this.maxLength;
							// current02 = queue[iFront02];
						}

					} else if (row == 1) {
						current01 = queue[iFront01];
						iFront01 = (iFront01 + 1) % this.maxLength;
						// current02 = queue[iFront02];
						this.mPrint("" + current01.data);
					} else {
						this.mPrint(" ");
					}
				}
			} else {
				/** 两个树枝之间的距离 */
				int iDistanceBetweenTwoBoles = iWholeTreeRows / (power(2, iPowerOfBase - 1));
				/** 两个节点之间的距离 */
				int iDistanceBetweenTwoNodes = 0;
				for (int column = 1; column <= row * 2 - 1; column++) {
					/** 处理最底下的一行 */
					if (row == iWholeTreeRows) {
						if (column == 1)
							iDistanceBetweenTwoNodes = 4;
						if ((column == 1 || column == iDistanceBetweenTwoNodes + 1 || column == iDistanceBetweenTwoNodes + 3)) {
							if (column == iDistanceBetweenTwoNodes + 3) {
								iDistanceBetweenTwoNodes = column + 3;
							}
							current01 = queue[iFront01];
							iFront01 = (iFront01 + 1) % this.maxLength;
							if (current01 != null) {
								this.mPrint("" + current01.data);
							} else {
								this.mPrint(" ");
							}
						} else {
							this.mPrint(" ");
						}
					} else {
						if ((column == 1 || column == iDistanceBetweenTwoNodes + 1)) {
							current01 = queue[iFront01];
							iFront01 = (iFront01 + 1) % this.maxLength;

							if (current01 != null) {
								this.mPrint("" + current01.data);
							} else {
								this.mPrint(" ");
							}
							iDistanceBetweenTwoNodes += iDistanceBetweenTwoBoles;
						} else {
							this.mPrint(" ");
						}
					}
				}
				iPowerOfBase++;
				iNumOfBole = (iNumOfBole + 1) / 2;
				if (iNumOfBole <= 2)
					iNumOfBole = 2;
				iOldNodeRow = iNodeRow;
				iNodeRow += iNumOfBole;

				iParallelDistanceofNeighborBole /= 2;
			}
			this.mPrint("\n");
			/**
			 * 当打印到节点的上一行时，将此时front02的值赋给oldFront02。反之当每一行打印完时
			 * 将oldFront02的值赋给front02
			 */
			if (row == iNodeRow - 1) {
				iOldFront02 = iFront02;
			} else {
				iFront02 = iOldFront02;
			}
		}
	}

	/**
	 * 幂次方
	 * 
	 * @param base
	 *            基数
	 * @param power
	 *            幂
	 * @return 返回最终的积product
	 */
	public int power(int base, int power) {
		int product = base;
		if (power > 1) {
			while (power > 0) {
				power--;
				product *= base;
				if (power == 1) {
					return product;
				}
			}
		} else if (power == 1)
			product = base;
		else if (power == 0)
			product = 1;
		return product;
	}

	/**
	 * 访问节点
	 * 
	 * @param c
	 *            被访问节点的数据域
	 */
	private void visit(char c) {
		System.out.print(c + " ");
	}

	/**
	 * 输出信息
	 * 
	 * @Param str 打印到屏幕上的字符串
	 */
	public void mPrintln(String str) {
		System.out.println(str);
	}

	public void mPrint(String str) {
		System.out.print(str);
	}
}
