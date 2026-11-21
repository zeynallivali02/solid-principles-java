// DIP Practice Exercise — starter code. OrderProcessor constructs its own
// MySQLDatabase, so swapping storage (or testing without a real DB) means
// editing OrderProcessor itself. See README.md in this folder for the full
// task and requirements.
import java.util.ArrayList;
import java.util.List;

interface OrderRepository {
    void save(String order);
}

class MySQLOrderRepository implements OrderRepository{
    @Override
    public void save(String order){
        System.out.println("Saving order to MySQL: " + order);
    }
}

class MySQLDatabase {
    public void save(String order) {
        System.out.println("Saving order to MySQL: " + order);
    }
}

class MongoOrderRepository implements OrderRepository {
    @Override
    public void save(String order){
        System.out.println("Saving order to MongoDB:" + order);
    }
}

class InMemoryOrderRepository implements OrderRepository {
    private List<String> orders = new ArrayList<>();

    @Override
    public void save(String order){
        orders.add(order);
    }

    public List<String> getOrders(){
        return orders;
    }
}

class OrderProcessor {
   private OrderRepository repository;

   OrderProcessor (OrderRepository repository){
    this.repository = repository;
   }

   public void process(String order) {
    System.out.println("Processing order: " + order);
    repository.save(order);
   }
    
}

public class Starter {
   public static void main(String[] args) {

    InMemoryOrderRepository memory = new InMemoryOrderRepository();

    OrderProcessor processor = new OrderProcessor(memory);

    processor.process(1001);

    System.out.println(memory.getOrders());

    // İndi MySQL ilə ikinci sifarişi emal et

    MySQLDatabase processor1 = new MySQLDatabase(memory);

    processor1.process(2002);
    System.out.println(memory.getOrders());

}
}
