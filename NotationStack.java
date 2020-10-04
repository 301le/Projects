import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>{
	ArrayList<T> stack;
	int size;
	private final static int DEFAULT_SIZE = 25;
	public NotationStack() {
		stack = (ArrayList<T>)new ArrayList<T>();
		size = DEFAULT_SIZE;
	}
	public NotationStack(int size) {
		stack = (ArrayList<T>)new ArrayList<T>();
		this.size = size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(stack.size() == 0) {return true;}
		return false;
	}

	@Override
	public boolean isFull() {
		if(size == -1) {
			return false;
		}
		if(stack.size() == size) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		// TODO Auto-generated method stub
		return stack.remove(stack.size()-1);
	}

	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack.get(stack.size()-1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean push(Object e) throws StackOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new StackOverflowException();
		}
		stack.add((T)e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String ret = "";
		for(T s: stack) {
			ret += s.toString() + delimiter;
		}
		return ret.substring(0, ret.length()-1);
	}
	public String toString() {
		// TODO Auto-generated method stub
		String ret = "";
		for(T s: stack) {
			ret += s.toString();
		}
		return ret;
	}

	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		for(T object: list) {
			try {
				this.push(object);
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
