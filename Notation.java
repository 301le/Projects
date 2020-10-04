
public class Notation {
	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationQueue<String> solutionQueue = new NotationQueue<String>();
		NotationStack<String> stack = new NotationStack<String>();
		for(int i = 0; i < infix.length(); i++) {
			if(infix.charAt(i) == ' ') {
				continue;
			}
			if(Character.isDigit(infix.charAt(i))) {
				try {
					solutionQueue.enqueue(Character.toString(infix.charAt(i)));
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				}
			}
			if(infix.charAt(i) == '(') {
				try {
				stack.push(Character.toString(infix.charAt(i)));
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
			char curChar = infix.charAt(i);
			boolean operatorBool = curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/';
			if(operatorBool) {
				char topChar;
				try {
					topChar = stack.top().toCharArray()[0];
					boolean topCharBool = topChar == '+' || topChar == '-' || topChar == '*' || topChar == '/';
					while(precedenceCheck(curChar, topChar)) {
						if(topCharBool) {
							try {
								String higher = stack.pop();
								solutionQueue.enqueue(higher);
							} catch (QueueOverflowException e) {
								e.printStackTrace();
							}
						}
					}
					try {
						stack.push(Character.toString(curChar));
					} catch (StackOverflowException e) {
						e.printStackTrace();
					}
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
			if(curChar == ')') {
				try {
					boolean containsPar = false;
					while(!stack.isEmpty()) {
						if(stack.top().equals("(")) {
							containsPar = true;
							break;
						}
						String pop = stack.pop();
						try {
							solutionQueue.enqueue(pop);
						} catch (QueueOverflowException e) {
							e.printStackTrace();
						}
					}
					if(!containsPar) {
						throw new InvalidNotationFormatException();
					}
					stack.pop();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
		}
		while(!stack.isEmpty()) {
			try {
				solutionQueue.enqueue(stack.pop());
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}
		return solutionQueue.toString();
	}
	private static boolean precedenceCheck(char curChar, char topChar) {
		return false;
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<String>();
		for(int i = 0; i < postfix.length(); i++) {
			if(postfix.charAt(i) == ' ') {
				continue;
			}
			char curChar = postfix.charAt(i);
			boolean operatorBool = curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/';
			if(Character.isDigit(curChar)) {
				try {
				stack.push(Character.toString(curChar));
				}catch(StackOverflowException e) {
					e.printStackTrace();
				}
			}
			if(operatorBool){
				if(stack.size < 2) {
					throw new InvalidNotationFormatException();
				}
				try {
					String firstVal = stack.pop();
					String secVal = stack.pop();
					String result = "(" + secVal + curChar + firstVal + ")";
					stack.push(result);
				}catch(StackUnderflowException e) {
						e.printStackTrace();
				}catch(StackOverflowException e) {
						e.printStackTrace();
				}
			}
		}
		if(stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		else {
			try {
				return stack.pop();
			} catch (StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
		}
		
	}
	private static double eval(char operator,double val1,double val2) {
		switch(operator) {
		case '+':
			return (double)val2 + (double)val1;
		case '-':
			return (double)val2 - (double)val1;
		case '*':
			return (double)val2 * (double)val1;
		case '/':
			return (double)val2/(double)val1;
		default: 
			return -1;
		}
	}
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		NotationStack<String> stack = new NotationStack<String>();
		for(int i = 0; i < postfixExpr.length(); i++) {
			if(postfixExpr.charAt(i) == ' ') {
				continue;
			}
			char curChar = postfixExpr.charAt(i);
			boolean operatorBool = curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/';
			if(Character.isDigit(curChar) || curChar == '(') {
				try {
					String toPush = Character.toString(curChar);
					stack.push(toPush);
				}catch(StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			else if(operatorBool){
				if(stack.size < 2) {
					throw new InvalidNotationFormatException();
				}
				try {
					double firstVal = Double.parseDouble(stack.pop());
					double secondVal = Double.parseDouble(stack.pop());
					Double result = eval(curChar, firstVal, secondVal);
				try {
					String ret = Double.toString(result);
					stack.push(ret);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
				}catch(StackUnderflowException e) {
				
				}
			}
		}
		if(stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		try {
			return Double.parseDouble(stack.pop());
		}catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
	}
}
