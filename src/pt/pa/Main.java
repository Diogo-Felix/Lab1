package pt.pa;

import pt.pa.adts.Queue;
import pt.pa.adts.QueueErrors;
import pt.pa.adts.QueueLinkedList;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new QueueLinkedList<>();

        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);


        //queue.show();

        for(int i = 0; i < 4; i++) {
            try {
                System.out.println("elemento: " + queue.dequeue());
            }
            catch(QueueErrors e){
                System.out.println(e.getMessage());
            }

        }
        //TODO: testar implementação

    }
}
