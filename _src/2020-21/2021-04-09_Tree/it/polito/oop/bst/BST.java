/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.bst;

public class BST<T extends Comparable<T>> {
	private Node<T> root;
	private int numNodes = 0;
	
	public BST(Node<T> root) {
		numNodes = 1;
		this.root = root;
	}
	
	public void addNode(Node<T> node) {
		numNodes += 1;
		Node<T> last = null;
		Node<T> current = root;
		while(current != null) {
			last = current;
			if(current.compareTo(node) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if(last.compareTo(node) > 0) {
			last.left = node;
		} else {
			last.right = node;
		}
	}
}
