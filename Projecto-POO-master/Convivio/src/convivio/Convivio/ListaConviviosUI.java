package convivio.Convivio;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 * Classe ListaConviviosUI serve para apresentar os diferentes convívios em que 
 * a pessoa está inscrita através de uma interface gráfica.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class ListaConviviosUI extends javax.swing.JFrame {
    /**
     * Objecto da classe MainClassUI.
     */
    private MainClassUI importantFrame;
    /**
     * Objecto da classe ClientUI. 
     */
    private ClientUI clientFrame;
    /**
     * ArrayList de Strings que contém o nome dos convívios em que a pessoa está inscrita.
     */
    private ArrayList<String> convivios;
    /**
     * Objecto da classe Pessoa.
     */
    private Pessoa pessoa;
    /**
     * Creates new form ListaConviviosUI
     * @param importantFrame Objecto da classe MainClassUI.
     * @param clientFrame Objecto da classe ClientUI.
     * @param pessoa Objecto da classe Pessoa.
     */
    public ListaConviviosUI(MainClassUI importantFrame, ClientUI clientFrame, Pessoa pessoa) {
        this.importantFrame = importantFrame;
        this.clientFrame = clientFrame;
        this.pessoa = pessoa;
        convivios = new ArrayList<>();
        populateArray();
        initComponents();
        populateTextArea();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        conviviosComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        locaisTextArea = new javax.swing.JTextArea();
        entrarButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de convívios em que estás inscrito");

        conviviosComboBox.setModel(new DefaultComboBoxModel(convivios.toArray()));
        conviviosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conviviosComboBoxActionPerformed(evt);
            }
        });

        locaisTextArea.setEditable(false);
        locaisTextArea.setColumns(20);
        locaisTextArea.setRows(5);
        jScrollPane1.setViewportView(locaisTextArea);

        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Convívio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(entrarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarButton)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conviviosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conviviosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrarButton)
                    .addComponent(voltarButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        clientFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void conviviosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conviviosComboBoxActionPerformed
        // TODO add your handling code here:
        populateTextArea();
    }//GEN-LAST:event_conviviosComboBoxActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        // TODO add your handling code here:
        ConvivioDei convivio = null;
        ArrayList<ConvivioDei> listaTotal = importantFrame.getListaConvivios();
        for(ConvivioDei conv : listaTotal){
            if(conviviosComboBox.getSelectedItem().toString().equals(conv.getNome())){
                convivio = conv;
            }
        }
        this.setVisible(false);
        new InsideConvUI(importantFrame, clientFrame, convivio.getNome(), pessoa).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_entrarButtonActionPerformed

    /**
     * Adiciona ao ArrayList o nome dos convívios em que a pessoa está inscrita.
     */
    private void populateArray(){
        ArrayList<ConvivioDei> listaTotal = importantFrame.getListaConvivios();
        for(ConvivioDei conv : listaTotal){
            if(conv.isPersonRegistered(clientFrame.getPessoa().getNome())){
                convivios.add(conv.getNome());
            }
        }
    }
    
    /**
     * Escreve para o ecrã o locais do convívio selecionado na ComboBox.
     */
    private void populateTextArea(){
        String infoLocais = "";
        ArrayList<ConvivioDei> listaTotal = importantFrame.getListaConvivios();
        for(ConvivioDei conv : listaTotal){
            if(conviviosComboBox.getSelectedItem().toString().equals(conv.getNome())){
                infoLocais = conv.getInfoLocais();
            }
        }
        if(infoLocais.equals("")){
            locaisTextArea.setText("Este convívio não tem locais a visitar ainda.");
        }else{
            locaisTextArea.setText(infoLocais);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> conviviosComboBox;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea locaisTextArea;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
