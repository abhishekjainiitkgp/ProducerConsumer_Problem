public class ProducerConsumer_Learning {
    public static void main(String[] args) {
        SharedResource sharedBuffer= new SharedResource(3);
        //creating producer thread using lambda expression
        Thread producerThread = new Thread(()->{
            try{
                for(int i=1;i<=6;i++){
                    sharedBuffer.produce(i);
                }
            }catch (Exception e){
                //handle exception here;
            }
        });
        Thread consumerThread= new Thread(()->{
            try{
                for(int i=1;i<=6;i++){
                    sharedBuffer.consume();
                }
            }catch (Exception e){
                //handle exception here;
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
