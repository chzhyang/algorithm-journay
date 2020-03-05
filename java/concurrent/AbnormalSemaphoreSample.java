import java.util.concurrent.Semaphore;
public class AbnormalSemaphoreSample
{
    public static void main(String[] args) throws InterruptedException
    {
		Semaphore semaphore = new Semaphore(0);
        
       // Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++)
        {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
		System.out.println("Action...GO!");
		semaphore.release(5);
		System.out.println("Wait for permits off!");
		while(semaphore.availablePermits()!=0){
			Thread.sleep(100L);
		}
		System.out.println("Action...GO...Again!");
		semaphore.release(5);
    }
}
class SemaphoreWorker implements Runnable
{
    private String name;
    private Semaphore semaphore;
    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
	public void run()
    {
        try {
            log("is waiting for a permit!");
            semaphore.acquire();
            log("acquired a permit!");
            //log("executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }/* finally {
            log("released a permit!");
            semaphore.release();
        }*/
    }
    private void log(String msg){
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}