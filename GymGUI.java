/**
 * This class represents the graphical user interface (GUI) for the Gym Management System.
 * It allows users to manage gym members, including adding Regular and Premium members,
 * upgrading plans, calculating discounts, reverting plans, marking attendance, paying dues,
 * and displaying or clearing member information.
 * @author Akriti Giri
 * @version 0.1
 */

package AkritiGiri;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GymGUI {
    private JFrame frame;
    private JTextField idField, nameField, locationField, phoneField, emailField, dobField, startdateField, referralField, paidamountField, trainerField,removalreasonField,regularPriceField,premiumChargeField, discountAmountField;
    private JRadioButton malebutton, femalebutton;
    private JComboBox<String> planComboBox,startDayBox, startMonthBox, startYearBox, dobDayBox, dobMonthBox,dobYearBox;
    private JButton addRegularButton, addPremiumButton, activateButton, deactivateButton, markAttendanceButton, upgradeButton, discountButton, revertRegularButton, revertPremiumButton, payButton, displayButton, clearButton, saveButton, readButton;
    private JTextArea displayArea;
    private ArrayList<GymMember> Members;
    
/**
 * Constructs the GymGUI frame, initializes the GUI components,
 * sets up event listeners for all buttons, and configures the layout.
 * This is the main user interface for managing gym members.
 */  
    public GymGUI() {
        Members = new ArrayList<>();
        frame = new JFrame("Gym Management System");
        frame.setSize(950, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ID
        JLabel idLabel = new JLabel("ID: ");
        idLabel.setBounds(20,20,100,20);
        idField = new JTextField();
        idField.setBounds(250,20,250,20);
        frame.add(idLabel);
        frame.add(idField);

        // Name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(20,50,100,20);
        nameField = new JTextField();
        nameField.setBounds(250,50,250,20);
        frame.add(nameLabel);
        frame.add(nameField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(20,80,100,20);
        phoneField = new JTextField();
        phoneField.setBounds(250,80,250,20);
        frame.add(phoneLabel);
        frame.add(phoneField);
        
        // Location
        JLabel locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(20,110,100,20);
        locationField = new JTextField();
        locationField.setBounds(250,110,250,20);
        frame.add(locationLabel);
        frame.add(locationField);


        // DOB
        JLabel dobLabel = new JLabel("DOB: ");
        dobLabel.setBounds(20, 140, 100, 20);
        frame.add(dobLabel);
        dobDayBox = new JComboBox<>(generateDays());
        dobDayBox.setBounds(250, 140, 50, 20);
        frame.add(dobDayBox);
        dobMonthBox = new JComboBox<>(generateMonths());
        dobMonthBox.setBounds(320, 140, 50, 20);
        frame.add(dobMonthBox);
        dobYearBox = new JComboBox<>(generateYears());
        dobYearBox.setBounds(390, 140, 60, 20);
        frame.add(dobYearBox);

        // Start Date
        JLabel startDateLabel = new JLabel("Start Date:");
        startDateLabel.setBounds(20, 170, 100, 20);
        frame.add(startDateLabel);
        startDayBox = new JComboBox<>(generateDays());
        startDayBox.setBounds(250, 170, 50, 20);
        frame.add(startDayBox);
        startMonthBox = new JComboBox<>(generateMonths());
        startMonthBox.setBounds(320, 170, 50, 20);
        frame.add(startMonthBox);
        startYearBox = new JComboBox<>(generateYears());
        startYearBox.setBounds(390, 170, 60, 20);
        frame.add(startYearBox);
        
        // Email
        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(20,200,100,20);
        emailField = new JTextField();
        emailField.setBounds(250,200,250,20);
        frame.add(emailLabel);
        frame.add(emailField);

        // Gender
        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(20,230,100,20);
        frame.add(genderLabel);
        malebutton = new JRadioButton("Male");
        malebutton.setBounds(250,230,70,20);
        femalebutton = new JRadioButton("Female");
        femalebutton.setBounds(350,230,80,20);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(malebutton);
        genderGroup.add(femalebutton);
        frame.add(malebutton);
        frame.add(femalebutton);
        
        // Plan
        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(20, 260, 100, 20);
        frame.add(planLabel);
        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planComboBox.setBounds(250, 260, 250, 20);
        frame.add(planComboBox);

        // Referral
        JLabel referralLabel = new JLabel("Referral source: ");
        referralLabel.setBounds(20,300,100,20);
        referralField = new JTextField();
        referralField.setBounds(250,300,250,20);
        frame.add(referralLabel);
        frame.add(referralField);
        
        // Trainer
        JLabel trainerLabel = new JLabel("Trainer's Name: ");
        trainerLabel.setBounds(20,330,100,20);
        trainerField = new JTextField();
        trainerField.setBounds(250,330,250,20);
        frame.add(trainerLabel);
        frame.add(trainerField);
        
        // Removal reason
        JLabel removalreasonLabel = new JLabel("Removal Reason: ");
        removalreasonLabel.setBounds(20,360,200,20);
        removalreasonField = new JTextField();
        removalreasonField.setBounds(250,360,250,20);
        frame.add(removalreasonLabel);
        frame.add(removalreasonField);

        // Paid Amount
        JLabel paidamountLabel = new JLabel("Paid Amount: ");
        paidamountLabel.setBounds(20,390,100,20);
        paidamountField = new JTextField();
        paidamountField.setBounds(250,390,250,20);
        frame.add(paidamountLabel);
        frame.add(paidamountField);
        
        // Non-editable Regular Plan
        JLabel regularPriceLabel = new JLabel("Regular Plan Price:");
        regularPriceLabel.setBounds(20, 420, 150, 20);
        regularPriceField = new JTextField("1000");
        regularPriceField.setBounds(250, 420, 250, 20);
        regularPriceField.setEditable(false);
        frame.add(regularPriceLabel);
        frame.add(regularPriceField);

        // Non-editable Premium Plan
        JLabel premiumChargeLabel = new JLabel("Premium Plan Charge:");
        premiumChargeLabel.setBounds(20, 450, 150, 20);
        premiumChargeField = new JTextField("2000");
        premiumChargeField.setBounds(250, 450, 250, 20);
        premiumChargeField.setEditable(false);
        frame.add(premiumChargeLabel);
        frame.add(premiumChargeField);

        //Non-editable Discount  
        JLabel discountLabel = new JLabel("Discount Amount:");
        discountLabel.setBounds(20, 480, 150, 20);
        discountAmountField = new JTextField("100");
        discountAmountField.setBounds(250, 480, 250, 20);
        discountAmountField.setEditable(false);
        frame.add(discountLabel);
        frame.add(discountAmountField);
        
        // Buttons
        addRegularButton = new JButton("Add Regular Member");
        addRegularButton.setBounds(600, 10, 250, 30);
        frame.add(addRegularButton);
            addRegularButton.addActionListener(e -> {
    if (validateForm()) {
        String id = idField.getText();
        if (isDuplicateID(id)) {
            showError("Duplicate ID! Please enter a unique ID.");
            return;
        }
        Members.add(new GymMember(id, nameField.getText()));
        JOptionPane.showMessageDialog(frame, "Regular Member Added Successfully!");
    }
});

               
        
        addPremiumButton = new JButton("Add Premium Member");
        addPremiumButton.setBounds(600, 40, 250, 30);
        frame.add(addPremiumButton);
        addPremiumButton.addActionListener(e -> {
    if (validateForm()) {
        String id = idField.getText();
        if (isDuplicateID(id)) {
            showError("Duplicate ID! Please enter a unique ID.");
            return;
        }
        Members.add(new GymMember(id, nameField.getText()));
        JOptionPane.showMessageDialog(frame, "Premium Member Added Successfully!");
    }
});



        activateButton = new JButton("Activate Membership");
        activateButton.setBounds(600, 70, 250, 30);
        frame.add(activateButton);
        

        deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.setBounds(600, 100, 250, 30);
        frame.add(deactivateButton);

        markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(600, 130, 250, 30);
        frame.add(markAttendanceButton);
        markAttendanceButton.addActionListener(e -> {
            String inputId = JOptionPane.showInputDialog(frame, "Enter Member ID to mark attendance:");
            if (inputId != null && !inputId.isEmpty()) {
                boolean found = false;
                for (GymMember member : Members) {
                    if (member.getId().equals(inputId)) {
                        member.markAttendance();
                        JOptionPane.showMessageDialog(frame, "Attendance marked for " + member.getName());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Member with ID " + inputId + " not found.");
                }
            }
        });

        

        upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(600, 160, 250, 30);
        frame.add(upgradeButton);
        upgradeButton.addActionListener(e -> {
    // Read current plan selection
    String currentPlan = (String) planComboBox.getSelectedItem();
    String newPlan = null;
    double newPrice = 0;

    // Determine the next tier
    if ("Basic".equals(currentPlan)) {
        newPlan  = "Standard";
        newPrice = 12500;            // match your RegularMember.getPlanPrice("Standard")
    }
    else if ("Standard".equals(currentPlan)) {
        newPlan  = "Deluxe";
        newPrice = 18500;            // match your RegularMember.getPlanPrice("Deluxe")
    }
    else {
        // Already at top tier
        JOptionPane.showMessageDialog(frame,
            "You are already on the highest plan (" + currentPlan + ").",
            "Upgrade Not Available",
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Apply the upgrade in the UI
    planComboBox.setSelectedItem(newPlan);
    regularPriceField.setText(String.valueOf(newPrice));

    // Optionally, if you have a RegularMember object selected, update its internal state here
    // e.g. selectedMember.setPlan(newPlan); selectedMember.setPrice(newPrice);

    JOptionPane.showMessageDialog(frame,
        "Plan upgraded from " + currentPlan + " to " + newPlan + 
        " (Price: " + newPrice + ").",
        "Upgrade Successful",
        JOptionPane.INFORMATION_MESSAGE);
});


        discountButton = new JButton("Calculate Discount");
        discountButton.setBounds(600, 190, 250, 30);
        frame.add(discountButton);
        discountButton.addActionListener(e -> {
    try {
        double premiumCharge = Double.parseDouble(premiumChargeField.getText().trim());
        double paidSoFar    = Double.parseDouble(paidamountField.getText().trim());

        if (premiumCharge > 0 && paidSoFar >= premiumCharge) {
            double discount = premiumCharge * 0.10;
            discountAmountField.setText(String.format("%.2f", discount));
            JOptionPane.showMessageDialog(frame,
                String.format("Full payment detected. You receive a 10%% discount: %.2f", discount),
                "Discount Applied",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            discountAmountField.setText("0");
            JOptionPane.showMessageDialog(frame,
                "No discount available until you complete full payment.",
                "No Discount",
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame,
            "Please enter valid numeric values in Paid Amount and Premium Charge fields.",
            "Input Error",
            JOptionPane.ERROR_MESSAGE);
    }
});


        revertRegularButton = new JButton("Revert Regular");
        revertRegularButton.setBounds(600, 220, 250, 30);
        frame.add(revertRegularButton);
        revertRegularButton.addActionListener(e -> {
    String premiumCharge = premiumChargeField.getText();
    if (!"0".equals(premiumCharge) && !"".equals(premiumCharge)) {
        planComboBox.setSelectedItem("Basic");
        regularPriceField.setText("6500");    
        premiumChargeField.setText("0");      
        discountAmountField.setText("0");
        JOptionPane.showMessageDialog(frame,
            "Reverted from Premium back to Regular.",
            "Revert Successful",
            JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(frame,
            "You’re already on a Regular plan.",
            "No Action Taken",
            JOptionPane.INFORMATION_MESSAGE);
    }
});


        revertPremiumButton = new JButton("Revert Premium");
        revertPremiumButton.setBounds(600, 250, 250, 30);
        frame.add(revertPremiumButton);
        revertPremiumButton.addActionListener(e -> {
    if ("0".equals(premiumChargeField.getText().trim())) {
        premiumChargeField.setText("50000");      
        regularPriceField.setText("0");           
        discountAmountField.setText("0");         
        planComboBox.setSelectedIndex(0);       
        JOptionPane.showMessageDialog(frame,
            "Reverted from Regular to Premium.",
            "Revert to Premium",
            JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(frame,
            "You’re already on Premium membership.",
            "No Action Taken",
            JOptionPane.INFORMATION_MESSAGE);
    }
});

        

        payButton = new JButton("Pay Due Amount");
        payButton.setBounds(600, 280, 250, 30);
        frame.add(payButton);
        payButton.addActionListener(e -> {
    try {
        double paidSoFar = Double.parseDouble(paidamountField.getText().trim());
        
        double planTotal;
        String planType;
        if (premiumChargeField.getText().trim().equals("0")) {
            planTotal = Double.parseDouble(regularPriceField.getText().trim());
            planType  = "Regular";
        } else {
            planTotal = Double.parseDouble(premiumChargeField.getText().trim());
            planType  = "Premium";
        }
        
        double remaining = planTotal - paidSoFar;
        if (remaining < 0) {
            JOptionPane.showMessageDialog(frame,
                String.format("You have over‐paid by %.2f!", -remaining),
                "Payment Warning",
                JOptionPane.WARNING_MESSAGE);
        } else if (remaining == 0) {
            JOptionPane.showMessageDialog(frame,
                String.format("Thank you! Your %s plan is now 100%% paid.", planType),
                "Payment Complete",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame,
                String.format("On your %s plan (total: %.2f), you still owe: %.2f",
                              planType, planTotal, remaining),
                "Amount Due",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame,
            "Please enter a valid number in the Paid Amount field.",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE);
    }
});


        displayButton = new JButton("Display Members");
        displayButton.setBounds(600, 310, 250, 30);
        frame.add(displayButton);
        displayButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("ID\t\tName\t\tAttendance\n");
            sb.append("-------------------------------\n");
            for (GymMember member : Members) {
                sb.append(member.getId()).append("\t\t").append(member.getName()).append("\t\t")
                  .append(member.isPresent() ? "Present" : "Absent").append("\n");
            }
            displayArea.setText(sb.toString());
        });

        

        clearButton = new JButton("Clear Fields");
        clearButton.setBounds(600, 340, 250, 30);
        frame.add(clearButton);
        clearButton.addActionListener(e -> {
    // Reset each input:
    idField.setText("");
    nameField.setText("");
    locationField.setText("");
    phoneField.setText("");
    emailField.setText("");
    dobDayBox.setSelectedIndex(0);
    dobMonthBox.setSelectedIndex(0);
    dobYearBox.setSelectedIndex(0);
    startDayBox.setSelectedIndex(0);
    startMonthBox.setSelectedIndex(0);
    startYearBox.setSelectedIndex(0);

    referralField.setText("");
    paidamountField.setText("");
    removalreasonField.setText("");
    trainerField.setText("");
    planComboBox.setSelectedIndex(0);
    // if you have a JComboBox
    malebutton.setSelected(false);
    femalebutton.setSelected(false);
    regularPriceField.setText("0");  
    premiumChargeField.setText("0");
    // reset any labels
    discountAmountField.setText("0");
    displayArea.setText("");            

    JOptionPane.showMessageDialog(frame, "All fields cleared.");
});


        saveButton = new JButton("Save to File");
        saveButton.setBounds(600, 370, 250, 30);
        frame.add(saveButton);
         saveButton.addActionListener(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt"))) {
                for (GymMember member : Members) {
                    writer.write(member.getId() + "," + member.getName());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(frame, "File Saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file.");
            }
        });

        

        readButton = new JButton("Read from File");
        readButton.setBounds(600, 400, 250, 30);
        frame.add(readButton);
        readButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
                Members.clear();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        Members.add(new GymMember(parts[0], parts[1]));
                    }
                }
                JOptionPane.showMessageDialog(frame, "File Read successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error reading file.");
            }
        });


        
        displayArea = new JTextArea();
        displayArea.setBounds(20, 520, 1200, 500);
        frame.add(displayArea);

        frame.setVisible(true);
    }

/**
 * Validates all form input fields including ID, phone number, email, and gender selection.
 *
 * @return true if all fields are valid, false otherwise.
 */
    private boolean validateForm() {
        if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
            showError("Please enter a valid numeric ID.");
            return false;
        }
        if (nameField.getText().isEmpty()) {
            showError("Name cannot be empty.");
            return false;
        }
        if (!phoneField.getText().matches("\\d{10}")) {
            showError("Phone number must be 10 digits.");
            return false;
        }
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", emailField.getText())) {
            showError("Invalid email address.");
            return false;
        }
        if (!paidamountField.getText().matches("\\d+(\\.\\d{1,2})?")) {
            showError("Paid amount must be a valid number.");
            return false;
        }
        return true;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    
    private boolean isDuplicateID(String id) {
    for (GymMember member : Members) {
        if (member.getId().equals(id)) {
            return true;
        }
    }
    return false;
}

    
    private String[] generateDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }

    private String[] generateMonths() {
        return new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

    private String[] generateYears() {
        String[] years = new String[50];
        for (int i = 0; i < 50; i++) {
            years[i] = String.valueOf(1975 + i);
        }
        return years;
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}

class GymMember {
    private String id;
    private String name;
    private boolean isPresent;

    public GymMember(String id, String name) {
        this.id = id;
        this.name = name;
        this.isPresent = false;
    }

/**
 * Unique ID for specific member 
 */
    public String getId() {
        return id;
    }

/**
 * Name of the activated member is restored
 */
    public String getName() {
        return name;
    }

/**
 * Marks attendance for the selected member by ID.
 */
    public void markAttendance() {
        this.isPresent = true;
    }

    public boolean isPresent() {
        return isPresent;
    }
}