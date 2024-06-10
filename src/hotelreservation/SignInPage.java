package hotelreservation;

import hotelreservation.AdminPage;
import hotelreservation.AdminPage2;
import hotelreservation.HomePage;
import hotelreservation.RegisterPage;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignInPage extends javax.swing.JFrame { 
    
    public SignInPage() {
        initComponents();
        // Set initial focus to the SignInBtn button
        this.getRootPane().setDefaultButton(SignInBtn);
        SignInBtn.requestFocusInWindow();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        EmployeeId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        SignInBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        RegisterBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign in");

        EmployeeId.setBackground(new java.awt.Color(246, 246, 246));
        EmployeeId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        EmployeeId.setForeground(new java.awt.Color(102, 102, 102));
        EmployeeId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        EmployeeId.setText("Employee ID");
        EmployeeId.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        EmployeeId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmployeeIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmployeeIdFocusLost(evt);
            }
        });
        EmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Kannada MN", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hey There! Welcome back to Hotel Callé.");

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

        SignInBtn.setBackground(new java.awt.Color(0, 102, 102));
        SignInBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignInBtn.setForeground(new java.awt.Color(255, 255, 255));
        SignInBtn.setText("Sign me in!");
        SignInBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.gray));
        SignInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignInBtnMouseClicked(evt);
            }
        });
        SignInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Kannada MN", 0, 12)); // NOI18N
        jLabel5.setText("No account yet?");

        RegisterBtn.setBackground(new java.awt.Color(0, 102, 102));
        RegisterBtn.setFont(new java.awt.Font("Khmer MN", 3, 14)); // NOI18N
        RegisterBtn.setForeground(new java.awt.Color(0, 102, 102));
        RegisterBtn.setText("Register");
        RegisterBtn.setBorder(null);
        RegisterBtn.setBorderPainted(false);
        RegisterBtn.setContentAreaFilled(false);
        RegisterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterBtnMouseClicked(evt);
            }
        });
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Kannada MN", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HALF.png"))); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RegisterBtn))
                            .addComponent(SignInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmployeeId)
                            .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(EmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(SignInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void SignInBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInBtnMouseClicked
        // Open Home Page when clicked
        HomePage hp = new HomePage();
        hp.show();
        dispose();                                                                         

    }//GEN-LAST:event_SignInBtnMouseClicked

    private void RegisterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterBtnMouseClicked
        RegisterPage rp = new RegisterPage();
        rp.show();
        dispose();
    }//GEN-LAST:event_RegisterBtnMouseClicked

    private void SignInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInBtnActionPerformed
        //Sign in
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // Connect to Database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "0000");
            System.out.println("Database Connected Successfully!!!");

            // Accept inputs
            String employeeId = EmployeeId.getText();
            String password = new String(Password.getPassword());

            // Check if credentials are valid
            String selectSql = "SELECT * FROM registerdb WHERE EmployeeID = ? AND Password = ?";
            PreparedStatement pst = con.prepareStatement(selectSql);
            pst.setString(1, employeeId);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            // Will proceed if Sign in is successful
            if (rs.next()) {
                AdminPage2 ap2 = new AdminPage2();
                ap2.show();
                dispose();
            } else {
                // Failed Login
                JOptionPane.showMessageDialog(this, "Invalid Employee ID or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            } catch (ClassNotFoundException ex) {
                System.out.println("MySQL JDBC Driver not found.");
                ex.printStackTrace();
            } catch (SQLException ex) {
                System.out.println("Connection Failed! Check output console");
                ex.printStackTrace();
            } finally {
                try {
                if (con != null) {
                con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }//GEN-LAST:event_SignInBtnActionPerformed

    private void EmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeIdActionPerformed

    private void RegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterBtnActionPerformed
        RegisterPage rp = new RegisterPage();
        rp.show();
        dispose();
    }//GEN-LAST:event_RegisterBtnActionPerformed

    private void EmployeeIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeIdFocusGained
            if(EmployeeId.getText().equals("Employee ID"))
        {
            EmployeeId.setText("");
            EmployeeId.setForeground(new Color(102,102,102));
            
        }
    }//GEN-LAST:event_EmployeeIdFocusGained

    private void EmployeeIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeIdFocusLost
         if (EmployeeId.getText().isEmpty()) {
            EmployeeId.setText("Employee ID");
            EmployeeId.setForeground(new Color(102, 102, 102));
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
            java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmployeeId;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JButton SignInBtn;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
