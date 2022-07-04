/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesspuzzlecreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class MainScreen extends javax.swing.JFrame {

    public static final int TILE_SIZE = 60;
    public static final int X_OFFSET = 60;
    public static final int Y_OFFSET = 60;
    private boolean down = false;
    private boolean placing = false;
    private boolean clearing = false;
    private Tile[][] allTiles = new Tile[8][8];
    private String colour;
    private String type;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        
       

        layeredPane= new JLayeredPane();
        JPanel bg =new JPanel();
        bg.setBackground(Color.BLACK);
        bg.setBounds(0,0,600,600);
        
        layeredPane.setForeground(Color.yellow);
        layeredPane.setPreferredSize(new Dimension(540, 540));
        layeredPane.setBorder(BorderFactory.createTitledBorder(
                ""));
        layeredPane.setBounds(0,0, 600, 600);
        this.add(layeredPane);
        MouseListener ml1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
               
            }

            @Override
            public void mousePressed(MouseEvent me) {
                down = true;
                if (down&&!placing&&!clearing) {
                    Tile thisGuy = (Tile) me.getComponent();
                    if (thisGuy.isSelected()) {

                        thisGuy.deselect(layeredPane);

                    } else {

                        thisGuy.select();

                    }
                }
                 if (placing) {
                    Tile thisGuy = (Tile) me.getComponent();
                    thisGuy.placePiece(colour, type, layeredPane);
                }
                 if (clearing) {
                    Tile thisGuy = (Tile) me.getComponent();
                    thisGuy.removePiece(layeredPane);
                    repaint();
                }
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                down = false;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                if (down&&!placing&&!clearing) {
                    Tile thisGuy = (Tile) me.getComponent();
                    if (thisGuy.isSelected()) {

                        thisGuy.deselect(layeredPane);

                    } else {

                        thisGuy.select();

                    }
                }
                if (placing&&down) {
                    Tile thisGuy = (Tile) me.getComponent();
                    thisGuy.placePiece(colour, type, layeredPane);
                }if (clearing&&down) {
                    Tile thisGuy = (Tile) me.getComponent();
                    thisGuy.removePiece(layeredPane);
                    repaint();
                }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile panel;
                if ((i + j) % 2 == 0) {
                    panel = new Tile(false);
                } else {
                    panel = new Tile(true);
                }
                panel.setBounds((i * TILE_SIZE) + X_OFFSET, (j * TILE_SIZE) + Y_OFFSET, TILE_SIZE, TILE_SIZE);
                panel.addMouseListener(ml1);
                allTiles[i][j] = panel;
                layeredPane.add(panel,1);
            }
        }

        initComponents();
        setButtonImages();
        
        pack();
         layeredPane.add(bg,65);
    }
    
    private void setButtonImages(){
        ImageIcon BlackPawn = new ImageIcon("./src/icons/BlackPawn.png");
        Image image = BlackPawn.getImage(); // transform it 
        Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        BlackPawn = new ImageIcon(newimg);
        blackPawnBtn.setIcon(BlackPawn);
        
        ImageIcon WhitePawn = new ImageIcon("./src/icons/WhitePawn.png");
        image = WhitePawn.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhitePawn = new ImageIcon(newimg);
        whitePawnBtn.setIcon(WhitePawn);

        ImageIcon BlackRook = new ImageIcon("./src/icons/BlackRook.png");
        image = BlackRook.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackRook = new ImageIcon(newimg);
        blackRookBtn.setIcon(BlackRook);
        
        ImageIcon WhiteRook = new ImageIcon("./src/icons/WhiteRook.png");
        image = WhiteRook.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteRook = new ImageIcon(newimg);
        whiteRookBtn.setIcon(WhiteRook);
        
        ImageIcon BlackKnight = new ImageIcon("./src/icons/BlackKnight.png");
        image = BlackKnight.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackKnight = new ImageIcon(newimg);
        blackKnightBtn.setIcon(BlackKnight);
        
        ImageIcon WhiteKnight = new ImageIcon("./src/icons/WhiteKnight.png");
        image = WhiteKnight.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteKnight = new ImageIcon(newimg);
        whiteKnightBtn.setIcon(WhiteKnight);
        
        ImageIcon BlackBishop = new ImageIcon("./src/icons/BlackBishop.png");
        image = BlackBishop.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackBishop = new ImageIcon(newimg);
        blackBishopBtn.setIcon(BlackBishop);
        
        ImageIcon WhiteBishop = new ImageIcon("./src/icons/WhiteBishop.png");
        image = WhiteBishop.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteBishop = new ImageIcon(newimg);
        whiteBishopBtn.setIcon(WhiteBishop);
        
        ImageIcon BlackQueen = new ImageIcon("./src/icons/BlackQueen.png");
        image = BlackQueen.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackQueen = new ImageIcon(newimg);
        blackQueenBtn.setIcon(BlackQueen);
        
        ImageIcon WhiteQueen = new ImageIcon("./src/icons/WhiteQueen.png");
        image = WhiteQueen.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteQueen = new ImageIcon(newimg);
        whiteQueenBtn.setIcon(WhiteQueen);
        
        ImageIcon BlackKing = new ImageIcon("./src/icons/BlackKing.png");
        image = BlackKing.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackKing = new ImageIcon(newimg);
        blackKingBtn.setIcon(BlackKing);
        
        ImageIcon WhiteKing = new ImageIcon("./src/icons/WhiteKing.png");
        image = WhiteKing.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteKing = new ImageIcon(newimg);
        whiteKingBtn.setIcon(WhiteKing);
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
        jButton4 = new javax.swing.JButton();
        blackPawnBtn = new javax.swing.JButton();
        whitePawnBtn = new javax.swing.JButton();
        ClearBTN = new javax.swing.JButton();
        blackKnightBtn = new javax.swing.JButton();
        whiteKnightBtn = new javax.swing.JButton();
        blackBishopBtn = new javax.swing.JButton();
        whiteBishopBtn = new javax.swing.JButton();
        blackRookBtn = new javax.swing.JButton();
        whiteRookBtn = new javax.swing.JButton();
        blackQueenBtn = new javax.swing.JButton();
        whiteQueenBtn = new javax.swing.JButton();
        blackKingBtn = new javax.swing.JButton();
        whiteKingBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 639));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setText("Tile Select");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        blackPawnBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackPawnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackPawnBtnActionPerformed(evt);
            }
        });

        whitePawnBtn.setBackground(new java.awt.Color(153, 153, 153));
        whitePawnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whitePawnBtnActionPerformed(evt);
            }
        });

        ClearBTN.setBackground(new java.awt.Color(153, 153, 153));
        ClearBTN.setText("Piece Eraser");
        ClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBTNActionPerformed(evt);
            }
        });

        blackKnightBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackKnightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackKnightBtnActionPerformed(evt);
            }
        });

        whiteKnightBtn.setBackground(new java.awt.Color(153, 153, 153));
        whiteKnightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteKnightBtnActionPerformed(evt);
            }
        });

        blackBishopBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackBishopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackBishopBtnActionPerformed(evt);
            }
        });

        whiteBishopBtn.setBackground(new java.awt.Color(153, 153, 153));
        whiteBishopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteBishopBtnActionPerformed(evt);
            }
        });

        blackRookBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackRookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackRookBtnActionPerformed(evt);
            }
        });

        whiteRookBtn.setBackground(new java.awt.Color(153, 153, 153));
        whiteRookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteRookBtnActionPerformed(evt);
            }
        });

        blackQueenBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackQueenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackQueenBtnActionPerformed(evt);
            }
        });

        whiteQueenBtn.setBackground(new java.awt.Color(153, 153, 153));
        whiteQueenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteQueenBtnActionPerformed(evt);
            }
        });

        blackKingBtn.setBackground(new java.awt.Color(153, 153, 153));
        blackKingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackKingBtnActionPerformed(evt);
            }
        });

        whiteKingBtn.setBackground(new java.awt.Color(153, 153, 153));
        whiteKingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteKingBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Reset Board");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClearBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(blackRookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(whiteRookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(blackPawnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(whitePawnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blackQueenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(whiteQueenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blackKnightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(whiteKnightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blackBishopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(whiteBishopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blackKingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(whiteKingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton4)
                .addGap(9, 9, 9)
                .addComponent(ClearBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackPawnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whitePawnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackKnightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whiteKnightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackBishopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whiteBishopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackRookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whiteRookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackQueenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whiteQueenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackKingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whiteKingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 760, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                allTiles[i][j].select();
                allTiles[i][j].removePiece(layeredPane);
            }
        }
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void blackPawnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackPawnBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="Pawn";
    }//GEN-LAST:event_blackPawnBtnActionPerformed

    private void whitePawnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whitePawnBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="Pawn";
    }//GEN-LAST:event_whitePawnBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearing=false;
        placing=false;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBTNActionPerformed
        clearing=true;
        placing=false;
    }//GEN-LAST:event_ClearBTNActionPerformed

    private void blackKnightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackKnightBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="Knight";
    }//GEN-LAST:event_blackKnightBtnActionPerformed

    private void blackBishopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackBishopBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="Bishop";
    }//GEN-LAST:event_blackBishopBtnActionPerformed

    private void blackRookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackRookBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="Rook";
    }//GEN-LAST:event_blackRookBtnActionPerformed

    private void blackQueenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackQueenBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="Queen";
    }//GEN-LAST:event_blackQueenBtnActionPerformed

    private void blackKingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackKingBtnActionPerformed
        placing=true;
        clearing=false;
        colour="Black";
        type="King";
    }//GEN-LAST:event_blackKingBtnActionPerformed

    private void whiteKnightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteKnightBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="Knight";
    }//GEN-LAST:event_whiteKnightBtnActionPerformed

    private void whiteBishopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteBishopBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="Bishop";
    }//GEN-LAST:event_whiteBishopBtnActionPerformed

    private void whiteRookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteRookBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="Rook";
    }//GEN-LAST:event_whiteRookBtnActionPerformed

    private void whiteQueenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteQueenBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="Queen";
    }//GEN-LAST:event_whiteQueenBtnActionPerformed

    private void whiteKingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteKingBtnActionPerformed
        placing=true;
        clearing=false;
        colour="White";
        type="King";
    }//GEN-LAST:event_whiteKingBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    private JLayeredPane layeredPane; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBTN;
    private javax.swing.JButton blackBishopBtn;
    private javax.swing.JButton blackKingBtn;
    private javax.swing.JButton blackKnightBtn;
    private javax.swing.JButton blackPawnBtn;
    private javax.swing.JButton blackQueenBtn;
    private javax.swing.JButton blackRookBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton whiteBishopBtn;
    private javax.swing.JButton whiteKingBtn;
    private javax.swing.JButton whiteKnightBtn;
    private javax.swing.JButton whitePawnBtn;
    private javax.swing.JButton whiteQueenBtn;
    private javax.swing.JButton whiteRookBtn;
    // End of variables declaration//GEN-END:variables
}
