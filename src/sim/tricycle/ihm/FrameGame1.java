/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.awt.Color;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.CarteInterface;
import sim.tricycle.mapping.TestMap;

/**
 *
 * @author Morgan BIDOIS <morganbidois@gmail.com>
 */
public class FrameGame1 extends javax.swing.JFrame {

    private ViewCarte vc;
    
    /**
     * Creates new form MorganTestAppli
     */
    public FrameGame1(CarteInterface carte) {
        initComponents();

        //Creer et utilise cette carte car plus grande
        //Carte c = new Carte(25, 25);
        
        TestMap test2 = new TestMap();
        test2.startTest();
        Carte c = test2.getCarte();

        vc = new ViewCarte(c);
        //jpanMap.setSize(vc.getWidth(), vc.getHeight());
        //panMap.add(vc);
        //panMap = vc;
        //panMap.setSize(vc.getWidth(), vc.getHeight());

        //panMap.setSize(c.getLargeur()*vc.getWidth(), c.getHauteur()*vc.getHeight());
        //panMap.setSize(500,500);
        //jspanMap.revalidate();
        jspanMap.setViewportView(vc);

        //jspanMap.setPreferredSize(vc.getSize());

        System.out.println(" largeur scroll pane :" + jspanMap.getWidth() + " hauteur : " + jspanMap.getHeight());
        System.out.println(" largeur pane Map :" + vc.getWidth() + " hauteur : " + vc.getHeight());




    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headband = new javax.swing.JPanel();
        buttonPause = new javax.swing.JButton();
        buttonPlay = new javax.swing.JButton();
        buttonStepPlay = new javax.swing.JButton();
        buttonSpeedUp = new javax.swing.JButton();
        scorePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtscoreBallTeam1 = new javax.swing.JLabel();
        txtScoreGoldTeam1 = new javax.swing.JLabel();
        txtScoreBallTeam2 = new javax.swing.JLabel();
        txtScoreGoldTeam2 = new javax.swing.JLabel();
        buttonExit = new javax.swing.JButton();
        panSelectTeamMap = new javax.swing.JPanel();
        lblMap = new javax.swing.JLabel();
        buttonTteam2 = new javax.swing.JButton();
        buttonMapTeam1 = new javax.swing.JButton();
        buttonGlobalMap = new javax.swing.JButton();
        panActionAvailable = new javax.swing.JTabbedPane();
        panActionAvailableGlobale = new javax.swing.JPanel();
        panActionAvailableTeam1 = new javax.swing.JPanel();
        panActionAvailableTeam2 = new javax.swing.JPanel();
        jspanMap = new javax.swing.JScrollPane();
        panZoom = new javax.swing.JPanel();
        sldZoom = new javax.swing.JSlider();
        lblZoom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AppliFrame");

        headband.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/pause.gif"))); // NOI18N
        buttonPause.setText("Pause");
        buttonPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPauseMousePressed(evt);
            }
        });

        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/arrow-right-play.gif"))); // NOI18N
        buttonPlay.setText("Play");
        buttonPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPlayMousePressed(evt);
            }
        });

        buttonStepPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/arrow-right.gif"))); // NOI18N
        buttonStepPlay.setText("Step");

        buttonSpeedUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/arrow-fast-forward.gif"))); // NOI18N
        buttonSpeedUp.setText("Speed up");

        scorePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Balls :");

        jLabel2.setText("Gold :");

        jLabel3.setText("VS");

        jLabel4.setText("VS");

        txtscoreBallTeam1.setText("scoreBallTeam1");

        txtScoreGoldTeam1.setText("scoreGoldTeam1");

        txtScoreBallTeam2.setText("scoreBallTeam2");

        txtScoreGoldTeam2.setText("scoreGoldTeam2");

        javax.swing.GroupLayout scorePanelLayout = new javax.swing.GroupLayout(scorePanel);
        scorePanel.setLayout(scorePanelLayout);
        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtscoreBallTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreGoldTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scorePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtScoreBallTeam2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtScoreGoldTeam2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtscoreBallTeam1)
                    .addComponent(txtScoreBallTeam2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtScoreGoldTeam1)
                    .addComponent(txtScoreGoldTeam2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/eject.gif"))); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonExitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headbandLayout = new javax.swing.GroupLayout(headband);
        headband.setLayout(headbandLayout);
        headbandLayout.setHorizontalGroup(
            headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headbandLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStepPlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSpeedUp)
                .addGap(87, 87, 87)
                .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        headbandLayout.setVerticalGroup(
            headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headbandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonStepPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSpeedUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headbandLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panSelectTeamMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMap.setText("Maps");

        buttonTteam2.setText("Team 2");
        buttonTteam2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonTteam2MousePressed(evt);
            }
        });

        buttonMapTeam1.setText("Team 1");
        buttonMapTeam1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMapTeam1MousePressed(evt);
            }
        });
        buttonMapTeam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        buttonGlobalMap.setText("Global");
        buttonGlobalMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonGlobalMapMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panSelectTeamMapLayout = new javax.swing.GroupLayout(panSelectTeamMap);
        panSelectTeamMap.setLayout(panSelectTeamMapLayout);
        panSelectTeamMapLayout.setHorizontalGroup(
            panSelectTeamMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelectTeamMapLayout.createSequentialGroup()
                .addGroup(panSelectTeamMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSelectTeamMapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonGlobalMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panSelectTeamMapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panSelectTeamMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonMapTeam1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonTteam2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panSelectTeamMapLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblMap, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panSelectTeamMapLayout.setVerticalGroup(
            panSelectTeamMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelectTeamMapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(buttonGlobalMap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTteam2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMapTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout panActionAvailableGlobaleLayout = new javax.swing.GroupLayout(panActionAvailableGlobale);
        panActionAvailableGlobale.setLayout(panActionAvailableGlobaleLayout);
        panActionAvailableGlobaleLayout.setHorizontalGroup(
            panActionAvailableGlobaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panActionAvailableGlobaleLayout.setVerticalGroup(
            panActionAvailableGlobaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        panActionAvailable.addTab("Global", panActionAvailableGlobale);

        javax.swing.GroupLayout panActionAvailableTeam1Layout = new javax.swing.GroupLayout(panActionAvailableTeam1);
        panActionAvailableTeam1.setLayout(panActionAvailableTeam1Layout);
        panActionAvailableTeam1Layout.setHorizontalGroup(
            panActionAvailableTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panActionAvailableTeam1Layout.setVerticalGroup(
            panActionAvailableTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        panActionAvailable.addTab("Team 1", panActionAvailableTeam1);

        javax.swing.GroupLayout panActionAvailableTeam2Layout = new javax.swing.GroupLayout(panActionAvailableTeam2);
        panActionAvailableTeam2.setLayout(panActionAvailableTeam2Layout);
        panActionAvailableTeam2Layout.setHorizontalGroup(
            panActionAvailableTeam2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panActionAvailableTeam2Layout.setVerticalGroup(
            panActionAvailableTeam2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        panActionAvailable.addTab("Team 2", panActionAvailableTeam2);

        jspanMap.setBackground(new java.awt.Color(255, 102, 102));
        jspanMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jspanMap.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jspanMap.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jspanMapMouseWheelMoved(evt);
            }
        });

        panZoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sldZoom.setMaximum(200);
        sldZoom.setMinimum(1);
        sldZoom.setValue(100);
        sldZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldZoomStateChanged(evt);
            }
        });

        lblZoom.setText("Zoom");

        javax.swing.GroupLayout panZoomLayout = new javax.swing.GroupLayout(panZoom);
        panZoom.setLayout(panZoomLayout);
        panZoomLayout.setHorizontalGroup(
            panZoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panZoomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panZoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panZoomLayout.createSequentialGroup()
                        .addComponent(sldZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panZoomLayout.createSequentialGroup()
                        .addComponent(lblZoom)
                        .addGap(69, 69, 69))))
        );
        panZoomLayout.setVerticalGroup(
            panZoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panZoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblZoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(sldZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headband, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panActionAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspanMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panSelectTeamMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headband, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panSelectTeamMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jspanMap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panActionAvailable))
                        .addGap(0, 11, 11))))
        );

        headband.getAccessibleContext().setAccessibleName("headband");
        headband.getAccessibleContext().setAccessibleDescription("");
        panActionAvailable.getAccessibleContext().setAccessibleName("tabPan");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitMousePressed
        // TODO add your handling code here:
        txtScoreGoldTeam1.setText("4");
        txtScoreGoldTeam2.setText("2");
    }//GEN-LAST:event_buttonExitMousePressed

    private void buttonPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPauseMousePressed
    }//GEN-LAST:event_buttonPauseMousePressed

    private void buttonPlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlayMousePressed
    }//GEN-LAST:event_buttonPlayMousePressed

    private void ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActionPerformed

    private void buttonMapTeam1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMapTeam1MousePressed
        panActionAvailable.setSelectedComponent(panActionAvailableTeam1);
    }//GEN-LAST:event_buttonMapTeam1MousePressed

    private void buttonTteam2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTteam2MousePressed
        panActionAvailable.setSelectedComponent(panActionAvailableTeam2);
    }//GEN-LAST:event_buttonTteam2MousePressed

    private void buttonGlobalMapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGlobalMapMousePressed
        panActionAvailable.setSelectedComponent(panActionAvailableGlobale);
    }//GEN-LAST:event_buttonGlobalMapMousePressed

    private void sldZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldZoomStateChanged
        // TODO add your handling code here:
        System.out.println("value changed");
        vc.setTaille(sldZoom.getValue());
        jspanMap.revalidate();
    }//GEN-LAST:event_sldZoomStateChanged

    private void jspanMapMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jspanMapMouseWheelMoved
        // TODO add your handling code here:
        sldZoom.setValue(sldZoom.getValue()-evt.getWheelRotation()*evt.getScrollAmount());
    }//GEN-LAST:event_jspanMapMouseWheelMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameGame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TestMap test2 = new TestMap();
                test2.startTest();
                Carte e = test2.getCarte();
                new FrameGame1(e).setVisible(true);


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonGlobalMap;
    private javax.swing.JButton buttonMapTeam1;
    private javax.swing.JButton buttonPause;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonSpeedUp;
    private javax.swing.JButton buttonStepPlay;
    private javax.swing.JButton buttonTteam2;
    private javax.swing.JPanel headband;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jspanMap;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblZoom;
    private javax.swing.JTabbedPane panActionAvailable;
    private javax.swing.JPanel panActionAvailableGlobale;
    private javax.swing.JPanel panActionAvailableTeam1;
    private javax.swing.JPanel panActionAvailableTeam2;
    private javax.swing.JPanel panSelectTeamMap;
    private javax.swing.JPanel panZoom;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JSlider sldZoom;
    private javax.swing.JLabel txtScoreBallTeam2;
    private javax.swing.JLabel txtScoreGoldTeam1;
    private javax.swing.JLabel txtScoreGoldTeam2;
    private javax.swing.JLabel txtscoreBallTeam1;
    // End of variables declaration//GEN-END:variables
}
