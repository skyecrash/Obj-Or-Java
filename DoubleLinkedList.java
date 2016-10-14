import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked linked list.
 */
public class DoubleLinkedList<T> implements Iterable<T> {
  
  /** a reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** a reference to the last node of a double linked list */
  private DLNode<T> back;
  
  /** Create an empty double linked list. */
  public DoubleLinkedList() {
    front = back = null;
  }
  
  /** 
   * Returns true if the list is empty.
   * @return  true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the linked list.
   * @return the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }
  
  /**
   * Sets the first node of the linked list.
   * @param node  the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * @param node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  }
  
  /**
   * Add an element to the head of the linked list.
   * @param element  the element to add to the front of the linked list
   */
  public void addToFront(T element) {
    setFront(new DLNode<T>(element, null, getFront()));
    if(getBack() == null) {
      setBack(getFront());
    }
  }
  
  /**
   * Add an element to the tail of the linked list.
   * @param element  the element to add to the tail of the linked list
   */
  public void addToBack(T element) {
    setBack(new DLNode<T>(element, getBack(), null));
    if(getFront() == null) {
      setFront(getBack());
    }
  }

  /**
   * Remove and return the element at the front of the linked list.
   * @return the element that was at the front of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromFront() throws NoSuchElementException {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    T oldElement = getFront().getElement();
    setFront(getFront().getNext());
    if(!isEmpty()) {
      getFront().setPrevious(null);
    }
    return oldElement;
  }
  
  /**
   * Remove and return the element at the back of the linked list.
   * @return the element that was at the back of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromBack() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    T oldElement = getBack().getElement();
    setBack(getBack().getPrevious());
    if(getBack() == null) {
      setFront(null);
    }
    if(!isEmpty()) {
      getBack().setNext(null);
    }
    return oldElement;
  }
     
  /**
   * Returns a list iterator for the linked list.
   * @return The iterator that runs through the list from the head to the tail
   */
  @Override
  public Iterator<T> iterator() {
    return new DoubleLinkedListIterator<T>(this);
  }
}