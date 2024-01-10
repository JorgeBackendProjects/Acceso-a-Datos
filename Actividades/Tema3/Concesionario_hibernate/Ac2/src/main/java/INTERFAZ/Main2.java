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
public class Main2 extends javax.swing.JFrame {

    private JFrame frame;
    private JButton botonAtras, botonConsultar, botonInsertar, botonActualizar, botonBorrar;
    private int nTabla;
    private JLabel tituloSeg;
    
    private Consultar consulta;
    private Insertar insertar;
    private Actualizar actualizar;
    private Borrar borrar;
    

    /**
     * Creates new form SegundaActividad
     */
    public Main2() {
        initComponents();
        
        frame = this;
        
        consulta = new Consultar();
        consulta.setSize(420, 300);
        consulta.setVisible(false);
        
        insertar = new Insertar();
        insertar.setSize(420, 300);
        insertar.setVisible(false);
        
        actualizar = new Actualizar();
        actualizar.setSize(420, 300);
        actualizar.setVisible(false);

        borrar= new Borrar();
        borrar.setSize(420, 300);
        borrar.setVisible(false);
        
        tituloSeg = new JLabel("Selecciona la operación a realizar:");
        tituloSeg.setBounds(23, 24, 258, 27);

        botonConsultar = new JButton("Consultar datos");
        botonConsultar.setLocation(23, 76);
        botonConsultar.setSize(161, 33);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
                consulta.setVisible(true);
                consulta.setNTabla(nTabla);
                consulta.setDatos();
            }
        });

        botonInsertar = new JButton("Insertar datos");
        botonInsertar.setLocation(220, 76);
        botonInsertar.setSize(161, 33);
        botonInsertar.setVisible(true);
        botonInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
                insertar.setVisible(true);
                insertar.setNTabla(nTabla);
                insertar.setDatos();
            }
        });

        botonActualizar = new JButton("Actualizar datos");
        botonActualizar.setLocation(23, 133);
        botonActualizar.setSize(161, 33);
        botonActualizar.setVisible(true);
        botonActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
                actualizar.setVisible(true);
                actualizar.setNTabla(nTabla);
                actualizar.setDatos();
            }
        });

        botonBorrar = new JButton("Borrar datos");
        botonBorrar.setLocation(220, 133);
        botonBorrar.setSize(161, 33);
        botonBorrar.setVisible(true);
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
                borrar.setVisible(true);
                borrar.setNTabla(nTabla);
                borrar.setDatos();
            }
        });

        botonAtras = new JButton("Atrás");
        botonAtras.setLocation(23, 197);
        botonAtras.setSize(161, 33);
        botonAtras.setVisible(true);
        botonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
               
                Main a1 = new Main();
                a1.setVisible(true);
            }
        });

        this.add(botonInsertar);
        this.add(botonActualizar);
        this.add(botonConsultar);
        this.add(botonBorrar);
        this.add(botonAtras);
        this.add(tituloSeg);
    }

    public void setNTabla(int n) {
        nTabla = n;
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
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }
    
    
}
