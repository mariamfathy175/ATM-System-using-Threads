package parallel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client1 extends javax.swing.JFrame {

    static DataOutputStream dos;
    static DataInputStream din;
    static Socket s;
    static String msg = " ";
    static String pass = " ";
    static String user = " ";
    static String amount = "0";
    static String account = "";
    
    public client1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        withdraw = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        deposit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        checkbalance1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        transaction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        client3 = new javax.swing.JRadioButton();
        client2 = new javax.swing.JRadioButton();
        input14 = new javax.swing.JTextField();
        paybills = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        screen1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("client 1");
        setSize(new java.awt.Dimension(770, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("choose the operation you want to perform");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 263, 34));

        jLabel5.setText("Withdraw");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 67, 30));

        withdraw.setText("withdraw");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });
        getContentPane().add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 191, -1));

        jLabel7.setText("Deposit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 67, 34));

        deposit.setText("Deposit");
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });
        getContentPane().add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 190, -1));

        jLabel11.setText("check balance");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 88, 29));

        checkbalance1.setText("check balance");
        checkbalance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbalance1ActionPerformed(evt);
            }
        });
        getContentPane().add(checkbalance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 190, -1));

        jLabel9.setText("Transaction ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 25));

        transaction.setText("Transaction");
        transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionActionPerformed(evt);
            }
        });
        getContentPane().add(transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 190, -1));

        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 84, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 127, -1));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 73, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 127, -1));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 70, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 150, 20));

        jLabel6.setText("account number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 30));

        client3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(client3);
        client3.setText("client 3");
        getContentPane().add(client3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        client2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(client2);
        client2.setText("client 2");
        getContentPane().add(client2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        input14.setText("0");
        getContentPane().add(input14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 207, 63));

        paybills.setText("pay bills");
        paybills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybillsActionPerformed(evt);
            }
        });
        getContentPane().add(paybills, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 190, -1));

        jLabel12.setText("pay bill");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parallel/Picture7.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        screen1.setColumns(20);
        screen1.setRows(5);
        screen1.setBorder(null);
        jScrollPane2.setViewportView(screen1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 320, 370));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parallel/Picture8.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 700, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        amount=input14.getText();
        try {
            dos.writeUTF(" withdraw "+user+" "+pass+" "+amount+" "+1);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_withdrawActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed

        amount=input14.getText();
        try {
            dos.writeUTF(" deposit "+user+" "+pass+" "+amount+" "+1);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_depositActionPerformed

    private void checkbalance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbalance1ActionPerformed
        amount=input14.getText();
        try {
            dos.writeUTF(" checkbalance "+user+" "+pass+" "+amount+" "+1);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_checkbalance1ActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
        jLabel6.setVisible(true);     
        client2.setVisible(true);
        client3.setVisible(true);    
        amount = input14.getText();
        client2.setActionCommand("client2");
        client3.setActionCommand("client3");
        account = buttonGroup4.getSelection().getActionCommand();
        
        try {
            dos.writeUTF(" transfer "+user+" "+pass+" "+amount+" "+account);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_transactionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            dos.writeUTF(" login "+jTextField1.getText()+" "+jTextField2.getText()+" "+amount+" "+1);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(jTextField1.getText());
        user=jTextField1.getText();
        pass=jTextField2.getText();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void paybillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybillsActionPerformed
        amount=input14.getText();
        try {
            dos.writeUTF(" paybill "+user+" "+pass+" "+amount+" "+1);
        } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_paybillsActionPerformed

    final static int ServerPort = 1234;
    
    public static void main(String args[]) throws IOException {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client1().setVisible(true);
                jLabel4.setVisible(false);
                input14.setVisible(false);
                jLabel5.setVisible(false);
                jLabel7.setVisible(false);
                jLabel11.setVisible(false);
                jLabel9.setVisible(false);
                withdraw.setVisible(false);
                deposit.setVisible(false);
                checkbalance1.setVisible(false);
                transaction.setVisible(false);
                screen1.setVisible(false);
                jLabel6.setVisible(false);     
                client2.setVisible(false);
                client3.setVisible(false);
                paybills.setVisible(false);
                jLabel12.setVisible(false);
  
            }
        });			
		// establish the connection
		Socket s = new Socket("localhost", ServerPort);
		
		// obtaining input and out streams
		 din = new DataInputStream(s.getInputStream());
		 dos = new DataOutputStream(s.getOutputStream());

		// readMessage thread
		Thread readMessage = new Thread(new Runnable()
		{
			@Override
			public void run() {
                                String msg1 = null;
				while (true) {
					try {
						// read the message sent to this client
						msg1 = din.readUTF();
						screen1.setText(msg1);
					} catch (IOException e) {

						e.printStackTrace();
					}
                                        if ("Login success".equals(msg1) ){
                                        
                                        String fromServer=msg1;
                                        screen1.setText(fromServer);
                                            if("Login success".equals(fromServer))
                                            {
                                               jTextField1.setVisible(false);
                                               jTextField2.setVisible(false);
                                               jButton1.setVisible(false);
                                               jLabel1.setVisible(false);
                                               jLabel2.setVisible(false);
                                               jLabel3.setVisible(false);
                                               jLabel8.setVisible(false);
                                               jLabel4.setVisible(true);
                                               jLabel5.setVisible(true);
                                               jLabel7.setVisible(true);
                                               jLabel11.setVisible(true);
                                               jLabel9.setVisible(true);
                                               withdraw.setVisible(true);
                                               deposit.setVisible(true);
                                               checkbalance1.setVisible(true);
                                               transaction.setVisible(true);
                                               screen1.setVisible(true);
                                               input14.setVisible(true);
                                               paybills.setVisible(true);
                                               jLabel12.setVisible(true);

                                            }
                                        screen1.setText("Server:" + fromServer);
                                        }
                                        else{
                                            String fromServer=msg1;
                                            jLabel3.setText(fromServer);
                                        }
				}
			}
		});

		readMessage.start();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private static javax.swing.ButtonGroup buttonGroup4;
    private static javax.swing.JButton checkbalance1;
    private static javax.swing.JRadioButton client2;
    private static javax.swing.JRadioButton client3;
    private static javax.swing.JButton deposit;
    private static javax.swing.JTextField input14;
    private static javax.swing.JButton jButton1;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel jLabel11;
    private static javax.swing.JLabel jLabel12;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private static javax.swing.JButton paybills;
    private static javax.swing.JTextArea screen1;
    private static javax.swing.JButton transaction;
    private static javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables
}
