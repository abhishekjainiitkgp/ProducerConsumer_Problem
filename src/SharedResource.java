import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        sharedBuffer= new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception{
        //if buffer size is full, then producer has to wait for consumer to consume items
        while(sharedBuffer.size()==bufferSize){
            System.out.println("Buffer is full, Producer is waiting for consumer");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced: "+ item);
        //notify the consumer that there are items to consume now
        notify();
    }

    public synchronized int consume()throws Exception{
        //Buffer is empty, waiting for producer to produce items
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, waiting for producer to produce item");
            wait();
        }
        int item=sharedBuffer.poll();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}
