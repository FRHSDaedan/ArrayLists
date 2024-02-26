//-------------------------------------------------------- imports --------------------------------------------------------

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayList_Milla<E> extends AbstractList<E> implements List<E>{  
  private Object[] array;
  private int size;

  //-------------------------------------------------------- constructors --------------------------------------------------------
  
  public ArrayList_Milla()
  {
    array = (E[])(new Object[5]);
  }

  public ArrayList_Milla(Collection<? extends E> c)
  {
    array = (E[])(new Object[10]);
    this.addAll(c);
  }

  public ArrayList_Milla(int initialCapacity)
  {
    array = (E[])(new Object[initialCapacity]);
  }

  //-------------------------------------------------------- add method --------------------------------------------------------

  public boolean add(E e)
  {
    ensureCapacity(size + 1);
    array[size] = e;
    size++;
    return true;
  }

  //-------------------------------------------------------- add index method --------------------------------------------------------

  public void add(int index, E e)
  {
    ensureCapacity(size + 1); 

    for(int i = size; i > index; i--)
      {
        array[i] = array[i - 1]; 
      }

    array[index] = e;
    size++;
  }

  //-------------------------------------------------------- clear method --------------------------------------------------------
  
  public void clear()
  {
    array = (E[])(new Object[5]);
    size = 0;
  }

  //-------------------------------------------------------- contains method --------------------------------------------------------

  public boolean contains(Object o)
  {
    for(int i = 0; i < size; i++)
    {
      if(array[i].equals(o))
        return true;
    }
    return false;
  }

//-------------------------------------------------------- ensureCapacity method --------------------------------------------------------
  
  public void ensureCapacity(int minCapacity)
  {
    if(minCapacity > array.length)
    {
      E[] newArray = (E[])(new Object[minCapacity]);
      
      for(int i = 0; i < size; i++)
        {
          newArray[i] = (E) array[i];
        }
      array = newArray;
    }
  }

  //-------------------------------------------------------- get method --------------------------------------------------------

  public E get(int index)
  {
    return (E) array[index];
  }

  //-------------------------------------------------------- indexOf method --------------------------------------------------------

  public int indexOf(Object o)
  {
    for (int i = 0; i < size; i++)
    {
      if (array[i].equals(o))
      {
        return i;
        
      }
    }
    return -1;
  }

  //-------------------------------------------------------- lastIndexOf method --------------------------------------------------------

  public int lastIndexOf(Object o)
  {
    int index = -1;

    for(int i = 0; i < size; i++)
    {
      if (array[i].equals(o))
      {
        index = i;
      }
    }
    return index;
  }

  //-------------------------------------------------------- remove method --------------------------------------------------------

  public boolean remove(Object o)
  {
    for (int i = 0; i < size; i++)
    {
      if (array[i].equals(o))
      {
        for(int j = i; j < size - 1; j++)
        {
          array[j] = array[j + 1];
        }
        array[size - 1] = null;
        size--;
        return true;
      }
    }
    return false;
  }

  //-------------------------------------------------------- remove index method --------------------------------------------------------

  public E remove(int index) //use Object O
  { 
    if(index >= 0 && index < size) 
    {
      E oldVal = (E) array[index];
      for (int i = index; i< size - 1; i++)
        {
          array[i] = array[i + 1];
        }
      array[size - 1] = null;
      size--;
      return oldVal;
    }
    return null;
  }

  //-------------------------------------------------------- removeRange method --------------------------------------------------------

  protected void removeRange(int fromI, int toI)
  {
    for(int k = fromI; k < toI; k++)
      {
        remove(fromI);
      }
  }

//-------------------------------------------------------- set method --------------------------------------------------------
  
  public E set(int i, E e)
  {
    E oldVal = (E) array[i]; 
    array[i] = e;
    return oldVal;
  }

  //-------------------------------------------------------- size method --------------------------------------------------------

  public int size()
  {
    return size;
  }

  //-------------------------------------------------------- subList method --------------------------------------------------------

  public List<E> subList(int i, int j)
  {
    List<E> subList = new ArrayList_Milla<>();

    for (int index1 = i; i < j; i++)
    {
      subList.add((E) array[i]);
    }
    return subList;
  }

  //-------------------------------------------------------- trimToSize method --------------------------------------------------------

  public void trimToSize()
  {
    if(size < array.length)
    {
      E[] newArray = (E[]) new Object[size];

      for(int i = 0; i < size; i++)
        {
          newArray[i] = (E) array[i];
        }

      array = newArray;
    }
  }

  //-------------------------------------------------------- toArray method --------------------------------------------------------

  public Object[] toArray()
  {
    return array;
  }

  //-------------------------------------------------------- getArrayLength method --------------------------------------------------------
  //note - comment out this method before submission. only used for testing ensureCapacity and trimToSize methods.
  public int getArrayLength()
    {
    return array.length;
    }
  
}