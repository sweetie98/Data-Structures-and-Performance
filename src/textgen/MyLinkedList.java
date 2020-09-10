package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size=0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> temp = new LLNode<E>(element);
		if(size==0)
		{
			temp.next=tail;
			temp.prev=head;
			head.next=temp;
			tail.prev=temp;
			size++;
		}
		else
		{
			temp.prev=tail.prev;
			temp.next=tail;
			tail.prev.next=temp;
			tail.prev=temp;
			size++;
		}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		int count=0;
		LLNode<E> temp = head.next;
		while(temp!=null)
		{
			if(index==count)
				return temp.data;
			temp = temp.next;
			count++;
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element)throws IndexOutOfBoundsException,NullPointerException 
	{
		// TODO: Implement this method
		if(element == null)
		{
			throw new NullPointerException();
		}
		if(index<0 || index>size)
		{
			throw new IndexOutOfBoundsException();
		}
		size++;
		int count = 0;
		LLNode<E> temp = head.next;
		while(count!=index)
		{
			count++;
			temp = temp.next;
		}
		LLNode<E> n = new LLNode<E>(element);
		n.next = temp;
		n.prev = temp.prev;
		temp.prev.next = n;
		temp.prev = n;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size ;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		else 
			size--;
		LLNode<E> temp = head.next;
		int count=0;
		while(count!=index)
		{
			temp=temp.next;
			count++;
		} 
		LLNode<E> prev = temp.prev;
		LLNode<E> next = temp.next;
		prev.next = next;
		next.prev = prev;
		return temp.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		LLNode<E> temp = head.next;
		int count=0;
		while(count!=index)
		{
			count++;
			temp=temp.next;
		}
		E replaced = temp.data;
		temp.data = element;
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
