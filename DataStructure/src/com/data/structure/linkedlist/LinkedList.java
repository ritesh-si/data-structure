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


    //recursive method for printing list
    public void printList( Node node )
    {
        if ( node == null ) {
            System.out.println();
            return;
        }

        System.out.print( node.data + " " );
        printList( node.next );
    }


    //recursive method to print reverse of linked list
    public void printReverse( Node node )
    {
        if ( node == null ) {
            System.out.println();
            return;
        }


        printReverse( node.next );
        System.out.print( node.data + " " );
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


    //recursive method to return size
    public int size( Node node )
    {
        if ( node == null )
            return 0;
        return 1 + size( node.next );
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


    //deletes nodes at the given position
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


    //method return true if an element is found
    public boolean search( int key )
    {
        Node temp = head;

        while ( temp != null ) {
            if ( temp.data == key )
                return true;
            temp = temp.next;
        }
        return false;
    }


    //recursive method return true if an element is found
    public boolean searchRecursive( Node node, int key )
    {
        if ( node == null )
            return false;

        return node.data == key || searchRecursive( node.next, key );

    }
}