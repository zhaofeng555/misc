package hjg.qunaer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式 转 后缀表达式
 */

public class ExpressConvert {

	/**
	 * 优先级比较
	 * 
	 * @param operator1
	 *            比较值
	 * @param operator2
	 *            被比较值
	 * @return 小于等于返回false,大于返回true
	 */
	public boolean comparePrior(char operator1, char operator2) {
		if ('(' == operator2) {
			return true;
		}
		if ('*' == operator1 || '/' == operator1) {
			if ('+' == operator2 || '-' == operator2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 转为后缀表达式: 
	 * 1、如果是"("直接压入stack栈。
	 * 2、如果是")"，依次从stack栈弹出运算符加到数组newExpressionStrs的末尾，知道遇到"("；
	 * 3、如果是非括号，比较扫描到的运算符，和stack栈顶的运算符。如果扫描到的运算符优先级高于栈顶运算符则，把运算符压入栈。否则的话，
	 * 就依次把栈中运算符弹出加到数组newExpressionStrs的末尾，直到遇到优先级低于扫描到的运算符或栈空，并且把扫描到的运算符压入栈中。就这样依次扫描，知道结束为止。如果扫描结束，栈中还有元素，则依次弹出加到数组newExpressionStrs的末尾，就得到了后缀表达式。
	 * 
	 * @param expressionChars
	 * @return
	 */
	public List toSuffixExpression(char[] expressionChars) {
		// 新组成的表达式
		List newExpressionStrs = new ArrayList();
		Stack stack = new Stack();
		for (int i = 0; i < expressionChars.length; i++) {
			
			if ('(' == (expressionChars[i])) { // 如果是左括号,则入栈
				stack.push(expressionChars[i]);
				
			} else if ('+' == expressionChars[i] || '-' == expressionChars[i] || '*' == expressionChars[i] || '/' == expressionChars[i]) {
				if (!stack.empty()) { // 取出先入栈的运算符
					Character s = (Character) stack.pop();
					if (comparePrior(expressionChars[i], s)) { // 如果栈值优先级小于要入栈的值,则继续压入栈
						stack.push(s);
					} else { // 否则取出值
						newExpressionStrs.add(s);
					}
				}
				stack.push(expressionChars[i]);
				
			} else if (')' == expressionChars[i]) { // 如果是')',则出栈,一直到遇到'('
				while (!stack.empty()) {
					Character s = (Character) stack.pop();
					if (!('(' == s)) {
						newExpressionStrs.add(s);
					} else {
						break;
					}
				}
				
			} else {
				
				newExpressionStrs.add(expressionChars[i]);
			}
			
		}
		
		while (!stack.empty()) {
			Character s = (Character) stack.pop();
			newExpressionStrs.add(s);
		}
		return newExpressionStrs;
	}

	public static void main(String[] args) {

//		String expressionStr = "5-(7-5+1)-4+(6-5+3)+2";
		String expressionStr = "7-5+(4+(1+2))";
		// 分割成表达式数组
		char[] expressionChrs = expressionStr.toCharArray();

		List newExpressionStrs = new ExpressConvert().toSuffixExpression(expressionChrs);
		Iterator iter = newExpressionStrs.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
	}
}