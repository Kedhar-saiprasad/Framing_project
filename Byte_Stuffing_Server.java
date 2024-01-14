
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class Byte_Stuffing_Server extends javax.swing.JFrame {

    public ServerSocket servsock = null;
    public Socket socket = null;
    public DataInputStream dis=null;
    public DataOutputStream dos=null;
    public Byte_Stuffing_Server() {
        initComponents();
        System.out.println("Hello");

    }

    public void setVisible(boolean b) {
        super.setVisible(b);

        System.out.println("Hey");
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Stuffed Message");

        jLabel2.setText("Destuffed Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                        .addComponent(jTextField2)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

   
    public static void main(String args[]) throws IOException {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Byte_Stuffing_Server bs=new Byte_Stuffing_Server();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                bs.setVisible(true);
                System.out.println("Hello world");
            }

        });
        
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try {
            ServerSocket servsock = new ServerSocket(6666);

            while (true) {
                Socket socket = servsock.accept();
                try {
                    dis = new DataInputStream(socket.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    dos = new DataOutputStream(socket.getOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                String out = "";
                String res = null;
                try {
                    res = dis.readUTF();
                } catch (IOException ex) {
                    Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Message Recevied...Successfully!!!");
                System.out.println("The Stuffed Message is : " + res);
                bs.getjTextField1().setText(res);
                for (int i = 1; i < res.length() - 1; i++) {
                    if (res.charAt(i) != 'E')
                        out = out + res.charAt(i);
                    else if (res.charAt(i) == 'E' && res.charAt(i + 1) == 'E') {
                        out = out + 'E';
                        i++;
                    }
                }
                System.out.println("The Destuffed Message is : " + out);
                bs.getjTextField2().setText(out);
                try {
                    dos.writeUTF("success");
                } catch (IOException ex) {
                    Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                String ch = null;
                try {
                    ch = dis.readUTF();
                } catch (IOException ex) {
                    Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ch.equals("bye")) {
                    System.out.println("Messaging is over.....EXITING");
                    break;
                }
            }


            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dos.close();
            } catch (IOException ex) {
                Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            servsock.close();
        }catch (IOException ex) {
            Logger.getLogger(Byte_Stuffing_Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Bye");
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
