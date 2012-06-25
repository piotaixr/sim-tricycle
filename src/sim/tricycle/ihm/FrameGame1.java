/*
 */
package sim.tricycle.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import sim.tricycle.AbstractJeu;
import sim.tricycle.Jeu;
import sim.tricycle.Ordonnanceur.Ordonnanceur;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.Boule;
import sim.tricycle.mapping.elementCase.Piece;
import sim.tricycle.robot.Model;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;
import sim.tricycle.utils.ObjectBuilder;

/**
 *
 * @author Morgan BIDOIS <morganbidois@gmail.com>
 */
public final class FrameGame1 extends javax.swing.JFrame implements Observer {

    private ViewCarte vc;
    private ViewMiniCarte vmc;
    private OrdonnanceurInterface oi = null;
    private AbstractJeu cont = null;

    /**
     *
     */
    public FrameGame1(AbstractJeu jeu) {
        initComponents();
        //AbstractCarte carte = jeu.getCarte();
        cont = jeu;

        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setSize(tk.getScreenSize().width, tk.getScreenSize().height);

        vc = new ViewCarte(jeu, -1);
        vmc = new ViewMiniCarte(jeu, vc, -1);

        panMiniMap.setLayout(new BorderLayout());
        vmc.setVisible(true);

        jspanMap.setViewportView(vc);
        panMiniMap.add(vmc);

        scorePanel.setLayout(new FlowLayout());

        addOrdonnaceur(ObjectBuilder.getOrdonnanceur());
     
        javax.swing.JPanel panGlobal = new javax.swing.JPanel();
        
        int i = 0;
        while (i < jeu.getTeamNumber()) {          
            
            addRessourceTeam(panGlobal, jeu.getTabTeams().get(i));
//        PanRessourceTeam panSelect = new PanRessourceTeam(t);
//
//           tabPanActionAvailable.add(createPanRessource(jeu.getTabTeams().get(i)));

            javax.swing.JPanel newPanTeam = createPanTeam(jeu.getTabTeams().get(i));
            addTabTeam(tabPanActionAvailable, newPanTeam, i);
            addScoreTeam(scorePanel, jeu.getTabTeams().get(i));
//            System.out.println("Pop defaut : " + i);
            popDefaultBot(jeu.getTabTeams().get(i));
            i++;
        }

        tabPanActionAvailable.setComponentAt(0, panGlobal);
        

        for (int Z = 0; Z < 40; Z++) {
            Piece p = new Piece();
            jeu.getCarte().popAlea(p);
        }
        //jeu.getCarte().pop(new Boule(), 10, 11);
         jeu.getCarte().popAlea(new Boule());
    }

    public void addOrdonnaceur(Ordonnanceur oi) {
        this.oi = oi;
        oi.addObserver(this);
    }

    public void addTabTeam(javax.swing.JTabbedPane tabpan, javax.swing.JPanel panteam, int index) {
        tabpan.addTab(cont.getTabTeams().get(index).getNomTeam(), panteam);
    }

    public void addPanAuto(javax.swing.JPanel pan, Model mod, Team t) {
        PanSelectModel panSelect = new PanSelectModel(mod, t, oi, cont);
        pan.add(panSelect);
        panSelect.getObs().addObserver(this);
    }

    public void addPansAutomateByTeam(javax.swing.JPanel pan, Team t) {
        for (Model m : t.getModel()) {
            addPanAuto(pan, m, t);
        }
    }

    public javax.swing.JPanel createPanTeam(Team t) {
        javax.swing.JPanel panteam = new javax.swing.JPanel();
        javax.swing.JPanel panteamAuto = new javax.swing.JPanel();
        javax.swing.JPanel panRessTeam = createPanRessource(t);

        panteam.setLayout(new BorderLayout());
        panteamAuto.setLayout(new BoxLayout(panteamAuto, BoxLayout.Y_AXIS));
        addPansAutomateByTeam(panteamAuto, t);

        panteam.add(panteamAuto, BorderLayout.CENTER);
        panteam.add(panRessTeam, BorderLayout.SOUTH);

        return panteam;
    }

    public void addRessourceTeam(javax.swing.JPanel pan, Team t) {
        PanRessourceTeam panSelect = new PanRessourceTeam(t);
        pan.add(panSelect);
    }

    public javax.swing.JPanel createPanRessource(Team t) {
        javax.swing.JPanel panteam = new javax.swing.JPanel();
        panteam.setLayout(new BorderLayout());
        addRessourceTeam(panteam, t);
        return panteam;
    }

    public void addScoreTeam(javax.swing.JPanel pan, Team t) {
        PanScoreTeam pst = new PanScoreTeam(t);
        pan.add(pst);
    }

    public javax.swing.JPanel createPanScore(Team t) {
        javax.swing.JPanel panteam = new javax.swing.JPanel();
        addRessourceTeam(panteam, t);
        return panteam;
    }

    public void popDefaultBot(Team t) {
        Case casePop = t.getMap().getCase(t.getBase().getPosition().getX(), t.getBase().getPosition().getY());
        Robot rob = t.getArmee().getFirst();
        t.getMap().pop(rob, casePop);
        oi.add(rob);

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
        buttonExit = new javax.swing.JButton();
        lblUnitTime = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(80, 0), new java.awt.Dimension(80, 0), new java.awt.Dimension(80, 32767));
        tabPanActionAvailable = new javax.swing.JTabbedPane();
        panActionAvailableGlobale = new javax.swing.JPanel();
        jspanMap = new javax.swing.JScrollPane();
        panZoom = new javax.swing.JPanel();
        sldZoom = new javax.swing.JSlider();
        lblZoom = new javax.swing.JLabel();
        panMiniMap = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AppliFrame");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        headband.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        headband.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buttonPause.setBackground(new java.awt.Color(204, 204, 255));
        buttonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/images/pause.gif"))); // NOI18N
        buttonPause.setText("Pause");
        buttonPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPauseMousePressed(evt);
            }
        });

        buttonPlay.setBackground(new java.awt.Color(204, 204, 255));
        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/images/arrow-right-play.gif"))); // NOI18N
        buttonPlay.setText("Play");
        buttonPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPlayMousePressed(evt);
            }
        });

        buttonStepPlay.setBackground(new java.awt.Color(204, 204, 255));
        buttonStepPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/images/arrow-right.gif"))); // NOI18N
        buttonStepPlay.setText("Step");
        buttonStepPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonStepPlayMousePressed(evt);
            }
        });

        buttonSpeedUp.setBackground(new java.awt.Color(204, 204, 255));
        buttonSpeedUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/images/arrow-fast-forward.gif"))); // NOI18N
        buttonSpeedUp.setText("Speed up");
        buttonSpeedUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonSpeedUpMousePressed(evt);
            }
        });

        scorePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout scorePanelLayout = new javax.swing.GroupLayout(scorePanel);
        scorePanel.setLayout(scorePanelLayout);
        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        buttonExit.setBackground(new java.awt.Color(204, 204, 255));
        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sim/tricycle/ihm/images/eject.gif"))); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExitMouseClicked(evt);
            }
        });

        lblUnitTime.setText("Time Unit :");

        lblTime.setText("0");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(lblUnitTime)
                .addGap(18, 18, 18)
                .addComponent(lblTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        headbandLayout.setVerticalGroup(
            headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headbandLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headbandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headbandLayout.createSequentialGroup()
                        .addGroup(headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonStepPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSpeedUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(headbandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonExit)
                                .addComponent(lblUnitTime)
                                .addComponent(lblTime)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headbandLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        tabPanActionAvailable.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanActionAvailableStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panActionAvailableGlobaleLayout = new javax.swing.GroupLayout(panActionAvailableGlobale);
        panActionAvailableGlobale.setLayout(panActionAvailableGlobaleLayout);
        panActionAvailableGlobaleLayout.setHorizontalGroup(
            panActionAvailableGlobaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        panActionAvailableGlobaleLayout.setVerticalGroup(
            panActionAvailableGlobaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        tabPanActionAvailable.addTab("Global", panActionAvailableGlobale);

        jspanMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jspanMap.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jspanMap.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jspanMapMouseWheelMoved(evt);
            }
        });

        panZoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sldZoom.setMaximum(220);
        sldZoom.setMinimum(30);
        sldZoom.setValue(100);
        sldZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldZoomStateChanged(evt);
            }
        });

        lblZoom.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(sldZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panMiniMap.setPreferredSize(new java.awt.Dimension(153, 167));

        javax.swing.GroupLayout panMiniMapLayout = new javax.swing.GroupLayout(panMiniMap);
        panMiniMap.setLayout(panMiniMapLayout);
        panMiniMapLayout.setHorizontalGroup(
            panMiniMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        panMiniMapLayout.setVerticalGroup(
            panMiniMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headband, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanActionAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspanMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panMiniMap, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headband, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jspanMap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tabPanActionAvailable))
                        .addGap(0, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(panMiniMap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        headband.getAccessibleContext().setAccessibleName("headband");
        headband.getAccessibleContext().setAccessibleDescription("");
        tabPanActionAvailable.getAccessibleContext().setAccessibleName("tabPan");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPauseMousePressed
        oi.stop();
    }//GEN-LAST:event_buttonPauseMousePressed

    private void buttonPlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlayMousePressed
        oi.setPeriod(oi.getDefaultPeriod());
        oi.start();
    }//GEN-LAST:event_buttonPlayMousePressed

    private void sldZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldZoomStateChanged
        // TODO add your handling code here:
        //System.out.println("value changed");
        vc.setTaille(sldZoom.getValue());
        jspanMap.revalidate();
    }//GEN-LAST:event_sldZoomStateChanged

    private void jspanMapMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jspanMapMouseWheelMoved
        // TODO add your handling code here:
        sldZoom.setValue(sldZoom.getValue() - evt.getWheelRotation() * evt.getScrollAmount());
    }//GEN-LAST:event_jspanMapMouseWheelMoved

    private void buttonStepPlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStepPlayMousePressed
        // TODO add your handling code here:
        oi.next();
    }//GEN-LAST:event_buttonStepPlayMousePressed

    private void buttonSpeedUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSpeedUpMousePressed
        // TODO add your handling code here:
        oi.setPeriod(oi.getPeriod() / 2);
    }//GEN-LAST:event_buttonSpeedUpMousePressed

    private void tabPanActionAvailableStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanActionAvailableStateChanged
        // TODO add your handling code here:
        if (cont != null) {
            panMiniMap.remove(vmc);
            vc = new ViewCarte(cont, tabPanActionAvailable.getSelectedIndex());
            vmc = new ViewMiniCarte(cont, vc, tabPanActionAvailable.getSelectedIndex());


            vmc.setVisible(true);


            jspanMap.setViewportView(vc);                    //////// A VOIR SI CA PREND PAS TROP DE TEMPS DE FAIRE CA A CHAQUE FOIS
            panMiniMap.add(vmc);

            jspanMap.repaint();
            panMiniMap.repaint();
//            repaint();
//            System.out.println("Map changée");

//            cont.getTabTeams().get(tabPanActionAvailable.getSelectedIndex() - 1).getMap().afficherCarte();
        }
    }//GEN-LAST:event_tabPanActionAvailableStateChanged

    private void buttonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitMouseClicked
        // TODO add your handling code here:
        AbstractJeu superGameDeLaMortQuiTue = new Jeu();
        FrameMenu fm = new FrameMenu(superGameDeLaMortQuiTue);
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonExitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main2(String args[]) {
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
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPause;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonSpeedUp;
    private javax.swing.JButton buttonStepPlay;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel headband;
    private javax.swing.JScrollPane jspanMap;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUnitTime;
    private javax.swing.JLabel lblZoom;
    private javax.swing.JPanel panActionAvailableGlobale;
    private javax.swing.JPanel panMiniMap;
    private javax.swing.JPanel panZoom;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JSlider sldZoom;
    private javax.swing.JTabbedPane tabPanActionAvailable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        Ordonnanceur ordo = (Ordonnanceur) oi;
        if (o.equals(ordo)) {
            lblTime.setText(String.valueOf(ordo.getTime()));
            //cont.getCarte().routinePt();
            if (ordo.getTime() >= ordo.getMaxTime()) {

                JOptionPane p = new JOptionPane("The Winner is team N°" + this.cont.getWinner());
                JDialog dlg = p.createDialog("Winner");
                dlg.setVisible(true);
                // showMessageDialog();

            }
            repaint();
        } else {
//            tabPanActionAvailableStateChanged(null);
            jspanMap.repaint();
            panMiniMap.repaint();
//            repaint();
//            System.out.println("COuCOU");
        }

    }
}
