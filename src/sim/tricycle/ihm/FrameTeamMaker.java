/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import sim.tricycle.AbstractJeu;
import sim.tricycle.Jeu;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.Base;
import sim.tricycle.robot.Automate;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;
import sim.tricycle.utils.ObjectBuilder;
import sim.tricycle.xmlparser.RobotParser;

/**
 *
 * @author morgan
 */
public final class FrameTeamMaker extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form FrameTeamMaker
     */
    private int teamNumber = 1;
    private int maxAutoByTeam = 3;
    private int defaultHeight;
    private AbstractJeu jeu = new Jeu();
    private RobotParser robPars;
    private FrameGame1 fg = null;
    //private PopupFactory ppFtry = new PopupFactory();

    public FrameTeamMaker(AbstractJeu paraJeu) {
        initComponents();

        jeu = paraJeu;
        ObjectBuilder o = new ObjectBuilder();
        robPars = o.getRobotParser();
        this.setLayout(new BorderLayout());
        this.add(panTitile, BorderLayout.PAGE_START);
        this.add(panFooter, BorderLayout.PAGE_END);
        this.add(tabPanTeams, BorderLayout.CENTER);



        this.defaultHeight = this.getSize().height;

//        javax.swing.JPanel panTeam = new javax.swing.JPanel();
//        tabPanTeams.addTab("team", panTeam);
//
//        panTeam.setLayout(new BoxLayout(panTeam, BoxLayout.Y_AXIS));
//
//        PanSelectAutomate panSelect = new PanSelectAutomate();
//        panTeam.add(panSelect);
//
//        System.out.println("hauteur frame : " + this.getHeight() + " taille pan :" + panSelect.getPreferredSize().height);
//         this.setSize(this.getWidth(), this.getHeight() + panSelect.getPreferredSize().height);
//
//        PanSelectAutomate panSelect1 = new PanSelectAutomate();
//        panTeam.add(panSelect1);
//
//        this.setSize(this.getWidth(), this.getHeight() + panSelect1.getPreferredSize().height);
//
//        PanSelectAutomate panSelect2 = new PanSelectAutomate();
//        panTeam.add(panSelect2);
//
//        this.setSize(this.getWidth(), this.getHeight() + panSelect2.getPreferredSize().height);
//        
//        javax.swing.JPanel panTeam2 = new javax.swing.JPanel();
//        tabPanTeams.addTab("team2", panTeam2);

        System.out.println("hauteur frame : " + this.getHeight() + " taille pan :" + tabPanTeams.getPreferredSize().height);

        jeu.getCarte().afficherCarte();
//        System.out.println(jeu.getTeamNumber());


        while (teamNumber <= jeu.getTeamNumber()) {
            javax.swing.JPanel newPanTeam = createPanTeam();
            addTabTeam(tabPanTeams, newPanTeam);
            //addPanAutomate(newPanTeam);
            //updateHeight(newPanTeam);
        }

    }

    public void addTabTeam(javax.swing.JTabbedPane tabpan, javax.swing.JPanel panteam) {
        String titleTab = "Team " + teamNumber;
        tabpan.addTab(titleTab, panteam);
        teamNumber++;
    }

    public void addPanAutomate(javax.swing.JPanel pan) {
        if (isPossibleToAddPan(pan)) {
            PanSelectAutomate panSelect = new PanSelectAutomate(this);
            pan.add(panSelect);
            panSelect.getObs().addObserver(this);
            updateHeight(pan);
        } else {
            //@TODO si temps ... pop up pour dire qu'on en fait pas plus
            //ppFtry.getPopup(this, "Coucou", 100, 100).show());      
        }
    }

    public void removePanAutomate(javax.swing.JPanel pan) {
        if (pan.getComponents().length >= 2) {
            pan.remove(pan.getComponent(pan.getComponents().length - 1));
            updateHeight(pan);
        }
    }

    public javax.swing.JPanel createPanTeam() {
        javax.swing.JPanel panteam = new javax.swing.JPanel();
        panteam.setLayout(new BoxLayout(panteam, BoxLayout.Y_AXIS));
        addPanAutomate(panteam);
        return panteam;
    }

    public void updateHeight(javax.swing.JPanel pan) {
        int numberComponent = pan.getComponents().length;
        this.setSize(this.getWidth(), defaultHeight + numberComponent * new PanSelectAutomate(this).getPreferredSize().height);
    }

    public boolean isValidPan(javax.swing.JPanel pan) {
        Component[] tabComp = pan.getComponents();
        for (Component c : tabComp) {
            if (c instanceof PanSelectAutomate) {
                if (!(((PanSelectAutomate) c).isValidPanAuto())) {
                    System.out.println("Check Pan pour : " + c.toString());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidFrame() {
        System.out.println(tabPanTeams.getTabCount());
        for (int i = 0; i < tabPanTeams.getTabCount(); i++) {
            Component c = tabPanTeams.getComponentAt(i);
            if (c instanceof javax.swing.JPanel) {
                if (!isValidPan((javax.swing.JPanel) c)) {
                    System.out.println("Check pour : " + i + " " + c.toString());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossibleToAddPan(javax.swing.JPanel pan) {
        return (pan.getComponents().length <= maxAutoByTeam);
    }

    public boolean isPossibleToDeletePan(javax.swing.JPanel pan) {
        return (2 <= pan.getComponents().length);
    }

    public void checkValidAll() {
        System.out.println("Je check!");
        if (isValidFrame()) {
            btnValid.setEnabled(true);
        } else {
            btnValid.setEnabled(false);
        }
    }

    public Team createTeam(int ident, String name) {
        Team t = new Team(ident, name, jeu.getCarte());
       // t.setBase(new Base(jeu.getCarte().getListeBase().get(ident)));       ----------------------------------------------------------
        Base b = new Base();
        jeu.getCarte().pop(b, new Case(jeu. getCarte().getListeBase().get(ident).getX(),jeu. getCarte().getListeBase().get(ident).getY()));
        t.setBase(b);
        return t;
    }

    public void createAllTeams() {
        for (int i = 0; i < tabPanTeams.getTabCount(); i++) {
            Team t = createTeam(i, tabPanTeams.getTitleAt(i));
            jeu.addTeam(t);
            createModels(t, i);
        }
    }

    public void createModels(Team t, int index) {
        javax.swing.JPanel pan = (javax.swing.JPanel) tabPanTeams.getComponentAt(index);
        Component[] tabcomp = pan.getComponents();
        for (Component c : tabcomp) {
            if (c instanceof PanSelectAutomate) {
                //pour éviter d'avoir une ligne de code indigerable
                String automateTxt = ((PanSelectAutomate) c).getStringAutomate();
                System.out.println(automateTxt);
                File f = new File(automateTxt);
                Automate auto = robPars.parse(f);
                t.addModel(new Robot(auto, t),((PanSelectAutomate) c).getStringImg());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddMod1 = new javax.swing.JButton();
        panTitile = new javax.swing.JPanel();
        lblSentence = new javax.swing.JLabel();
        panHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panFooter = new javax.swing.JPanel();
        btnAddMod = new javax.swing.JButton();
        btnValid = new javax.swing.JButton();
        btnRemoveMod = new javax.swing.JButton();
        tabPanTeams = new javax.swing.JTabbedPane();

        btnAddMod1.setText("Add Model");
        btnAddMod1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMod1MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panTitile.setBorder(null);

        lblSentence.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSentence.setText("Choose your automates and associate an image for each one of them. Max 4 differents automates");

        panHeader.setBackground(new java.awt.Color(85, 81, 78));
        panHeader.setBorder(null);
        panHeader.setForeground(new java.awt.Color(253, 251, 251));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(254, 254, 254));
        lblTitle.setText("Make the teams");

        javax.swing.GroupLayout panHeaderLayout = new javax.swing.GroupLayout(panHeader);
        panHeader.setLayout(panHeaderLayout);
        panHeaderLayout.setHorizontalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeaderLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panHeaderLayout.setVerticalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panHeaderLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addContainerGap())
        );

        javax.swing.GroupLayout panTitileLayout = new javax.swing.GroupLayout(panTitile);
        panTitile.setLayout(panTitileLayout);
        panTitileLayout.setHorizontalGroup(
            panTitileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panTitileLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblSentence)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        panTitileLayout.setVerticalGroup(
            panTitileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTitileLayout.createSequentialGroup()
                .addComponent(panHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSentence)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panFooter.setBackground(new java.awt.Color(85, 81, 78));
        panFooter.setBorder(null);

        btnAddMod.setText("Add Model");
        btnAddMod.setEnabled(false);
        btnAddMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddModMouseClicked(evt);
            }
        });

        btnValid.setText("Validate");
        btnValid.setEnabled(false);
        btnValid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidMouseClicked(evt);
            }
        });

        btnRemoveMod.setText("Remove Model");
        btnRemoveMod.setEnabled(false);
        btnRemoveMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveModMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panFooterLayout = new javax.swing.GroupLayout(panFooter);
        panFooter.setLayout(panFooterLayout);
        panFooterLayout.setHorizontalGroup(
            panFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFooterLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(btnAddMod, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveMod, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValid, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panFooterLayout.setVerticalGroup(
            panFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValid)
                    .addComponent(btnAddMod)
                    .addComponent(btnRemoveMod))
                .addContainerGap())
        );

        tabPanTeams.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanTeamsStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panTitile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabPanTeams))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTitile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabPanTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddModMouseClicked
        // TODO add your handling code here:
        //addPanAutomate((javax.swing.JPanel)tabPanTeams.getTabComponentAt(tabPanTeams.getSelectedIndex()));
        if (btnAddMod.isEnabled()) {
            addPanAutomate((javax.swing.JPanel) tabPanTeams.getSelectedComponent());
            btnRemoveMod.setEnabled(true);
            btnAddMod.setEnabled(false);
        }
        checkValidAll();
    }//GEN-LAST:event_btnAddModMouseClicked

    private void tabPanTeamsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanTeamsStateChanged
        // TODO add your handling code here:
        updateHeight((javax.swing.JPanel) tabPanTeams.getSelectedComponent());
        btnAddMod.setEnabled(false);
        if (isPossibleToDeletePan((javax.swing.JPanel) tabPanTeams.getSelectedComponent())) {
            btnRemoveMod.setEnabled(true);
        } else {
            btnRemoveMod.setEnabled(false);
        }
    }//GEN-LAST:event_tabPanTeamsStateChanged

    private void btnAddMod1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMod1MouseClicked
        // TODO add your handling code here:
        //Fake bouton créé sur une erreur ...
    }//GEN-LAST:event_btnAddMod1MouseClicked

    private void btnRemoveModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveModMouseClicked
        // TODO add your handling code here:
        removePanAutomate((javax.swing.JPanel) tabPanTeams.getSelectedComponent());
        if (isPossibleToDeletePan((javax.swing.JPanel) tabPanTeams.getSelectedComponent())) {
            btnRemoveMod.setEnabled(true);
        } else {
            btnRemoveMod.setEnabled(false);
        }
        checkValidAll();
    }//GEN-LAST:event_btnRemoveModMouseClicked

    private void btnValidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidMouseClicked
        // TODO add your handling code here:
        createAllTeams();
//        for (Team t : jeu.getTabTeams()) {
//            System.out.println(t.getNomTeam());
//            for (Robot mod : t.getModel()) {
//                System.out.println("" + mod.getAutomate());
//            }
//        }
        if (fg == null) {
            fg = new FrameGame1(jeu);
            fg.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnValidMouseClicked

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
            java.util.logging.Logger.getLogger(FrameTeamMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTeamMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTeamMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTeamMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AbstractJeu jeu = new Jeu();
                new FrameTeamMaker(jeu).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMod;
    private javax.swing.JButton btnAddMod1;
    private javax.swing.JButton btnRemoveMod;
    private javax.swing.JButton btnValid;
    private javax.swing.JLabel lblSentence;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panFooter;
    private javax.swing.JPanel panHeader;
    private javax.swing.JPanel panTitile;
    private javax.swing.JTabbedPane tabPanTeams;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("event recu!!");
        if (isPossibleToAddPan((javax.swing.JPanel) tabPanTeams.getSelectedComponent())) {
            btnAddMod.setEnabled(true);
        }
        checkValidAll();
    }
}
