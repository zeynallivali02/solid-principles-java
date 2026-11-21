// OCP Practice Exercise — starter code. Refactor this so adding a new
// customer tier never requires editing DiscountCalculator again.
// See README.md in this folder for the full task and requirements.

 interface DiscountMethod{
    double getDiscount();
 }

 class Regular implements DiscountMethod {
    @Override
    public double getDiscount(){
        System.out.println("regular");
        return 0.0;
    }
 }

 class Premium implements DiscountMethod {
     @Override
    public double getDiscount(){
        System.out.println("premium");
        return 0.0;
    }
 }

 class Vip implements DiscountMethod {
     @Override
    public double getDiscount(){
        System.out.println("vip");
        return 0.0;
    }
 }

 class DiscountCalculator {
    public double calculate(double amount,DiscountMethod discount){
        return amount - amount * discount.getDiscount();
    }
 }

public class Starter {
    public static void main(String[] args) {
    DiscountCalculator calculator = new DiscountCalculator();

        double amount = 200.0;

        double regular = calculator.calculate(amount, new Regular());
        double premium = calculator.calculate(amount, new Premium());
        double vip = calculator.calculate(amount, new Vip());
       

        System.out.println("Regular pays: " + regular);
        System.out.println("Premium pays: " + premium);
        System.out.println("VIP pays: " + vip);
       
    

        // Marketing just asked for a "student" tier at 15% off.
        // Can you add it without touching DiscountCalculator?
    }
}
