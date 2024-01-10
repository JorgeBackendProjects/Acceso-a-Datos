package INTERFAZ;

import Entidades.Cliente;
import Entidades.Coche;
import Entidades.Revision;
import javax.persistence.*;
import javax.swing.JFrame;

/**
 * @author Usuario
 * 
 * NO ACTUALIZA
 */
public class Actualizar extends javax.swing.JFrame {

    private JFrame frame;
    private int nTabla;
    
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JTextField input1;
    private javax.swing.JTextField input2;
    private javax.swing.JTextField input3;
    private javax.swing.JTextField input4;
    private javax.swing.JTextField input5;
    private javax.swing.JTextField input6;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JTextField textField;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;

    /**
     * Creates new form Actualizar
     */
    public Actualizar() {
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
                textField.setText("Select cli from Cliente cli where id = __");

                label1.setText("ID: ");
                label2.setText("NIF: ");
                label3.setText("Nombre: ");
                label4.setText("Ciudad: ");
                label5.setText("Calle: ");
                label6.setText("NºCasa: ");
                break;

            case 2:
                titulo1.setText(titulo1.getText() + "coches...");
                textField.setText("Select co from Coche co where Matricula =''");

                label1.setText("Matricula: ");
                label2.setText("Marca: ");
                label3.setText("Modelo: ");
                label4.setText("Color: ");
                label5.setText("Precio: ");
                label6.setVisible(false);
                input6.setVisible(false);
                break;

            case 3:
                titulo1.setText(titulo1.getText() + "revisiones...");
                textField.setText("Select re from Revision re where id = __");

                label1.setText("ID: ");
                label2.setText("Cambio de aceite (Si/No): ");
                label3.setText("Cambio de filtro (Si/No): ");
                label4.setText("Cambio de frenos (Si/No): ");
                label5.setText("Otros cambios (Si/No): ");
                label6.setVisible(false);
                input6.setVisible(false);
                break;
        }
    }
    
    private void initComponents() {

        textField = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        titulo3 = new javax.swing.JLabel();
        input2 = new javax.swing.JTextField();
        input3 = new javax.swing.JTextField();
        input4 = new javax.swing.JTextField();
        input5 = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        input1 = new javax.swing.JTextField();
        titulo2 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        input6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo1.setText("Actualizando datos de la tabla ");

        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        titulo3.setText("Realiza una consulta para operar con el resultado:");

        label1.setText("jLabel1");

        label2.setText("jLabel1");

        label3.setText("jLabel1");

        label4.setText("jLabel1");

        label5.setText("jLabel1");

        titulo2.setText("Actualiza los datos:");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        label6.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(input5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(input3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(input4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5)
                    .addComponent(input5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label6)
                    .addComponent(input6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }
    
    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        switch (nTabla) {

            case 1:
                consultaCliente();
                break;

            case 2:
                consultaCoche();
                break;

            case 3:
                consultaRevision();
                break;
        }
    }
    
    public void consultaCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery(textField.getText());
        Cliente cli = (Cliente) q.getSingleResult();

        input1.setText(cli.getId() + "");
        input2.setText(cli.getNif());
        input3.setText(cli.getNombre());
        input4.setText(cli.getCiudad());
        input5.setText(cli.getCalle());
        input6.setText(cli.getNumeroCasa());
     
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void consultaCoche() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery(textField.getText());
        Coche co = (Coche) q.getSingleResult();

        input1.setText(co.getMatricula());
        input2.setText(co.getMarca());
        input3.setText(co.getModelo());
        input4.setText(co.getColor());
        input5.setText(co.getPrecio() + "");
        input6.setVisible(false);
        
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void consultaRevision() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery(textField.getText());
        Revision re = (Revision) q.getSingleResult();

        input1.setText(re.getId() + "");
        input2.setText(re.getCambioAceite());
        input3.setText(re.getCambioFiltro());
        input4.setText(re.getCambioFrenos());
        input5.setText(re.getOtrosCambios());
        input6.setVisible(false);
        
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
    
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        frame.setVisible(false);

        Main2 a2 = new Main2();
        a2.setVisible(true);
    }
    
    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        switch (nTabla) {

            case 1:
                actualizarCliente();
                break;

            case 2:
            	actualizarCoche();
                break;

            case 3:
            	actualizarRevision();
                break;
        }
    } 

    public void actualizarCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Cliente cliente = new Cliente();

        cliente.setId(Integer.parseInt(input1.getText()));
        cliente.setNif(input2.getText());
        cliente.setNombre(input3.getText());
        cliente.setCiudad(input4.getText());
        cliente.setCalle(input5.getText());
        cliente.setNumeroCasa(input6.getText());

        entityManager.merge(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void actualizarCoche() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        
        Coche coche = new Coche();

        coche.setMatricula(input1.getText());
        coche.setMarca(input2.getText());
        coche.setModelo(input3.getText());
        coche.setColor(input4.getText());
        coche.setPrecio(Integer.parseInt(input5.getText()));

        entityManager.merge(coche);
        
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void actualizarRevision() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Revision revision = new Revision();

        revision.setId(Integer.parseInt(input1.getText()));
        revision.setCambioAceite(input2.getText());
        revision.setCambioFiltro(input3.getText());
        revision.setCambioFrenos(input4.getText());
        revision.setOtrosCambios(input5.getText());
        
        entityManager.merge(revision);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
    
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
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar().setVisible(true);
            }
        });
    }

}
