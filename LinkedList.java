import java.util.Iterator;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> first;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    first = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirst() {
    return first;
  }

  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFirst(LLNode<T> node) {
    this.first = node;
  }

  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    setFirst(new LLNode<T>(element, getFirst()));
  }
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirst() == null);
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int lengthSoFar = 0;
    LLNode<T> nodeptr = getFirst();
    while (nodeptr != null) {
      lengthSoFar++;
      nodeptr = nodeptr.getNext();
    }
    return lengthSoFar;
  }
  
  /**
   * Prints the contents of the list to the screen, not separated by commas
   * An example using the generic wild card
   */
  public static void printList4(LinkedList<?> list) {
    for (Iterator<?> it = list.iterator(); it.hasNext(); )
      System.out.print(it.next() + " ");
    System.out.println();
  }
   
  /**
   * Prints the contents of the list to the screen, not separated by commas.
   * An example using a "for each" loop.
   */
  public static void printList(Iterable<?> list) {
    for (Object element : list )
      System.out.print(element + " ");
    System.out.println();
  }
  
  
  /**
   * Returns an iterator for the list.  This method is required by the Iterable interface.
   * @return an iterator for the linked list
   */
//  public Iterator<T> iterator() {
//    return new LinkedListIterator<T>(getFirst());
//  }
  
  /**
   * Insert the element in order into a list.
   * Pre-requisite: the list is already in sorted order
   */
  public static <T extends Comparable<? super T>> 
    void insertInOrder(LinkedList<T> list, T element) {
    /** if the list is empty or element is smaller than first entry
      * the element goes in the front
      */
    if (list.isEmpty() || element.compareTo(list.getFirst().getElement()) < 0)
      list.addToFront(element);
    else {
      LLNode<T> nodeptr = list.getFirst();
      /* run through the list until nodeptr's next is bigger than element */
      while (nodeptr.getNext() != null &&
             nodeptr.getNext().getElement().compareTo(element) < 0) {
        nodeptr = nodeptr.getNext();
      }  // at this point, nodeptr's next is larger than element
      nodeptr.setNext(new LLNode<T>(element, nodeptr.getNext()));
    }
      
  }


  /*********************************************************************************
   ********** MERGE SORT CODE ******************************************************
   *********************************************************************************/
  
   /** Merges two sorted lists of nodes into a single list of sorted nodes
    * Prerequisite:  neither list is empty
    * @param list1  the first node of a sorted list of nodes
    * @param list2  the second node of a sorted list of nodes
    * @return the first node of the merged list of sorted nodes
    */
  private static <S extends Comparable<? super S>> 
    LLNode<S> merge(LLNode<S> list1, LLNode<S> list2) {
    
    LLNode<S> newlist;                // points to the first node of the returned list
    LLNode<S> endptr;                 // points to the last node of the returned list, as it is being built
    
    // first we have to identify the first node of the list
    if (list1.getElement().compareTo(list2.getElement()) < 0) {
      newlist = list1;
      list1 = list1.getNext();
    }
    else {
      newlist = list2;
      list2 = list2.getNext();
    }
    endptr = newlist;
    
    // until we reach the end of one of the lists, we figure out which node of list1 or list2
    //  goes next in the list and we add it to the end of the merged list
    while (list1 != null && list2 != null) {
      if (list1.getElement().compareTo(list2.getElement()) < 0) {
        endptr.setNext(list1);
        list1 = list1.getNext();
      }
      else {
        endptr.setNext(list2);
        list2 = list2.getNext();
      }
      endptr = endptr.getNext();
    }
    
    // when the loop exits, one of list1 or list2 is null.  The other list still has nodes
    //  and these must be the largest values of the list and so go at the end of the merged list

    if (list1 != null)
      endptr.setNext(list1);
    else
      endptr.setNext(list2);
    
    return newlist;
    
  }
  
  /** Takes a list of nodes and removes half of the nodes.  The removed nodes are placed
    * in a list and returned.
    * Pre-requisite:  There are at least two nodes in the list
    * @param list1  the first node of a linked list of nodes
    * @return the first node of the list of the nodes that were removed from list1
    */
  private static <S> LLNode<S> split(LLNode<S> list1) {
    LLNode<S> list2 = list1.getNext();              // list2 is the first node of the removed nodes
    LLNode<S> nodeptr = list2;                      // used to traverse down the nodes of list1
    LLNode<S> prevptr = list1;                      // points to the node before nodeptr
    
    // until we reach the end of the list, "unbraid" the list by having each node's next point to the node after the next node
    while (nodeptr != null) {
      prevptr.setNext(nodeptr.getNext());
      prevptr = nodeptr;
      nodeptr = nodeptr.getNext();
    }
    
    return list2;
  }
  
  /** Mergesorts a list of nodes
    * @param list1  the first node of the list of nodes to sort
    * @return the first node of the list of nodes, now in sorted order
    */
  private static <S extends Comparable<? super S>> LLNode<S> mergeSort(LLNode<S> list1) {
    if (list1.getNext() == null)                    // if the list has length 1, it is already sorted
      return list1;
    
    LLNode<S> list2 = split(list1);                 // split thie list in two
    list1 = mergeSort(list1);                       // sort the each half
    list2 = mergeSort(list2);
    return merge(list1, list2);                     // merge the sorted half lists into a single sorted list
  }
  
  /**
   * Mergesorts a linked list
   * @param list  the linked list to merge sort
   */
  public static <S extends Comparable<? super S>> void mergeSort(LinkedList<S> list) {
    list.setFirst(mergeSort(list.getFirst()));
  }
  
}