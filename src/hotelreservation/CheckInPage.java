
package hotelreservation;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CheckInPage extends javax.swing.JFrame {
    private Timer debounceTimer;
    private boolean capitalizeNext = false;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";
    
    public CheckInPage() {
        initComponents();

        jTimeCheckOut.setEditable(false);
        
        jCalendar.addPropertyChangeListener("calendar", e -> updateCheckOut());
        jTime.addActionListener(e -> updateCheckOut());
        jStay.addActionListener(e -> updateCheckOut());
        
        jContact.setText("+63 ");
        
        jContact.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int caretPosition = jContact.getCaretPosition();
                
                // Prevent editing of the +63 prefix
                if (caretPosition < 3) {
                    e.consume();
                    return;
                }
                
                // Get the current text excluding the prefix
                String currentText = jContact.getText().substring(3);
                
                // Allow only digits and limit input length to 10 digits
                if (!Character.isDigit(e.getKeyChar()) || currentText.length() >= 11) {
                    e.consume(); // Ignore the input
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                int caretPosition = jContact.getCaretPosition();
                
                // Prevent moving the caret to the left of the +63 prefix
                if (caretPosition < 5 && (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        
        
        jName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                debounceCapitalization();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                debounceCapitalization();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                debounceCapitalization();
            }
        });
        
        jName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    capitalizeNext = true;
                }
            }
        });
    }
    
    private void updateCheckOut() {
    Date checkInDate = jCalendar.getDate();
    String checkInHourStr = (String) jTime.getSelectedItem();
    String stayDaysStr = (String) jStay.getSelectedItem();

    // Extract hour from the time string (e.g., "1:00" -> 1)
    int checkInHour = Integer.parseInt(checkInHourStr.split(":")[0]);
    int stayDays = Integer.parseInt(stayDaysStr);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(checkInDate);
    calendar.set(Calendar.HOUR_OF_DAY, checkInHour);
    calendar.add(Calendar.DAY_OF_MONTH, stayDays);

    // Using "MMMM d, yyyy / HH:mm" for textual month format
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy / HH:mm");
    String checkOutDate = dateFormat.format(calendar.getTime());
    jTimeCheckOut.setText(checkOutDate);
    
    getHoursArrayWithColon();
    getDaysArrayAsString();
}

    private String[] getHoursArrayWithColon() {
    String[] hours = new String[24];
    for (int i = 0; i < 24; i++) {
        hours[i] = (i + 1) + ":00"; // Adding the colon and minutes
    }
    return hours;
}

    private String[] getDaysArrayAsString() {
    String[] days = new String[31];
    for (int i = 0; i < 31; i++) {
        days[i] = String.valueOf(i + 1);
    }
    return days;
}
    
    private void debounceCapitalization() {
    if (debounceTimer != null) {
        debounceTimer.cancel();
    }
    debounceTimer = new Timer();
    debounceTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            SwingUtilities.invokeLater(() -> {
                String name = jName.getText();
                if (!name.isEmpty()) {
                    int pos = jName.getCaretPosition();
                    String capitalized = capitalizeNameWords(name);
                    jName.setText(capitalized);
                    jName.setCaretPosition(Math.min(pos, capitalized.length()));
                }
            });
        }
    }, 300); // 300ms debounce delay
}
        
    public String capitalizeName(String name) {
    if (name == null || name.isEmpty()) {
        return name;
    }
    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
}
    
    public String capitalizeNameWords(String name) {
    StringBuilder capitalized = new StringBuilder();
    boolean capitalize = true;
    for (char c : name.toCharArray()) {
        if (capitalize && Character.isLetter(c)) {
            capitalized.append(Character.toUpperCase(c));
            capitalize = false;
        } else {
            capitalized.append(Character.toLowerCase(c));
        }
        if (c == ' ') {
            capitalize = true;
        }
    }
    return capitalized.toString();
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(25, Color.WHITE);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jContact = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTimeCheckOut = new javax.swing.JTextField();
        jID = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTime = new javax.swing.JComboBox<>();
        jCalendar = new com.toedter.calendar.JDateChooser();
        jStay = new javax.swing.JComboBox<>();
        button1 = new hotelreservation.Button();
        dashboard1 = new hotelreservation.Dashboard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 800));
        jPanel1.setRequestFocusEnabled(false);

        jPanel3.setBackground(new java.awt.Color(55, 81, 107));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LOGO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(513, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(417, 417, 417))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 81, 107));
        jLabel1.setText("Check In");

        jLabel3.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jName.setBackground(new java.awt.Color(246, 246, 246));
        jName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel4.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel4.setText("Contact Number");

        jContact.setBackground(new java.awt.Color(246, 246, 246));
        jContact.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel11.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel11.setText("Date of Check in");

        jLabel13.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel13.setText("Email");

        jEmail.setBackground(new java.awt.Color(246, 246, 246));
        jEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));

        jLabel14.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel14.setText("Proof of Identification (ID Type)");

        jLabel15.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel15.setText("Days of Stay");

        jLabel16.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel16.setText("Date and Time of Check Out");

        jTimeCheckOut.setBackground(new java.awt.Color(246, 246, 246));
        jTimeCheckOut.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        jTimeCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimeCheckOutActionPerformed(evt);
            }
        });

        jID.setBackground(new java.awt.Color(246, 246, 246));
        jID.setFont(new java.awt.Font("Kannada MN", 0, 15)); // NOI18N
        jID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select an ID Type -", "Voter's ID", "Driver's License", "Philippine National ID", "SSS ID", "Pag-Ibig ID", "TIN ID", "PhilHealth ID" }));
        jID.setBorder(null);
        jID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel17.setText("Time of Check in");

        jTime.setBackground(new java.awt.Color(246, 246, 246));
        jTime.setFont(new java.awt.Font("Kannada MN", 0, 15)); // NOI18N
        jTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Time of Check In -", "1:00 ", "2:00 ", "3:00 ", "4:00 ", "5:00 ", "6:00 ", "7:00 ", "8:00 ", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00", " " }));
        jTime.setBorder(null);
        jTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimeActionPerformed(evt);
            }
        });

        jCalendar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jStay.setBackground(new java.awt.Color(246, 246, 246));
        jStay.setFont(new java.awt.Font("Kannada MN", 0, 15)); // NOI18N
        jStay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select Days of Stay -", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jStay.setBorder(null);
        jStay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStayActionPerformed(evt);
            }
        });

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Proceed");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button1.setRadius(25);
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jName)
                            .addComponent(jContact)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jEmail)
                            .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17)
                        .addComponent(jTime, 0, 337, Short.MAX_VALUE)
                        .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jStay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTimeCheckOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jContact, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTime, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTimeCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String validateContact(String contact) {
    String digitsOnly = contact.substring(3); // Exclude +63 prefix
    if (digitsOnly.length() == 11) {
        return contact;
    } else {
        return "Invalid Number";
    }
}
    
    public String validateEmail(String email) {
        if (email.endsWith("@gmail.com")) {
            return email;
        } else {
            return "Invalid Email";
        }
    }
    
    public String validateIDType(String idType) {
        if ("- Select an ID Type -".equals(idType)) {
            return "Please Select a valid ID Type";
        } else {
            return idType;
        }
    }
    
    private void jIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDActionPerformed

    private void jTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTimeActionPerformed

    private void jTimeCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimeCheckOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTimeCheckOutActionPerformed

    private void jStayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jStayActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    boolean isValid = true;

    //Check if text field is empty for NAME
    if (jName.getText().isEmpty()) {
        isValid = false;
    }

    //Check if text field is empty for CONTACT NO.
    if (jContact.getText().isEmpty()) {
        isValid = false;
    }

    //Check if text field is empty for EMAIL
    if (jEmail.getText().isEmpty()) {
        isValid = false;
    }

    //Check if option is picked for ID Type
    if (jID.getSelectedIndex() == 0) {
        isValid = false;
    }

    //Check if option is picked for No. of days of stay
    if (jTime.getSelectedIndex() == 0) {
        isValid = false;
    }

    // Check if a date is picked for check in
    if (jCalendar.getDate() == null) {
        isValid = false;
    }

    //Check if text field is empty for CHECK IN TIME
    if (jTimeCheckOut.getText().isEmpty()) {
        isValid = false;
    }

    if (!isValid) {
        JOptionPane.showMessageDialog(null, "Please fill out all fields.");
    } 

 
    String name = jName.getText();
    String contact = jContact.getText();
    String email = jEmail.getText();
    String proofOfID = (String) jID.getSelectedItem();
    Date dateOfCheckIn = jCalendar.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateOfCheckInStr = dateFormat.format(dateOfCheckIn);
    int month = dateOfCheckIn.getMonth() + 1;
    int day = dateOfCheckIn.getDate();
    String timeOfCheckIn = (String) jTime.getSelectedItem();
    String daysOfStay = (String) jStay.getSelectedItem();
    String dateTimeOfCheckOut = (String) jTimeCheckOut.getText();
            
    StringBuilder errors = new StringBuilder();

    String monthString = "";
        switch (month) {
            case 1:  monthString = "January"; break;
            case 2:  monthString = "February"; break;
            case 3:  monthString = "March"; break;
            case 4:  monthString = "April"; break;
            case 5:  monthString = "May"; break;
            case 6:  monthString = "June"; break;
            case 7:  monthString = "July"; break;
            case 8:  monthString = "August"; break;
            case 9:  monthString = "September"; break;
            case 10: monthString = "October"; break;
            case 11: monthString = "November"; break;
            case 12: monthString = "December"; break;
        }
        
    // Validate Name
    if (name.trim().isEmpty()) {
        errors.append("Name cannot be empty.\n");
    } else if (!name.matches("^[a-zA-Z ]+$")) {
        errors.append("Name can only contain letters and spaces.\n");
    }

    // Validate Contact
    String validatedContact = validateContact(contact);
    if (validatedContact.equals("Invalid Number")) {
        errors.append("Contact number must be exactly 10 digits.\n");
    }

    // Validate Email
    String validatedEmail = validateEmail(email);
    if (validatedEmail.equals("Invalid Email")) {
        errors.append("Email must end with @gmail.com.\n");
    }

    // Validate Proof of ID
    if (proofOfID.equals("- Select an ID Type -")) {
        errors.append("Please select a valid Proof of ID.\n");
    }

    // Check if there are any errors
    if (errors.length() > 0) {
        // Show error messages and prevent navigation
        JOptionPane.showMessageDialog(this, errors.toString(), "Validation Errors", JOptionPane.ERROR_MESSAGE);
    } else {
        // Proceed to the next page or handle the validated input
        JOptionPane.showMessageDialog(this, "Name: " + name + "\nContact: " + validatedContact + "\nEmail: " + validatedEmail + "\nProof of ID: " + proofOfID + "\nDate of Check in: " + monthString + " " + day + "\nTime of Check in: " + timeOfCheckIn + "\nDays of Stay: " + daysOfStay);
        
    }
    try {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "INSERT INTO guestdb (Name, Contact, Email, IDType, DaysOfStay, DateOfCheckIn, TimeOfCheckIn, DateTimeOfCheckOut) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contact);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, proofOfID);
            preparedStatement.setString(5, daysOfStay);
            preparedStatement.setString(6, dateOfCheckInStr);
            preparedStatement.setString(7, timeOfCheckIn);
            preparedStatement.setString(8, dateTimeOfCheckOut);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Check-In successful!");
        }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: Check-In failed.");
}
    
    AvailableRoomPage x = new AvailableRoomPage();
    String selectedDays = (String) CheckInPage.jStay.getSelectedItem();
    x.jDayStay.setText(selectedDays);
    x.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        
    }//GEN-LAST:event_button1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hotelreservation.Button button1;
    private hotelreservation.Dashboard dashboard1;
    private com.toedter.calendar.JDateChooser jCalendar;
    private javax.swing.JTextField jContact;
    private javax.swing.JTextField jEmail;
    private javax.swing.JComboBox<String> jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JComboBox<String> jStay;
    private javax.swing.JComboBox<String> jTime;
    private javax.swing.JTextField jTimeCheckOut;
    // End of variables declaration//GEN-END:variables

class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }

            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        }
    }
}

