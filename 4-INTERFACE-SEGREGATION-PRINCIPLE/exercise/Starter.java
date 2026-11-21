// ISP Practice Exercise — starter code. Contractor is forced to fake paid
// leave and health insurance. Split Employee into focused interfaces instead.
// See README.md in this folder for the full task and requirements.

interface Payable {
    double calculateSalary();
}

interface PaidLeaveEligible  {
    void takePaidLeave(int days);
}

interface InsuranceEligible  {
    void enrollInHealthInsurance();
}

class Contractor implements Payable {
    public double calculateSalary() {
        return 5000.0; // flat contract rate
    }
}

class FullTimeEmployee implements Payable, PaidLeaveEligible, InsuranceEligible {
    @Override
    public double calculateSalary(){
        return 5000.00;
    }

    @Override
    public void takePaidLeave(int days){
        System.out.println("Paid leave: " + days + " days ");
    }

    @Override
    public void enrollInHealthInsurance(){
        System.out.println("Enrolled in health insurance");
    }

    
}

public class Starter {
    static void runPayroll(Payable worker){
        System.out.println(worker.calculateSalary());
    }
    public static void main(String[] args) {
        Payable contractor = new Contractor();
        FullTimeEmployee employee = new FullTimeEmployee();
       
        runPayroll(contractor);
        runPayroll(employee);

        employee.takePaidLeave(2);
        employee.enrollInHealthInsurance();
        
    }
}
