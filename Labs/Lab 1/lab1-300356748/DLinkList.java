/**
 * Builds a singly linked list of size 5 and prints it to the console.
 * 
 * @author Jochen Lang
 */

class DLinkList {
	DNode llist;
	DNode head;
	DNode tail;

	DLinkList(int sz) {
		if (sz <= 0) {
			llist = null;
		} else {
			// Create sentinels
			head = new DNode( null, null, null);
			tail = new DNode( null, null, null);
			head.setPrev( tail );
			tail.setNext( head );
			// start with list of size 1
			llist = new DNode("0", head, tail);
			head.setNext( llist );
			tail.setPrev( llist );
			DNode current = llist; // temp node for loop
			// add further nodes
			for (int i = 1; i < sz; ++i) {
				// create node and attach it to the list
				DNode node2Add = new DNode(Integer.toString(i), null, null);
				current.setNext(node2Add); // add first node
				node2Add.setPrev(current);
				node2Add.setNext(tail);
				tail.setPrev(node2Add);
				current = node2Add;
			}
		}
	}

	/**
	 * Print all the elements of the list assuming that they are Strings
	 */
	public void print() {
		/* Print the list */
		DNode current = head.getNext(); // point to the first node
		while (current != tail) {
			System.out.print((String) current.getElement() + " ");
			current = current.getNext(); // move to the next
		}
		System.out.println();
	}

	public void deleteFirst() {
		if (head.getNext() != null) {
			head.setNext(head.getNext().getNext());
		}
		if (head.getNext() != null) {
			head.getNext().setPrev(head);
		}
	}

	public void deleteLast() {
		if (tail.getPrev() == head)
			return; // no node
		tail.setPrev(tail.getPrev().getPrev());
		tail.getPrev().setNext(tail);
	}

	// create and display a linked list
	public static void main(String[] args) {
		/* Create the list */
		DLinkList llist = new DLinkList(5);
		/* Print the list */
		llist.print();
		/* delete first and print */
		llist.deleteFirst();
		llist.print();
		/* delete last and print 5 times */
		for (int i = 0; i < 5; ++i) {
			llist.deleteLast();
			llist.print();
		}
	}
}
