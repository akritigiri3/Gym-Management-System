/**
 * Represents a premium member of the gym who has additional benefits such as a personal trainer,
 * the ability to make full payments, and receive discounts.
 * Inherits from the GymMember class.
 * @ author Akriti Giri
 * @version 0.1
 */
package AkritiGiri;


public class PremiumMember extends GymMember {
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
       /**
     * Constructs a PremiumMember with the given details and initializes payment and discount status.
     *
     * @param id                    The unique member ID.
     * @param name                  The member's name.
     * @param location              The member's location.
     * @param phone                 The member's phone number.
     * @param email                 The member's email address.
     * @param gender                The member's gender.
     * @param DOB                   The member's date of birth.
     * @param membershipStartDate  The date the membership started.
     * @param personalTrainer       The name of the assigned personal trainer.
     */

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.paidAmount = 0;
        this.isFullPayment = false;
        this.discountAmount = 0;
    }

    public double getPremiumCharge() { return premiumCharge; }
    
     /**
     * Gets the name of the assigned personal trainer.
     * @return The personal trainer's name.
     */
    public String getPersonalTrainer() { return personalTrainer; }

    /**
     * Checks whether the full payment has been completed.
     * @return true if full payment is made; false otherwise.
     */
    public boolean getIsFullPayment() { return isFullPayment; }

    /**
     * Returns the total amount paid by the member so far.
     * @return The paid amount.
     */
    public double getPaidAmount() { return paidAmount; }

    /**
     * Returns the discount amount applied (if any).
     * @return The discount amount.
     */
    public double getDiscountAmount() { return discountAmount; }

    /**
     * Marks attendance for the premium member if the membership is active.
     * Adds loyalty points for each attendance.
     */
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
        }
    }

    /**
     * Allows the member to pay a due amount toward the premium charge.
     * Validates the amount and updates the payment status.
     *
     * @param amount The amount to be paid.
     * @return A message indicating the result of the payment.
     */
    public String payDueAmount(double amount) {
        if (isFullPayment) return "Payment already complete.";
        if (paidAmount + amount > premiumCharge) return "Amount exceeds total charge.";
        paidAmount += amount;
        if (paidAmount == premiumCharge) isFullPayment = true;
        double remaining = premiumCharge - paidAmount;
        return "Payment received. Remaining: " + remaining;
    }

    /**
     * Calculates and applies a 10% discount if the member has completed full payment.
     *
     * @return A message indicating whether the discount is applied or not.
     */
    public String calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.1 * premiumCharge;
            return "Discount applied: " + discountAmount;
        } else {
            return "No discount. Payment not complete.";
        }
    }

    /**
     * Reverts a premium member to a default or initial state.
     * Resets payment, discount, and trainer information.
     */
    public void revertPremiumMember() {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /**
     * Displays the premium member's details including payment and discount information.
     */
    public void display() {
        super.display();
        System.out.println("Trainer: " + personalTrainer);
        System.out.println("Paid: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        System.out.println("Remaining: " + (premiumCharge - paidAmount));
        if (isFullPayment) {
            System.out.println("Discount: " + discountAmount);
        }
    }
}
