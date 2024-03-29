package userInterface;

import entities.Score;
import entities.command.Command;
import entities.command.CommandType;
import games.GenericGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Time;
import javax.swing.*;

import main.TimeThread;
import main.FileManager;
import main.scoreRest.RestHandling;
import userInterface.dialogs.*;
import userInterface.printer.MyTextArea;
import userInterface.printer.MyTimeLabel;
import parser.Parser;
import parser.PhraseReduction;

/**
 * @author enrico
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private GenericGame game;

    private Parser parser;

    private static TimeThread timer;

    public GUI() {
        initComponents();
        init();
        timer = new TimeThread(game.getActualTime(), jTime);
        timer.start();
    }

    private void init() {
        try {
//          Carico il salvataggio da file di default il cui path è specificato in config.txt
            setGame(FileManager.loadDefaultPath());
            parser = (Parser) Class.forName(FileManager.loadLanguage()).newInstance();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "\nModifica il file config.txt e riavvia l'applicazione", "Errore", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

        jTextField.requestFocus();
    }

    /**
     * Stampa un linea di "======" come separatore
     */
    private void printLine() {
        jTextArea.println("");
        for (int i = 0; i < 160; i++) {
            jTextArea.print("=");
        }
        jTextArea.println("=");
    }

    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanelRight = new javax.swing.JPanel();
        jTime = new MyTimeLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButtonNord = new javax.swing.JButton();
        jButtonSud = new javax.swing.JButton();
        jButtonEst = new javax.swing.JButton();
        jButtonWest = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new MyTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTextField = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelLeft = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPoints = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemLoad = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuInfo = new javax.swing.JMenu();
        jMenuItemClear = new javax.swing.JMenuItem();
        jMenuItemRanking = new javax.swing.JMenuItem();
        jMenuItemCommands = new javax.swing.JMenuItem();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItemCredits = new javax.swing.JMenuItem();
        jMenuItemDesc = new javax.swing.JMenuItem();

        jToggleButton1.setText("jToggleButton1");

        setTitle("Game Engine");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jTime.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTime.setText("15:00");

        jTextField.setFont(jTextField.getFont().deriveFont((float) 16).deriveFont(Font.PLAIN));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Time Left");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton2.setIcon(new javax.swing.ImageIcon("./src/main/resources/gui_images/button.png")); // NOI18N
        jPanel1.add(jButton2, java.awt.BorderLayout.CENTER);

        jButtonNord.setIcon(new javax.swing.ImageIcon("./src/main/resources/gui_images/up-arrow.png")); // NOI18N
        jButtonNord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNordActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNord, java.awt.BorderLayout.PAGE_START);

        jButtonSud.setIcon(new javax.swing.ImageIcon("./src/main/resources/gui_images/down_arrow.png")); // NOI18N
        jButtonSud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSudActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSud, java.awt.BorderLayout.PAGE_END);

        jButtonEst.setIcon(new javax.swing.ImageIcon("./src/main/resources/gui_images/right-arrow.png")); // NOI18N
        jButtonEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEst, java.awt.BorderLayout.LINE_END);

        jButtonWest.setIcon(new javax.swing.ImageIcon("./src/main/resources/gui_images/left-arrow.png")); // NOI18N
        jButtonWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonWest, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
                jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRightLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(jTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelRightLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelRightLayout.setVerticalGroup(
                jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRightLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTime, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(435, Short.MAX_VALUE))
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelRightLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelRight, java.awt.BorderLayout.LINE_END);

        jPanelMain.setLayout(new java.awt.BorderLayout());

        jTextArea.setEditable(false);
        jTextArea.setFont(jTextArea.getFont().deriveFont((float) 16.0));
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        jPanelMain.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jTextField, java.awt.BorderLayout.CENTER);

        jButtonSend.setText("SEND");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSend, java.awt.BorderLayout.LINE_END);

        jLabel1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jLabel1.setText("Developed by Enrico Pallotta");
        jLabel1.setFont(jLabel1.getFont().deriveFont(13));
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        jPanelMain.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabelTitle.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("TITOLO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Points");

        jPoints.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPoints.setText("0");

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
                jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(jPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLeftLayout.setVerticalGroup(
                jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLeftLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(435, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelLeft, java.awt.BorderLayout.LINE_START);

        InputMap imTextField = jTextField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imTextField.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        Action send = new ActionSend();
        jTextField.getActionMap().put("enter", send);

        InputMap imNord = jButtonNord.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imNord.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "nord");
        Action nord = new ActionNord();
        jButtonNord.getActionMap().put("nord", nord);

        InputMap imSud = jButtonSud.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imSud.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "sud");
        Action sud = new ActionSud();
        jButtonSud.getActionMap().put("sud", sud);

        InputMap imEst = jButtonEst.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imEst.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "est");
        Action est = new ActionEst();
        jButtonEst.getActionMap().put("est", est);

        InputMap imWest = jButtonWest.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imWest.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "west");
        Action west = new ActionWest();
        jButtonWest.getActionMap().put("west", west);

        jMenuFile.setText("File");

        jMenuItemNew.setText("New");
        jMenuItemNew.setIcon(new ImageIcon("./src/main/resources/gui_images/new.png"));
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemLoad.setText("Load");
        jMenuItemLoad.setIcon(new ImageIcon("./src/main/resources/gui_images/loading.png"));
        jMenuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoadActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLoad);

        jMenuItemSave.setText("Save");
        jMenuItemSave.setIcon(new ImageIcon("./src/main/resources/gui_images/save.png"));
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuView.setText("View");

        jMenuItemClear.setText("Clear");
        jMenuItemClear.setIcon(new ImageIcon("./src/main/resources/gui_images/eraser.png"));
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextArea.clear();
            }
        });
        jMenuView.add(jMenuItemClear);

        jMenuItemRanking.setText("Rankings");
        jMenuItemRanking.setIcon(new ImageIcon("./src/main/resources/gui_images/first.png"));
        jMenuItemRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRankingActionPerformed(evt);
            }
        });
        jMenuView.add(jMenuItemRanking);

        jMenuItemCommands.setText("Commands");
        jMenuItemCommands.setIcon(new ImageIcon("./src/main/resources/gui_images/commands.png"));
        jMenuItemCommands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCommandsActionPerformed(evt);
            }
        });

        jMenuView.add(jMenuItemCommands);
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenuView);

        jMenuInfo.setText("Info");

        jMenuItemHelp.setText("Help");
        jMenuItemHelp.setIcon(new ImageIcon("./src/main/resources/gui_images/helpIcon.png"));
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemHelp);

        jMenuItemCredits.setText("Credits");
        jMenuItemCredits.setIcon(new ImageIcon("./src/main/resources/gui_images/info.png"));
        jMenuItemCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreditsActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemCredits);

        jMenuItemDesc.setText("Descrizione");
        jMenuItemDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDescActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemDesc);


        jMenuBar1.add(jMenuInfo);

        setJMenuBar(jMenuBar1);
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        pack();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        exit(JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_formWindowClosing

    private void exit(int option){
        int opt = JOptionPane.showConfirmDialog(this, "Vuoi salvare?","Salva",option);
        if(opt == JOptionPane.YES_OPTION){
            save();
            System.exit(0);
        }
        else if(opt == JOptionPane.NO_OPTION){
            this.dispose();
            System.exit(0);
        }
    }

    private void save(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./src/main/resources/savings"));
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileManager.saveGame(fileChooser.getSelectedFile().getAbsolutePath(), game);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showDescription(){
        Dialog desc = new DescriptionDialog(this, true, game.getDescription());
        desc.setVisible(true);
    }

    private void jMenuItemRankingActionPerformed(java.awt.event.ActionEvent evt) {
        Dialog ranking = new RankingDialog(this, true, RestHandling.getScore(), game.getName());
        ranking.setVisible(true);
    }

    private void jMenuItemCommandsActionPerformed(java.awt.event.ActionEvent evt) {
        Dialog commandDialog = new CommandDialog(this, true, game.getCommandList());
        commandDialog.setVisible(true);
    }

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {
        Dialog help = new HelpDialog(this, true);
        help.setVisible(true);
    }

    private void jMenuItemCreditsActionPerformed(java.awt.event.ActionEvent evt) {
        Dialog credits = new CreditsDialog(this, true);
        credits.setVisible(true);
    }

    private void jMenuItemDescActionPerformed(java.awt.event.ActionEvent evt) {
        showDescription();
    }

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(this, "Vuoi resettare la partita?", "New game", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                setGame(FileManager.loadDefaultPath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Errore nel caricare il file", "Errore File", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jMenuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./src/main/resources/savings"));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                setGame(fileChooser.getSelectedFile().getPath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Errore nel caricare il file", "Errore File", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {
        save();
    }

    private void jButtonNordActionPerformed(java.awt.event.ActionEvent evt) {
        new ActionNord().actionPerformed(evt);
    }

    private void jButtonEstActionPerformed(java.awt.event.ActionEvent evt) {
        new ActionEst().actionPerformed(evt);
    }

    private void jButtonWestActionPerformed(java.awt.event.ActionEvent evt) {
        new ActionWest().actionPerformed(evt);
    }

    private void jButtonSudActionPerformed(java.awt.event.ActionEvent evt) {
        new ActionSud().actionPerformed(evt);
    }

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {
        new ActionSend().actionPerformed(evt);
    }

    private void setGame(String path) throws Exception {
        game = FileManager.loadGame(path);
        game.setOut(jTextArea);
        jTextArea.clear();
        jLabelTitle.setText(game.getName());
        jPoints.setText(String.valueOf(game.getActualPoints()));
        jTime.setText(game.getActualTime().toString());
        if (timer != null)
            timer.setTime(game.getActualTime());
        jTextArea.println(game.getIntro());
        printLine();
        jTextArea.println("\n" + game.getCurrentRoom().getName() + " : " + game.getCurrentRoom().getDescription());
        printLine();
        jTime.setText(game.getActualTime().toString().substring(3));
        showDescription();
    }

    public class ActionSend extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (!jTextField.getText().isBlank()) {
                commandExecute(jTextField.getText());
                jTextField.setText("");
            }

        }
    }

    public class ActionNord extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            for (Command command : game.getCommandList()) {
                if (command.getType() == CommandType.NORD) {
                    commandExecute(command.getName());
                    break;
                }
            }
        }
    }

    public class ActionSud extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            for (Command command : game.getCommandList()) {
                if (command.getType() == CommandType.SUD) {
                    commandExecute(command.getName());
                    break;
                }
            }
        }
    }

    public class ActionEst extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            for (Command command : game.getCommandList()) {
                if (command.getType() == CommandType.EST) {
                    commandExecute(command.getName());
                    break;
                }
            }
        }
    }

    public class ActionWest extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            for (Command command : game.getCommandList()) {
                if (command.getType() == CommandType.OVEST) {
                    commandExecute(command.getName());
                    break;
                }
            }
        }
    }

    private void commandExecute(String command) {
        jTextArea.println("");
        if (!game.isCompleted()) {
            try {
                PhraseReduction attualCommand = parser.analyze(command, game.getCurrentRoom(), game.getCommandList(), game.getMainCharacter());
                if (attualCommand.getCommand() != null && attualCommand.getCommand().getType() == CommandType.END) {
                    exit(JOptionPane.YES_NO_CANCEL_OPTION);
                } else if (attualCommand.getCommand() != null) {
                    System.out.println(attualCommand);
                    try {
                        game.actionHandler(attualCommand);
                        if (game.getCurrentRoom().getEventHandler() != null && game.getCurrentRoom().getEventHandler().getEvent().isStarted() && !game.getCurrentRoom().getEventHandler().getEvent().isCompleted()) {
                            game.getCurrentRoom().getEventHandler().completeEvent(game, jTextArea);
                            jPoints.setText(String.valueOf(game.getActualPoints()));
                            if (game.getActualPoints() == game.getPointGoal()) {
                                game.setCompleted(true);
                                JDialog ending = new EndingDialog(this, true, new Score(new Time(game.getTotalTime().getTime() - game.getActualTime().getTime()), game.getActualPoints(), game.getPointGoal(), game.getName()), game.getWin());
                                ending.setVisible(true);
                            }
                        }
                    } catch (Exception ex) {
                        jTextArea.print(ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                jTextArea.print(ex.getMessage());
            } finally {
                jTextArea.println("");
                printLine();
                jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
            }
        } else {
            JOptionPane.showMessageDialog(this, "La partita è terminata!", "Partita terminata", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public GenericGame getGame() {
        return game;
    }

    public static TimeThread getTimer() {
        return timer;
    }

    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEst;
    private javax.swing.JButton jButtonNord;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonSud;
    private javax.swing.JButton jButtonWest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenuItem jMenuItemClear;
    private javax.swing.JMenuItem jMenuItemRanking;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemCredits;
    private javax.swing.JMenuItem jMenuItemDesc;
    private javax.swing.JMenuItem jMenuItemCommands;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JLabel jPoints;
    private javax.swing.JScrollPane jScrollPane2;
    private MyTextArea jTextArea;
    private javax.swing.JTextField jTextField;
    private MyTimeLabel jTime;
    private javax.swing.JToggleButton jToggleButton1;
}
