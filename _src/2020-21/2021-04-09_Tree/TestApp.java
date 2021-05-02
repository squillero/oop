/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.function.*;
import it.polito.oop.bst.*;

public class TestApp {
	static public void main(String[] args) {
		Node<Musician> root = new Node<>(new Musician("Jake Blues"));
		BST<Musician> bbb = new BST<>(root);
		
        bbb.addNode(new Node<>(new Musician("Tommy McDonnell")));
        bbb.addNode(new Node<>(new Musician("Steve Cropper")));
        bbb.addNode(new Node<>(new Musician("Lou Marini")));
        bbb.addNode(new Node<>(new Musician("Tom Scott ")));
        bbb.addNode(new Node<>(new Musician("Alan Rubin")));
        bbb.addNode(new Node<>(new Musician("Murphy Dunne")));
        bbb.addNode(new Node<>(new Musician("Steve Jordan")));
        bbb.addNode(new Node<>(new Musician("Willie Hall")));
        bbb.addNode(new Node<>(new Musician("Mighty Mack McTeer")));
        bbb.addNode(new Node<>(new Musician("Tom Malone")));
        bbb.addNode(new Node<>(new Musician("Matt Murphy")));
        bbb.addNode(new Node<>(new Musician("Paul Shaffer")));
        bbb.addNode(new Node<>(new Musician("Jonny Rosch")));
        bbb.addNode(new Node<>(new Musician("Eddie Floyd")));
        bbb.addNode(new Node<>(new Musician("Larry Thurston")));
        bbb.addNode(new Node<>(new Musician("Donald Duck Dunn")));


        inOrderVisit(root, new StringNodeProcessor() {
			public void handle(Node node) {
				System.out.println(node);
			}        	
        });

        System.out.println("");        

        inOrderVisit(root, n -> System.out.println(n));

        System.out.println("");        

        inOrderVisit(root, System.out::println);
}
	
	static void inOrderVisit(Node n, StringNodeProcessor processor) {
		if(n == null)
			return;
		
		inOrderVisit(n.getLeft(), processor);
		processor.handle(n);
		inOrderVisit(n.getRight(), processor);
	}
}
