package com.data.structure.linkedlist;

import java.util.ArrayList;


public class LinkedList
{

    Node head;


    public void push( int data )
    {
        Node newNode = new Node( data );
        newNode.next = head;
        head = newNode;

    }


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
}
