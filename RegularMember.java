/**
 * Represents a regular gym member.
 * Inherits from GymMember and includes additional features such as
 * plan upgrades, referral tracking, and eligibility based on attendance.
 * @ author Akriti Giri
 * @ version 0.1
 */
package AkritiGiri;


public class RegularMember extends GymMember {
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
        /**
     * Constructs a RegularMember with specific personal and referral details.
     *
     * @param id                   Unique ID of the member.
     * @param name                 Full name of the member.
     * @param location             Residential location.
     * @param phone                Phone number.
     * @param email                Email address.
     * @param gender               Gender of the member.
     * @param DOB                  Date of birth.
     * @param membershipStartDate Start date of the membership.
     * @param referralSource       Source through which the member was referred.
     */

    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
    }

        /**
     * Gets the referral source of the member.
     * @return The referral source.
     */
    public String getReferralSource() { return referralSource; }

    /**
     * Checks whether the member is eligible for an upgrade.
     * @return true if eligible, false otherwise.
     */
    public boolean getIsEligibleForUpgrade() { return isEligibleForUpgrade; }

    /**
     * Gets the current membership plan.
     * @return The name of the plan.
     */
    public String getPlan() { return plan; }

    /**
     * Gets the price of the current plan.
     * @return The plan price.
     */
    public double getPrice() { return price; }

    /**
     * Gets the reason for member removal, if any.
     * @return The removal reason.
     */
    public String getRemovalReason() { return removalReason; }

    /**
     * Marks attendance for the regular member.
     * Increments attendance and loyalty points.
     * If attendance reaches the limit, marks the member as eligible for upgrade.
     */
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
            if (attendance >= attendanceLimit) {
                isEligibleForUpgrade = true;
            }
        }
    }

    /**
     * Retrieves the price for a given plan.
     *
     * @param plan The name of the plan (basic, standard, deluxe).
     * @return The corresponding price, or -1 if the plan is invalid.
     */
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    /**
     * Upgrades the member's plan if eligible and the membership is active.
     *
     * @param plan The name of the new plan.
     * @return A message indicating success or reason for failure.
     */
    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) return "Not eligible for upgrade.";
        if (newPlan.equalsIgnoreCase(plan)) return "Already on this plan.";
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) return "Invalid plan.";
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " with price " + newPrice;
    }

    /**
     * Resets the member to the default regular state and stores the removal reason.
     *
     * @param removalReason The reason for removing the member.
     */
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    /**
     * Displays all details of the regular member including plan and removal reason.
     */
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}

