// DependencyInjectionTest.java
public class DependencyInjectionTest {
    public static void main(String[] args) {

        // Inject the concrete repository into the service
        CustomerRepository repo    = new CustomerRepositoryImpl();
        CustomerService    service = new CustomerService(repo);

        System.out.println(service.getCustomer(1));
        System.out.println(service.getCustomer(2));
        System.out.println(service.getCustomer(99));
    }
}
