// CustomerRepository.java  (Repository Interface)
public interface CustomerRepository {
    String findCustomerById(int id);
}

// ── Concrete Repository ──────────────────────────────────────────────────
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a database lookup
        if (id == 1) return "Alice (ID: 1)";
        if (id == 2) return "Bob (ID: 2)";
        return "Customer not found (ID: " + id + ")";
    }
}

// ── Service Class ────────────────────────────────────────────────────────
class CustomerService {
    private CustomerRepository repository;   // depends on the interface

    // Constructor Injection — dependency supplied from outside
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomer(int id) {
        return repository.findCustomerById(id);
    }
}
