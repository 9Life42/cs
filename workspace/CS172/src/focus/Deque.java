package focus;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	public class Node {
		Item item;
		Node next;
		Node previous;
	}

	private Node front;
	private Node back;
	private int size;

	public Deque() {
		front = null;
		back = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFront(Item item) {
		if (size == 0) {
			front = new Node();
			front.item = item;
			back = front;
		} else {
			Node oldFront = front;
			front = new Node();
			front.item = item;
			front.next = oldFront;
			oldFront.previous = front;
		}
		size++;
	}

	public Item removeFront() {
		Item item = front.item;
		front = front.next;
		if (size > 1)
			front.previous = null;
		else
			back = null;
		size--;
		return item;
	}

	public int size() {
		return size;
	}

	public void addBack(Item item) {
		if (size == 0) {
			back = new Node();
			back.item = item;
			front = back;
		} else {
			Node oldBack = back;
			back = new Node();
			back.item = item;
			back.previous = oldBack;
			oldBack.next = back;
		}
		size++;
	}

	public Item removeBack() {
		Item item = back.item;
		back = back.previous;
		if (size > 1)
			back.next = null;
		else
			front = null;
		size--;
		return item;
	}

	@Override
	public String toString() {
		Node node = front;
		String s = "<";

		if (size > 0) {
			for (int i = 0; i < size - 1; i++) {
				s += node.item;
				s += ", ";
				node = node.next;
			}
			s += node.item;
		}

		s += ">";
		return s;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {

		Node current;

		public DequeIterator() {
			current = front;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {

		}

	}

}
