/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author Novin Pendar
 */
public class List {

    private LinkList first;
    private LinkList last;

    public List() {
        first = last = null;
    }

    /**
     * Inset a node at front of the stack
     *
     * @param item
     */
    public void Push(LinkList item) {
        if (isEmpty()) {
            first = last = item;
        } else {
            first.setNext(item);
            item.setPrev(first);
            first = first.getNext();
        }
    }

    /**
     * Return a node from front of the stack
     *
     * @return LinkList
     */
    public LinkList Pop() {
        LinkList temp = null;
        if (isEmpty()) {
            return temp;
        } else {
            temp = first;
            if (first == last) {
                first = last = null;
            } else {
                first = first.getPrev();
                first.setNext(null);
            }
            return temp;
        }
    }

    /**
     * Insert a node at the back of the queue
     *
     * @param item
     */
    public void enqueue(LinkList item) {
        if (isEmpty()) {
            first = last = item;
        } else {
            last.setNext(item);
            item.setPrev(last);
            last = last.getNext();
        }
    }

    /**
     * Return a node from front of the stack
     *
     * @return LinkList
     */
    public LinkList dequeue() {
        LinkList temp = null;
        if (isEmpty()) {
            return temp;
        } else {
            temp = first;
            if (first == last) {
                first = last = null;
            } else {
                first = first.getNext();
                first.setPrev(null);
            }
            return temp;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public boolean printStack() {
        boolean empty = true;

        System.out.println("Path found using a stack for search:\n");
        if (isEmpty()) {
            System.out.println("There is no path through this maze\n");
            System.out.println("Path length = 0\n");
            return empty;
        } else {
            LinkList current = first;
            int counter = 0;

            List newList = new List();
            while (current != null) {
                LinkList temp = Pop();
                LinkList lk = new LinkList(temp.getX(), temp.getY());
                newList.Push(lk);
                counter++;
                current = current.getPrev();
            }

            current = newList.first;
            while (current != null) {
                System.out.println("[" + current.getX() + "," + current.getY() + "]");
                current = current.getPrev();
            }

            System.out.println();
            System.out.println("Path length = " + counter);

            empty = false;
            return empty;
        }
    }

    public boolean printQueue() {
        boolean empty = true;

        System.out.println("Path found using a queue for search:\n");
        if (isEmpty()) {
            System.out.println("There is no path through this maze\n");
            System.out.println("Path length = 0\n");
            return empty;
        } else {
            LinkList current = first;
            int counter = 0;
            while (current != null) {
                System.out.println("[" + current.getX() + "," + current.getY() + "]");
                counter++;
                current = current.getNext();
            }
            System.out.println();
            System.out.println("Path length = " + counter);

            empty = false;
            return empty;
        }
    }
}
