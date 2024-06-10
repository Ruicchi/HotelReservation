package hotelreservation;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegisterPage extends javax.swing.JFrame {
    
    public RegisterPage() {
        initComponents();
        // Set initial focus to the SignInBtn button
        this.getRootPane().setDefaultButton(RegisterBtn);
        RegisterBtn.requestFocusInWindow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        EmployeeId = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Subtext = new javax.swing.JLabel();
        CreateAcc = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        ConfirmPassword = new javax.swing.JPasswordField();
        RegisterBtn = new hotelreservation.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        EmployeeId.setBackground(new java.awt.Color(246, 246, 246));
        EmployeeId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        EmployeeId.setForeground(new java.awt.Color(102, 102, 102));
        EmployeeId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        EmployeeId.setText("Employee ID");
        EmployeeId.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        EmployeeId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmployeeIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmployeeIdFocusLost(evt);
            }
        });

        Name.setBackground(new java.awt.Color(246, 246, 246));
        Name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Name.setForeground(new java.awt.Color(102, 102, 102));
        Name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Name.setText("Username");
        Name.setToolTipText("");
        Name.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFocusLost(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Subtext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Subtext.setForeground(new java.awt.Color(102, 102, 102));
        Subtext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Subtext.setText("Start your journey with Hotel Callé!");

        CreateAcc.setFont(new java.awt.Font("Malayalam MN", 1, 60)); // NOI18N
        CreateAcc.setForeground(new java.awt.Color(55, 81, 107));
        CreateAcc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateAcc.setText("Create Account");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HALF.png"))); // NOI18N

        Password.setBackground(new java.awt.Color(246, 246, 246));
        Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Password.setForeground(new java.awt.Color(102, 102, 102));
        Password.setText("Password");
        Password.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        Password.setEchoChar('\u0000');
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        ConfirmPassword.setBackground(new java.awt.Color(246, 246, 246));
        ConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ConfirmPassword.setForeground(new java.awt.Color(102, 102, 102));
        ConfirmPassword.setText("Confirm Password");
        ConfirmPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        ConfirmPassword.setEchoChar('\u0000');
        ConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ConfirmPasswordFocusLost(evt);
            }
        });
        ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordActionPerformed(evt);
            }
        });

        RegisterBtn.setForeground(new java.awt.Color(255, 255, 255));
        RegisterBtn.setText("Sign me up!");
        RegisterBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        RegisterBtn.setRadius(20);
        RegisterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(Subtext, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(EmployeeId, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(Password)
                            .addComponent(ConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(CreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(RegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Subtext)
                .addGap(50, 50, 50)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(EmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(RegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private boolean isValidPassword(String password) {
    if (password.length() < 5) {
        return false;
    }
    boolean hasLetter = false;
    boolean hasNumber = false;
    for (char c : password.toCharArray()) {
        if (Character.isLetter(c)) {
            hasLetter = true;
        } else if (Character.isDigit(c)) {
            hasNumber = true;
        } else {
            return false; // Contains a special character
        }
    }
    return hasLetter && hasNumber;
}
    
    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusGained
    if(Name.getText().equals("Username"))
        {
            Name.setText("");
            Name.setForeground(new Color(102,102,102));
            
        }    
    }//GEN-LAST:event_NameFocusGained

    private void NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusLost
        if(Name.getText().equals(""))
        {
            Name.setText("Username");
            Name.setForeground(new Color(102,102,102));
            
        }
    }//GEN-LAST:event_NameFocusLost

    private void EmployeeIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeIdFocusGained
            if(EmployeeId.getText().equals("Employee ID"))
        {
            EmployeeId.setText("");
            EmployeeId.setForeground(new Color(102,102,102));
            
        }
    }//GEN-LAST:event_EmployeeIdFocusGained

    private void EmployeeIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeIdFocusLost
        if(EmployeeId.getText().equals(""))
        {
            EmployeeId.setText("Employee ID");
            EmployeeId.setForeground(new Color(102,102,102));
            
        }
    }//GEN-LAST:event_EmployeeIdFocusLost

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        if (new String(Password.getPassword()).equals("Password")) {
            Password.setText("");
            Password.setEchoChar('●');
            Password.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        if (new String(Password.getPassword()).isEmpty()) {
            Password.setText("Password");
            Password.setEchoChar('\u0000');
            Password.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_PasswordFocusLost

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void ConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConfirmPasswordFocusGained
       if (new String(ConfirmPassword.getPassword()).equals("Confirm Password")) {
            ConfirmPassword.setText("");
            ConfirmPassword.setEchoChar('●');
            ConfirmPassword.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_ConfirmPasswordFocusGained

    private void ConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConfirmPasswordFocusLost
        if (new String(ConfirmPassword.getPassword()).isEmpty()) {
            ConfirmPassword.setText("Confirm Password");
            ConfirmPassword.setEchoChar('\u0000');
            ConfirmPassword.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_ConfirmPasswordFocusLost

    private void ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordActionPerformed

    private void RegisterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterBtnMouseClicked
          Connection con = null;
    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("MySQL JDBC Driver Registered!");

        // Connect to Database
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "0000");
        System.out.println("Database Connected Successfully!!!");

        // Accept inputs
        String name = Name.getText();
        String employeeId = EmployeeId.getText();
        String password = Password.getText();
        String confirmPassword = ConfirmPassword.getText();

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords don't match");
        } else if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(this, "Password must be at least 5 letters long, contain no special characters, and include at least one number");
        } else {
            // Insert user data into the database
            String insertSql = "INSERT INTO registerdb (Name, EmployeeID, Password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSql);
            pstmt.setString(1, name);
            pstmt.setString(2, employeeId);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Registration Successful!");

            // Go Back to Sign in Page when clicked
            SignInPage sp = new SignInPage();
            sp.show();
            dispose();
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found. Please add the driver to your project.");
    } catch (SQLException ex) {
        Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage());
    } finally {
        try {
            if (con != null) con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_RegisterBtnMouseClicked

    
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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JLabel CreateAcc;
    private javax.swing.JTextField EmployeeId;
    private javax.swing.JTextField Name;
    private javax.swing.JPasswordField Password;
    private hotelreservation.Button RegisterBtn;
    private javax.swing.JLabel Subtext;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel image;
    // End of variables declaration//GEN-END:variables
}
