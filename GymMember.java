/**
 * An abstract class representing a generic gym member.
 * Stores common member information such as ID, name, contact details,
 * attendance records, loyalty points, and membership status.
 * @ author Akriti Giri
 * @ verision 0.1
 */
package AkritiGiri;


public abstract class GymMember {
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    /**
     * Constructs a GymMember with all required personal and membership details.
     *
     * @param id                   The unique ID of the member.
     * @param name                 The full name of the member.
     * @param location             The member's residential location.
     * @param phone                The member's phone number.
     * @param email                The member's email address.
     * @param gender               The member's gender.
     * @param DOB                  The member's date of birth.
     * @param membershipStartDate The start date of the member's gym subscription.
     */

    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

        /**
     * Gets the member's unique ID.
     * @return The member ID.
     */
    public int getId() { return id; }

    /**
     * Gets the name of the member.
     * @return The member's name.
     */
    public String getName() { return name; }

    /**
     * Gets the location of the member.
     * @return The member's location.
     */
    public String getLocation() { return location; }

    /**
     * Gets the member's phone number.
     * @return The phone number.
     */
    public String getPhone() { return phone; }

    /**
     * Gets the email address of the member.
     * @return The email.
     */
    public String getEmail() { return email; }

    /**
     * Gets the gender of the member.
     * @return The gender.
     */
    public String getGender() { return gender; }

    /**
     * Gets the member's date of birth.
     * @return The date of birth.
     */
    public String getDOB() { return DOB; }

    /**
     * Gets the membership start date.
     * @return The membership start date.
     */
    public String getMembershipStartDate() { return membershipStartDate; }

    /**
     * Gets the number of times the member has attended the gym.
     * @return The attendance count.
     */
    public int getAttendance() { return attendance; }

    /**
     * Gets the total loyalty points earned by the member.
     * @return The loyalty points.
     */
    public double getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Gets the current active status of the membership.
     * @return true if membership is active, false otherwise.
     */
    public boolean getActiveStatus() { return activeStatus; }

     /**
     * Activates the gym membership by setting activeStatus to true.
     */
    public void activateMembership() {
        this.activeStatus = true;
    }

    /**
     * Deactivates the gym membership by setting activeStatus to false.
     */
    public void deactivateMembership() {
        if (this.activeStatus) {
            this.activeStatus = false;
        }
    }

    /**
     * Resets the member's status by clearing attendance and loyalty points
     * and deactivating the membership.
     */
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
    }

     /**
     * Abstract method to be implemented by subclasses to define
     * how attendance is marked and how loyalty points are awarded.
     */
    public abstract void markAttendance();

     /**
     * Displays all member details including contact info, attendance,
     * loyalty points, and membership status.
     */
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}
