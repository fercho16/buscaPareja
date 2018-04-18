package busca_pareja;
import com.sun.awt.*;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Login extends javax.swing.JFrame {
    
    public static int encontrado, encontrado2;
    public static String user= "", clave="";
    
    public Login() {
        
        setLocationRelativeTo(null);
        setUndecorated(true);
        setOpacity(1.0f);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        initComponents();
        this.setLocationRelativeTo(null);  
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cj_login = new javax.swing.JTextField();
        lineaAzulAbajo = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        lineaAzulArriba = new javax.swing.JPanel();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        cj_pasword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lbContra1 = new javax.swing.JLabel();
        lbUsuario1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recuperar contraseña");
        setFocusTraversalPolicyProvider(true);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cj_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cj_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cj_loginKeyTyped(evt);
            }
        });
        jPanel1.add(cj_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 205, 30));

        lineaAzulAbajo.setBackground(new java.awt.Color(0, 204, 153));

        cerrar.setBackground(new java.awt.Color(0, 0, 0));
        cerrar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cerrar.setText("Salir");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lineaAzulAbajoLayout = new javax.swing.GroupLayout(lineaAzulAbajo);
        lineaAzulAbajo.setLayout(lineaAzulAbajoLayout);
        lineaAzulAbajoLayout.setHorizontalGroup(
            lineaAzulAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lineaAzulAbajoLayout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        lineaAzulAbajoLayout.setVerticalGroup(
            lineaAzulAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel1.add(lineaAzulAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 480, -1));

        lineaAzulArriba.setBackground(new java.awt.Color(0, 204, 153));

        panelCurves1.setLayout(null);

        javax.swing.GroupLayout lineaAzulArribaLayout = new javax.swing.GroupLayout(lineaAzulArriba);
        lineaAzulArriba.setLayout(lineaAzulArribaLayout);
        lineaAzulArribaLayout.setHorizontalGroup(
            lineaAzulArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        lineaAzulArribaLayout.setVerticalGroup(
            lineaAzulArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel1.add(lineaAzulArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(cj_pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 205, 26));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lbContra1.setBackground(new java.awt.Color(0, 102, 153));
        lbContra1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbContra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContra1.setText("Contraseña");
        jPanel1.add(lbContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lbUsuario1.setBackground(new java.awt.Color(0, 102, 153));
        lbUsuario1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuario1.setText("Usuario");
        jPanel1.add(lbUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 60, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        bu.setBackground(new java.awt.Color(255, 255, 255));
        bu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptar-cheque-verde-ok-si-icono-6092-32.png"))); // NOI18N
        bu.setText("Aceptar");
        bu.setBorder(null);
        bu.setBorderPainted(false);
        bu.setContentAreaFilled(false);
        bu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buActionPerformed(evt);
            }
        });
        jPanel1.add(bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0); 
    }//GEN-LAST:event_cerrarMouseClicked

    private void cj_loginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cj_loginKeyTyped
       
    }//GEN-LAST:event_cj_loginKeyTyped
       static Object data[][];
    private void buActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buActionPerformed
        Conexion();
    }//GEN-LAST:event_buActionPerformed
        
    public static void Conexion()  {
    DB_Login cc = new DB_Login();
       Connection cn = cc.conexion();
     user= cj_login.getText();
     clave = cj_pasword.getText();
     
        if ((user.isEmpty()) || (clave.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");
        } else {
            try {
                DB_Login conectar = new DB_Login();
               
                Statement st = cn.createStatement();
                
                try {
                    
                    ResultSet rs = st.executeQuery("SELECT * FROM usuarios  WHERE usuario='" + user + "' AND password ='" + clave + "'");
                    System.out.println("Usuario "+ user);
                    System.out.println("Contraseña "+clave);
                   rs.last();
                    
                    encontrado = rs.getRow();
                    
                    //System.out.println(String.valueOf(encontrado));
                    if (encontrado == 1) {
                        
                       
                        JOptionPane.showMessageDialog(null, "llego");
              
             
                    } else {
                        ResultSet ss = st.executeQuery("SELECT * FROM usuarios  WHERE usuario='" + user + "' AND password ='" + clave + "'");
                        ss.last();
                        encontrado2=ss.getRow();
                         if (encontrado2 == 1) {
                       
                         }
                         else{
                        ss.close();
                        JOptionPane.showMessageDialog(null, "Nombre o usuario incorrectos");
                         }
                    }
                    
                    rs.close();
                    //ss.close();
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

   
                
              }
    }
    
    public static void main(String args[]) {
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bu;
    private javax.swing.JLabel cerrar;
    public static javax.swing.JTextField cj_login;
    public static javax.swing.JPasswordField cj_pasword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbContra1;
    private javax.swing.JLabel lbUsuario1;
    private javax.swing.JPanel lineaAzulAbajo;
    private javax.swing.JPanel lineaAzulArriba;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    // End of variables declaration//GEN-END:variables
}
