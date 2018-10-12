package com.cyf.test.math;

public class MyLinkedList {

	int size = 0;
	
	Node head = null;
	
	public void add(Object value) {
		Node newNode = new Node(value);
		if(head==null) {
			head = newNode;
		}else {
			Node temp = head;
			while(temp.getNext()!=null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		size++;
	}
	
	public void set(int index, Object value) {
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.getNext();
		}
		temp.setValue(value);
	}
	
	public Object get(int index) {
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.getNext();
		}
		return temp.getValue();
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.get(0));
	}
}
