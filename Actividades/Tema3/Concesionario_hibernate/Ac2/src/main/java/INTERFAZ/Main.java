package INTERFAZ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class Main extends javax.swing.JFrame {

    private JFrame frame;
    private JLabel tituloMain;
    private JButton botonTablaClientes, botonTablaCoches, botonTablaRevisiones;
    private int nTabla;
    private Main2 a2;

    /**
     * Creates new form PrimeraActividad
     */
    public Main() {
        initComponents();

        frame = this;
        
        a2 = new Main2();
        a2.setSize(420, 300);
        a2.setVisible(false);
        
        tituloMain = new JLabel("Selecciona la tabla para realizar una operación:");
        tituloMain.setBounds(10, 11, 281, 29);

        botonTablaClientes = new JButton("Tabla Clientes");
        botonTablaClientes.setBounds(20, 78, 177, 35);
        botonTablaClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonTablaClientes.setVisible(false);
                botonTablaRevisiones.setVisible(false);
                botonTablaCoches.setVisible(false);
                tituloMain.setVisible(false);

                frame.setVisible(false);
                
                a2.setNTabla(1);
                a2.setVisible(true);
            }
        });

        botonTablaCoches = new JButton("Tabla Coches");
        botonTablaCoches.setBounds(20, 148, 177, 35);
        botonTablaCoches.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonTablaClientes.setVisible(false);
                botonTablaRevisiones.setVisible(false);
                botonTablaCoches.setVisible(false);
                tituloMain.setVisible(false);
                
                frame.setVisible(false);

                a2.setNTabla(2);
                a2.setVisible(true);
            }
        });

        botonTablaRevisiones = new JButton("Tabla Revisiones");
        botonTablaRevisiones.setBounds(217, 78, 177, 35);
        botonTablaRevisiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonTablaClientes.setVisible(false);
                botonTablaRevisiones.setVisible(false);
                botonTablaCoches.setVisible(false);
                tituloMain.setVisible(false);
                
                frame.setVisible(false);

                a2.setNTabla(3);
                a2.setVisible(true);
            }
        });

        this.add(tituloMain);
        this.add(botonTablaClientes);
        this.add(botonTablaCoches);
        this.add(botonTablaRevisiones);

    }
    
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    

}
