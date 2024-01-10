package INTERFAZ;

import Entidades.Cliente;
import Entidades.Coche;
import Entidades.Revision;
import java.util.ArrayList;
import javax.persistence.*;
import javax.swing.JFrame;

/**
 * @author Usuario
 * 
 * RECUPERAR OBJETOS
 */
public class Consultar extends javax.swing.JFrame {

    private JFrame frame;
    private int nTabla;
    
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textField;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private String resultado;

    /**
     * Creates new form Consultas
     */
    public Consultar() {
        initComponents();

        setDatos();
    }

    public void setNTabla(int n) {
        nTabla = n;
    }

    public void setDatos() {
        switch (nTabla) {

            case 1:
                titulo1.setText(titulo1.getText() + "clientes...");
                textField.setText("Select cli from Cliente cli;");
                break;

            case 2:
                titulo1.setText(titulo1.getText() + "coches...");
                textField.setText("Select co from Coche co;");
                break;

            case 3:
                titulo1.setText(titulo1.getText() + "revisiones...");
                textField.setText("Select re from Revision re;");
                break;
        }
    }

    public void persistenceClientes() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        
        Query query = entityManager.createQuery(textField.getText());

        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        lista = (ArrayList<Cliente>) query.getResultList();
        
        for(Cliente cli : lista) {
        	resultado += cli.toString() + "\n";
        }
        
        textArea.setText(resultado);
        
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
        
    }

    public void persistenceCoches() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(textField.getText());
        
        ArrayList<Coche> lista = new ArrayList<Coche>();
        lista = (ArrayList<Coche>) query.getResultList();
        
        for(Coche co : lista) {
        	resultado += co.toString() + "\n";
        }
        
        textArea.setText(resultado);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void persistenceRevisiones() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(textField.getText());
        
        ArrayList<Revision> lista = new ArrayList<Revision>();
        lista = (ArrayList<Revision>) query.getResultList();

        for(Revision re : lista) {
        	resultado += re.toString() + "\n";
        }
        
        textArea.setText(resultado);
        
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
    
    private void initComponents() {

        textField = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        botonConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        titulo2 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo1.setText("Realizando una consulta a la tabla ");

        botonConsulta.setText("Consultar");
        botonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        titulo2.setText("Datos obtenidos:");

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
                
                Main a1 = new Main();
                a1.setVisible(true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    private void botonConsultaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        switch (nTabla) {

            case 1:
                persistenceClientes();
                break;

            case 2:
                persistenceCoches();
                break;

            case 3:
                persistenceRevisiones();
                break;
        }
    }
    
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        frame.setVisible(false);

        Main2 a2 = new Main2();
        a2.setVisible(true);
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
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar().setVisible(true);
            }
        });
    }
    
}
