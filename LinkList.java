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
public class LinkList {

    private final int X;
    private final int Y;
    private LinkList next;
    private LinkList prev;

    public LinkList(int X, int Y) {
        this.X = X;
        this.Y = Y;
        next = null;
        prev = null;
    }

    public void setNext(LinkList next) {
        this.next = next;
    }

    public void setPrev(LinkList prev) {
        this.prev = prev;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public LinkList getNext() {
        return next;
    }

    public LinkList getPrev() {
        return prev;
    }
}
