package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

public class CustomerManagementSystem {
    private List<Customer> customers;

    public CustomerManagementSystem() {
        customers = new ArrayList<>();
    }

    public void addCustomer(int id, String name, String email) {
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    public void removeCustomer(int id) {
        Customer customerToRemove = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customerToRemove = customer;
                break;
            }
        }
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Customer removed: " + customerToRemove);
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    public Customer searchCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        System.out.println("Customer with ID " + id + " not found.");
        return null;
    }

    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers in the list.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void sortCustomersByName() {
        Collections.sort(customers, Comparator.comparing(Customer::getName));
        System.out.println("Customers sorted by name.");
    }

    public void sortCustomersById() {
        Collections.sort(customers, Comparator.comparingInt(Customer::getId));
        System.out.println("Customers sorted by ID.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagementSystem cms = new CustomerManagementSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCustomer Management System:");
            System.out.println("1. Add a Customer");
            System.out.println("2. Remove a Customer");
            System.out.println("3. Search for a Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    cms.addCustomer(id, name, email);
                    break;

                case 2:
                    System.out.print("Enter Customer ID to Remove: ");
                    int removeId = scanner.nextInt();
                    cms.removeCustomer(removeId);
                    break;

                case 3:
                    System.out.print("Enter Customer ID to Search: ");
                    int searchId = scanner.nextInt();
                    Customer customer = cms.searchCustomer(searchId);
                    if (customer != null) {
                        System.out.println("Found: " + customer);
                    }
                    break;

                case 4:
                    System.out.println("Listing all customers:");
                    cms.listAllCustomers();
                    break;

                case 5:
                    System.out.println("Sorting customers by name:");
                    cms.sortCustomersByName();
                    cms.listAllCustomers();
                    break;

                case 6:
                    System.out.println("Sorting customers by ID:");
                    cms.sortCustomersById();
                    cms.listAllCustomers();
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
