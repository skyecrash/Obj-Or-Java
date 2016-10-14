import java.util.Iterator;

/** 
 * An iterator for the double linked list class.
 */
public class DoubleLinkedListIterator<T> implements Iterator<T> {
  
  /** Stores the current node in the iteration. */
  private DLNode<T> cursor;
  
  /** Stores the double linked list. */
  private DoubleLinkedList<T> list;
  
  /** Indicates whether or not a removal has taken place for the iteration. */
  private boolean removeDone;
  
  /** The last element called by next() or previous(). */
  private DLNode<T> lastElement;
 
  /**
   * Creates the iterator.
   * @param list The DoubleLinkedList to be iterated.
   */
  public DoubleLinkedListIterator(DoubleLinkedList<T> list) {
    this.list = list;
    this.cursor.setNext(list.getFront());
    this.cursor.setPrevious(null);
    this.removeDone = true; // so the IllegalStateException can be thrown
  }
  
  /**
   * Getter for list.
   */
  public DoubleLinkedList<T> getList() {
    return list;
  }
  
  /** 
   * Returns true if there are still more elements in front of nodeptr to iterate.
   * @return true if there are more elements
   */
  public boolean hasNext() {
    return cursor.getNext() != null;
  }
  
  /** 
   * Returns true if there are still elements behind nodeptr to iterate.
   * @return True if there are more elements.
   */
  public boolean hasPrevious() {
    return cursor.getPrevious() != null;
  }
  
  /**
   * Adds an element at the cursor's current position.
   * @param element The element to be added.
   */
  public void add(T element) {
    if(list.isEmpty())
      list.addToFront(element);
    else
      new DLNode<T>(element, cursor.getPrevious(), cursor.getNext());
  }
  
  /** 
   * Each time next is called, the next element of the list, in order, is returned.
   * @return the next element in this traversal of the list
   */
  public T next() {
    this.lastElement = cursor.getNext();
    cursor.setNext(cursor.getNext().getNext());
    cursor.setPrevious(cursor.getNext().getNext().getPrevious());
    this.removeDone = false;
    return lastElement.getElement();
  }
  
  /**
   * Each time previous is called, the previous element is returned and the cursor moves backwards.
   * @return The previous element in the traversal of the list.
   */
  public T previous() {
    this.lastElement = cursor.getPrevious();
    cursor.setPrevious(cursor.getPrevious().getPrevious());
    cursor.setNext(cursor.getPrevious().getPrevious().getNext());
    this.removeDone = false;
    return lastElement.getElement();
  }
  
  /**
   * Remove the node of the element that was just returned by next or previous.
   */
  public void remove() throws IllegalStateException {
    if(removeDone) {
      throw new IllegalStateException();
    }
    if(!hasNext()) {
      list.removeFromBack();
      removeDone = true;
    }
    else if(!hasPrevious()) {
      list.removeFromFront();
      removeDone = true;
    }
    else {
      lastElement.getPrevious().setNext(lastElement.getNext());
      lastElement.getNext().setPrevious(lastElement.getPrevious());
    }
  }
    
}