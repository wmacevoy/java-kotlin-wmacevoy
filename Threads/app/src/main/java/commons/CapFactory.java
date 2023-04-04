package commons;

import java.util.HashSet;
import java.util.Set;

class OrderCollector extends Thread {
    private String name;
    OrderCollector(String name) { this.name = name ; }
    // @Override
    public void run() {
        System.out.println("OrderCollector " + name + " running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("OrderCollector " + name + " done.");
    }
}
public class CapFactory {
    Set<OrderCollector> orderCollectorSet = new HashSet<>();
    void makeOrderCollector(String name) {
        OrderCollector collector = new OrderCollector(name);
        collector.start();
        orderCollectorSet.add(collector);
    }

    // this is the main entry point for a standard java desktop application.
    // to use this in android studio, you have to modify the gradle.xml file in the .idea directory
    // as in https://github.com/wmacevoy/java-kotlin-wmacevoy/blob/main/Threads/idea/gradle.xml
    //
    // Then create a new run configuration: Application, JDK 11, commons.CapFactory main, class
    // path of Threads.main this should be enough to run this application as a desktop command line
    // application.
    public static void main(String[] args) {
        CapFactory factory = new CapFactory();
        factory.run();
    }

    void run() {
        makeOrderCollector("alice");
        makeOrderCollector("henry");
        makeOrderCollector("bob");
    }
}
