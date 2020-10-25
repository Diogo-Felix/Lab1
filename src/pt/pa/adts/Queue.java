package pt.pa.adts;

/**
 * TODO: Fornecer documentação da interface.
 *
 * @param <T>
 */
public interface Queue<T> {

    public void enqueue(T element);

    public T dequeue() throws QueueErrors;

    public T front();

    public int size();

    public boolean isEmpty();

    public void clear();

    public void show(); //método de teste

}
