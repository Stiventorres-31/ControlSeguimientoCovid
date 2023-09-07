/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import modelo.DatosGraficas;
import modelo.ProcesosGraficas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Holis
 */
public class JInternalBuscarFecha extends javax.swing.JInternalFrame {

    DatosGraficas dg = new DatosGraficas();
    ProcesosGraficas pg = new ProcesosGraficas();

    public JInternalBuscarFecha() {
        initComponents();
    }

    private void buscarFecha() {
        SimpleDateFormat dFormato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dFormato2 = new SimpleDateFormat("yyyy-MM-dd");
        
        String fecha1 = dFormato.format(JDateFecha1.getDate());
        dg = pg.buscarFechas(fecha1);
        int f1=dg.getCantidadVacunadosFecha();
        
        String fecha2 = dFormato2.format(JDateFecha2.getDate());
        dg = pg.buscarFechas(fecha2);
        int f2=dg.getCantidadVacunadosFecha();
        

        //int n2=Integer.parseInt(jTextField2.getText());//Esto son los campos de texto, pero como se van a 
        //sacar de la base de datos tu los borras.
        DefaultCategoryDataset datos = new DefaultCategoryDataset();//Establecer los valores(supongo que tambien lo quitas)

        datos.setValue(f1, "Cantidad",fecha1);//Los datos almacenados
        datos.setValue(f2, "Cantidad", fecha2);

        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Cantidad de personas vacunas de las 2 fechas", //NOMBRE DEL GRAFICO
                "Meses", //NOMBRE DE LAS BARRAS O COLUMNAS
                "Cantidad", //NOMBRE DE NUMERACION
                datos, //datos de barras
                PlotOrientation.VERTICAL, //ORIENTACION
                true, //barra individual por colores
                true, //herramientas
                false //url del grafico
        );

        ChartPanel panel = new ChartPanel(grafico_barras);  //Creando un panel tipo chart
        panel.setMouseWheelEnabled(true);                   //Mouse Habilitado (Ruenda del raton para manipular)
        panel.setPreferredSize(new Dimension(780, 422));     //Dimension

        JPanelMostrarGrafica.setLayout(new BorderLayout());         //Asignando al panel donde va el grafico con bordes
        JPanelMostrarGrafica.add(panel, BorderLayout.NORTH);
        btnBuscarFechas.setEnabled(false);
        pack();//Estos son necesarios para el grafico
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JDateFecha1 = new com.toedter.calendar.JDateChooser();
        JDateFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPanelMostrarGrafica = new javax.swing.JPanel();
        btnBuscarFechas = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Comparar 2 fechas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ingrese la fecha 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ingrese la fecha 2");

        JPanelMostrarGrafica.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout JPanelMostrarGraficaLayout = new javax.swing.GroupLayout(JPanelMostrarGrafica);
        JPanelMostrarGrafica.setLayout(JPanelMostrarGraficaLayout);
        JPanelMostrarGraficaLayout.setHorizontalGroup(
            JPanelMostrarGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        JPanelMostrarGraficaLayout.setVerticalGroup(
            JPanelMostrarGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        btnBuscarFechas.setText("Buscar");
        btnBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechasActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JDateFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(JDateFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscarFechas)
                        .addGap(30, 30, 30)
                        .addComponent(btnLimpiar)))
                .addGap(100, 100, 100)
                .addComponent(JPanelMostrarGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanelMostrarGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JDateFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDateFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarFechas)
                            .addComponent(btnLimpiar))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechasActionPerformed
        buscarFecha();
    }//GEN-LAST:event_btnBuscarFechasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        JPanelMostrarGrafica.removeAll();
        JPanelMostrarGrafica.revalidate();
        JPanelMostrarGrafica.repaint();
        btnBuscarFechas.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDateFecha1;
    private com.toedter.calendar.JDateChooser JDateFecha2;
    private javax.swing.JPanel JPanelMostrarGrafica;
    private javax.swing.JButton btnBuscarFechas;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}