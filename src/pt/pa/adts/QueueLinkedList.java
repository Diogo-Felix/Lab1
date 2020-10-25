package pt.pa.adts;

/**
 * TODO: Fornecer documentação da classe.
 *
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        size = 0;
        header = trailer = null;
    }
    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida


    @Override
    public void enqueue(T element) {
        Node node = new Node(element, null,null);

        if(header == null){
            header = trailer = node;
            size++;

        }
        else{
            Node oldTrailer = trailer;
            trailer.prev = node;
            trailer = node;
            trailer.next = oldTrailer;
            size++;
        }

    }

    @Override
    public T dequeue() throws QueueErrors {
        T toReturn;

        if(header == null)
            throw new QueueErrors("Queue vazio");

        if(header.prev != null){
            toReturn = header.element;
            header = header.prev;
            size--;
        }else{
            toReturn = header.element;
            header = null;
            trailer = null;
            size--;
        }


        return toReturn;
    }

    @Override
    public T front() {
        try{
            return header.element;
        }catch(NullPointerException e){
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            try{
                dequeue();
            } catch(QueueErrors e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void show() {
        Node current = trailer;
        for(int i = 0; i < 4; i++){
            System.out.println("Elemento: " + current.element);
            System.out.println("atual: " + current);
            System.out.println("Prev: " + current.prev);
            System.out.println("Next: " + current.next);
            System.out.println("\n---------------------\n");

            current = current.next;
        }
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
