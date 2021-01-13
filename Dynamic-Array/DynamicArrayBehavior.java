public interface DynamicArrayBehavior{
  public void append(int item);
  public int getFirstItem() throws IllegalStateException;
  public int getLastItem() throws IllegalStateException;
}