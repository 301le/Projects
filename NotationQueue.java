import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
	int size;
	final int DEFAULT_SIZE = 25;
	ArrayList<T> queue;
	public NotationQueue() {
		size = DEFAULT_SIZE;
		queue = (ArrayList<T>)new ArrayList<T>();
	}
	public NotationQueue(int size) {
		queue = (ArrayList<T>)new ArrayList<T>();
		this.size = size;
	}
	public boolean isEmpty() {
		if(queue.size() == 0) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if(size == -1) {
			return false;
		}
		if(queue.size() == size) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		return queue.remove(0);
		
	}
	public int size() {
		return queue.size();
	}
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		}
		queue.add(queue.size(), e);
		return true;
	}
	@Override
	public String toString(String delimiter) {
		String ret = "";
		for(T s: queue) {
			ret += s.toString() + delimiter;
		}
		return ret.substring(0, ret.length()-1);
	}
	public String toString() {
		String ret = "";
		for(T s: queue) {
			ret += s.toString();
		}
		return ret;
	}
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		for(T object: list) {
			try {
				this.enqueue(object);
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
