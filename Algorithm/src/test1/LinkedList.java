package test1;

class ListNode {
	private String data;
	public ListNode next;

	public ListNode(String data) {
		this.data = data;
		this.next = null;
	}

	public String getData() {
		return this.data;
	}
}

public class LinkedList {

	private ListNode head;

	public LinkedList() {
		head = null;
	}

	public void insertNode(ListNode preNode, String data) {
		ListNode newNode = new ListNode(data);
		newNode.next = preNode.next;
		preNode.next = newNode;
	}

	public void insertNode(String data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
		} else {
			ListNode tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
		}
	}

	public void deleteNode(String data) {
		ListNode preNode = head;
		ListNode tempNode = head.next;

		if (data.equals(preNode.getData())) {
			head = preNode.next;
			preNode.next = null;
		} else {
			while (tempNode != null) {
				if (data.equals(tempNode.getData())) {
					if (tempNode.next == null) {
						preNode.next = null;
					} else {
						preNode.next = tempNode.next;
						tempNode.next = null;
					}
					break;
				} else {
					preNode = tempNode;
					tempNode = tempNode.next;
				}
			}
		}
	}

	public void deleteNode() {
		ListNode preNode;
		ListNode tempNode;

		if (head == null) {
			return;
		}

		if (head.next == null) {
			head = null;
		} else {
			preNode = head;
			tempNode = head.next;

			while (tempNode.next != null) {
				preNode = tempNode;
				tempNode = tempNode.next;
			}
			preNode.next = null;
		}
	}

	public ListNode searchNode(String data) {
		ListNode tempNode = this.head;
		while (tempNode != null) {
			if (data.equals(tempNode.getData())) {
				return tempNode;
			} else {
				tempNode = tempNode.next;
			}
		}
		return tempNode;
	}

}