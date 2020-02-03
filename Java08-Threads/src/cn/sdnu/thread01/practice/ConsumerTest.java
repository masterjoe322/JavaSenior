package cn.sdnu.thread01.practice;

/**
 * Customers buy products<br>
 * Producers create products <br>
 * Clerks cell products <br>
 * When the products are sold out, clerks tell the customers that there is no product
 *
 * @author Master_Joe qiaoguangtong@aliyun.com
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        String hello = "Hello";
        System.out.println(hello);

        Producer producer = new Producer(clerk);
        producer.setName("Producer ");
        System.out.println("Producer start");
        producer.start();

        Consumer consumer = new Consumer(clerk);
        consumer.setName("Consumer1 ");
        System.out.println("Consumer1 start");
        consumer.start();

        Consumer consumer2 = new Consumer(clerk);
        consumer2.setName("Consumer2 ");
        consumer2.start();

    }
}

class Clerk {
    /**
     * The number of the products, in this procedure, this is the shared data, it should be synchronized
     */
    private int productNumber = 0;

    /**
     * For our this only one clerk, this is the shared data, it also should be synchronized
     * We produce products only when the number is less than 20
     */
    public synchronized void produceProducts() {
        if (productNumber < 20) {
            productNumber++;
            System.out.println(Thread.currentThread().getName() + ": Producing the " + productNumber + "th product");
            notify();
        } else {
            try {
                // if there are enough product, wait for selling.
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Clerk is the shared data, selling products should be synchronized
     */
    public synchronized void sellProducts() {
        if (productNumber > 0) {
            // if we sell some products, we should call producer should produce the products
            notify();
            System.out.println(Thread.currentThread().getName() + ": Selling the " + productNumber + "th product");
            productNumber--;
        } else {
            try {
                // if there is no product, we will wait the producer to produce the products
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    /**
     * Shared clerk
     */
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sellProducts();
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;


    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProducts();
        }
    }
}
