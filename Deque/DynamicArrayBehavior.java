
// NO NEED to modify

public interface DynamicArrayBehavior<E>{
  public void append(E item);
  public E getFirstItem() throws IllegalStateException;
  public E getLastItem() throws IllegalStateException;
}