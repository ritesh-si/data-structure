package com.data.structure.linkedlist;

import java.util.ArrayList;


public class LinkedList
{

    private Node head;


    //Inserts a new  node at front of the list
    public void push( int data )
    {
        Node newNode = new Node( data );
        newNode.next = head;
        head = newNode;

    }


    //Inserts a new  node at end of the list
    public void append( int data )
    {
        if ( head == null ) {
            head = new Node( data );
            return;
        }

        Node newNode = new Node( data );

        Node last = head;
        while ( last.next != null ) {
            last = last.next;
        }
        last.next = newNode;
    }


    //Inserts a new  node at specified position of the list
    public void insertAfter( Node prevNode, int data )
    {
        if ( head == null ) {
            head = new Node( data );
            return;
        }

        Node newNode = new Node( data );
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }


    //prints the list
    public ArrayList<Object> printList()
    {
        Node node = head;
        ArrayList<Object> list = new ArrayList<>();
        while ( node != null ) {
            list.add( node.data );
            node = node.next;
        }
        return list;
    }


    //returns size of the list
    public int size()
    {
        Node node = head;
        int size = 0;
        while ( node != null ) {
            size++;
            node = node.next;
        }

        return size;
    }


    //deletes a node whose value is specified
    public void delete( int key )
    {
        Node temp = head;
        Node prev = null;

        if ( temp != null && temp.data == key ) {
            head = temp.next;
            return;
        }

        while ( temp != null && temp.data != key ) {
            prev = temp;
            temp = temp.next;
        }

        if ( temp == null )
            return;

        prev.next = temp.next;
    }


    public void deletePosition( int position )
    {
        Node temp = head;
        Node prev = null;

        if ( position == 1 ) {
            head = temp.next;
            return;
        }

        int count = 1;
        while ( temp != null && count != position ) {
            prev = temp;
            count++;
            temp = temp.next;
        }

        if ( temp == null )
            return;

        prev.next = temp.next;
    }


    public static void main( String[] args )
    {
        LinkedList linkedList = new LinkedList();
        linkedList.push( 4 );
        linkedList.push( 3 );
        linkedList.push( 2 );
        linkedList.push( 1 );
        System.out.println( linkedList.printList() );
        linkedList.deletePosition( 5 );

        System.out.println( linkedList.printList() );
    }

}