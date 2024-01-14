

public class Bit_Stuffing extends javax.swing.JFrame {

    public Bit_Stuffing() {
        initComponents();
    }
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Stuffing");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         
              String d1 = jTextField1.getText();
              String remaining ="";
              String output="";
              int counter = 0;//to keep track of no.of 1's
              jTextField2.setText("");
              for(int i=0;i<d1.length();i++)
                {

                   if (d1.charAt(i)!='1' && d1.charAt(i)!='0')// if the input is other than 1 or 0 then it is invalid string
                        {
                            System.out.println("Enter valid Binary values");
                            return;
                        }
                   if(d1.charAt(i) == '1')//if we encounter '1' then we increment the counter variable by 1.
                        {
                            counter++;
                            jTextField2.setText(jTextField2.getText() + d1.charAt(i)); 
                        }
                   else//if we encounter a '0' then immediately counter is again initialized to 0.
                        {
                            jTextField2.setText(jTextField2.getText() + d1.charAt(i));
                            counter = 0;
                        }
                   if(counter == 5)//if the count of 1's reach to 5 then we will append a new bit '0' next to five 1's.
                        {
                            jTextField2.setText(jTextField2.getText() +"0");
                            counter = 0;
                        }
                }
            System.out.println("Stuffed data at intermediate site is:");
           
            System.out.println(" "+remaining);
            
            //The process of destuffing.
            counter=0;
            for(int i=0;i<remaining.length();i++)
                {

                    if(remaining.charAt(i) == '1')//as long as we encounter the 1's while destuffing we increase the counter variable.If counter = 5
                        {

                            counter++;
                            output = output + remaining.charAt(i);

                        }
                    else//if the charecter is 0 then immediately counter is initialized to 0 again.
                        {
                             output = output + remaining.charAt(i);
                             counter = 0;
                        }
                   if(counter == 5)//then we will skip the very next element and continues the process.
                        {
                              if((i+2)!=remaining.length())
                              {
                                output = output + remaining.charAt(i+2);
                              }
                              else
                              {
                                output=output + '1';
                              }
                              i=i+2;
                              counter = 1;
                        }
               }
             System.out.println("Destuffed BIT is: "+output);
       


    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bit_Stuffing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bit_Stuffing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bit_Stuffing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bit_Stuffing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bit_Stuffing().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
