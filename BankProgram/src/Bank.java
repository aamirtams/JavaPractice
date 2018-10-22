import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, Double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, Double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (int i = 0; i<this.branches.size(); i++){
            Branch existingBranch = this.branches.get(i);
            if (existingBranch.getName().equals(branchName)){
                return existingBranch;
            }
        }
        return null;
    }

    public boolean listOfCustomers(String branchName, boolean showTransaction){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branch.getCustomers().get(i);
                System.out.println("Customer : " + branchCustomer.getName() + " [" + (i+1) + "]");
                if (showTransaction){
                    ArrayList<Double> customerTransaction = branchCustomer.getTransaction();
                    for (int j = 0; j < customerTransaction.size(); j++){
                        System.out.println("[" + (j+1) + "]" + customerTransaction.get(j));
                    }
                }
                System.out.println();
            }
            return true;
        }else {
            return false;
        }

    }
}
