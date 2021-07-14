package com.dbs.ce.gapi.deletenode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/7/14 - 07 - 14 - 1:10
 * @Description com.dbs.ce.gapi.deletenode
 */
@Slf4j
class LinkedListTest {

    @Test
    void deleteNode() {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(0);
        linkedList.head.next = new Node(1);
        linkedList.head.next.next = new Node(2);
        linkedList.head.next.next.next = new Node(3);
        linkedList.head.next.next.next.next = new Node(4);

        log.info("Before delete: " + linkedList.toString());
        assertEquals(1, linkedList.deleteNode(linkedList.head.next));
        log.info("After delete: " + linkedList.toString());


    }
}