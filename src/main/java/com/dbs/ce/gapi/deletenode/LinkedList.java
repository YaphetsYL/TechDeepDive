package com.dbs.ce.gapi.deletenode;

/**
 * @author Lei
 * @version 1.0
 */
public class LinkedList {

    Node head;

    public int deleteNode(Node node) {
        int data = node.data;
        node.data = node.next.data;
        node.next = node.next.next;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node node = head;
        String sep = "";
        while (node != null) {
            sb.append(sep).append(node.data);
            node = node.next;
            sep = ", ";
        }
        return sb.append("}").toString();
    }
}
