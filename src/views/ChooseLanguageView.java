package views;

import user.UserModel;

/**
 *
 * @author mikjakbiak w1782957
 */
public class ChooseLanguageView extends javax.swing.JFrame {
    UserModel userModel;
    javax.swing.JFrame previousJFrame;

    /**
     * Creates new form ChooseLanguageView
     */
    public ChooseLanguageView() {
        initComponents();
    }

    public ChooseLanguageView(UserModel userModel) {
        this.userModel = userModel;
        initComponents();
    }
    
    public ChooseLanguageView(javax.swing.JFrame previousJFrame) {
        this.previousJFrame = previousJFrame;
        initComponents();
    }

    public ChooseLanguageView(javax.swing.JFrame previousJFrame, UserModel userModel) {
        this.previousJFrame = previousJFrame;
        this.userModel = userModel;
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        germanBtn = new javax.swing.JButton();
        SpanishBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(427, 710));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Linguify_Logo.png"))); // NOI18N

        germanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flag_of_Germany.png"))); // NOI18N
        germanBtn.setText("German\n");
        germanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                germanBtnActionPerformed(evt);
            }
        });

        SpanishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flag_of_Spain.png"))); // NOI18N
        SpanishBtn.setText("Spanish");
        SpanishBtn.setToolTipText("");
        SpanishBtn.setActionCommand("Spanish\n"); // NOI18N
        SpanishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpanishBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 253, 253));
        jLabel2.setText("Choose your language");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 182, 182)));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        homeBtn.setBackground(new java.awt.Color(51, 51, 51));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homeNew.png"))); // NOI18N
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(51, 51, 51));
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backNew.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(germanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SpanishBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(SpanishBtn)
                .addGap(18, 18, 18)
                .addComponent(germanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        javax.swing.JFrame hub = userModel.getHubPanel();
        this.setVisible(false);
        hub.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(previousJFrame);
        if (previousJFrame != null) {
            this.setVisible(false);
            previousJFrame.setVisible(true);
        }
        
    } 
    
    private void SpanishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpanishBtnActionPerformed
        userModel.setLanguage("Spanish");
        displayNextJFrame();
    }//GEN-LAST:event_SpanishBtnActionPerformed

    private void germanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_germanBtnActionPerformed
        userModel.setLanguage("German");
        displayNextJFrame();
    }//GEN-LAST:event_germanBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChooseLanguageView().setVisible(true);
        });
    }

    private void displayNextJFrame() {
        ChooseLanguageLevelView next = new ChooseLanguageLevelView(this, userModel);
        this.setVisible(false);
        next.setVisible(true);
    }

    private javax.swing.JButton[] LanguageBtns;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SpanishBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton germanBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
