import java.util.NoSuchElementException;

public class MyLinkedList {

	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.setValue(value);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
	
	private Node first;
	private Node last;
	
	public void addLast(int item) {
		Node node = new Node(item);
		
		if (first == null) {
			first = last = node;
		} else {
			last.setNext(node);
			last = node;
		}
	}
	
	public void addFirst(int item) {
		Node node = new Node(item);
		
		if (first == null) {
			first = last = node;
		} else {
			node.setNext(first);
			first = node;
		}
	}
	
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while(current != null) {
			if (current.value == item) return index;
			
			current = current.next;
			index++;
		}
		return -1;
	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		if (first == last) {
			first = last = null;
			return;
		}
		
		Node second = first.next;
		first.next = null;
		first = second;
	}
	
	public void removeLast() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		if (first == last) {
			first = last = null;
			return;
		}
		
		Node previous = getPreviousNode(last);
		last = previous;
		last.next = null;
	}
	
	private Node getPreviousNode(Node node) {
		Node current = first;
		while(current != null) {
			if (current.next == node) return current;
			current = current.next;
		}
		return null;
	}
}
