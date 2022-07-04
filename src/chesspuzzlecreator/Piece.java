/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesspuzzlecreator;

import static chesspuzzlecreator.MainScreen.TILE_SIZE;
import static chesspuzzlecreator.MainScreen.X_OFFSET;
import static chesspuzzlecreator.MainScreen.Y_OFFSET;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Piece extends JLabel {

    private String colour;
    private String type;
    private double oldX, oldY;

    public Piece(String colour, String type, int x, int y) {
        this.colour = colour;
        this.type = type;
        move(x, y);

        //Imports piece icons from icon folder
        ImageIcon BlackPawn = new ImageIcon("./src/icons/BlackPawn.png");
        Image image = BlackPawn.getImage(); // transform it 
        Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        BlackPawn = new ImageIcon(newimg);

        ImageIcon WhitePawn = new ImageIcon("./src/icons/WhitePawn.png");
        image = WhitePawn.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhitePawn = new ImageIcon(newimg);

        ImageIcon BlackRook = new ImageIcon("./src/icons/BlackRook.png");
        image = BlackRook.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackRook = new ImageIcon(newimg);
        
        ImageIcon WhiteRook = new ImageIcon("./src/icons/WhiteRook.png");
        image = WhiteRook.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteRook = new ImageIcon(newimg);
        
        ImageIcon BlackKnight = new ImageIcon("./src/icons/BlackKnight.png");
        image = BlackKnight.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackKnight = new ImageIcon(newimg);
        
        ImageIcon WhiteKnight = new ImageIcon("./src/icons/WhiteKnight.png");
        image = WhiteKnight.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteKnight = new ImageIcon(newimg);
        
        ImageIcon BlackBishop = new ImageIcon("./src/icons/BlackBishop.png");
        image = BlackBishop.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackBishop = new ImageIcon(newimg);
        
        ImageIcon WhiteBishop = new ImageIcon("./src/icons/WhiteBishop.png");
        image = WhiteBishop.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteBishop = new ImageIcon(newimg);
        
        ImageIcon BlackQueen = new ImageIcon("./src/icons/BlackQueen.png");
        image = BlackQueen.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackQueen = new ImageIcon(newimg);
        
        ImageIcon WhiteQueen = new ImageIcon("./src/icons/WhiteQueen.png");
        image = WhiteQueen.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteQueen = new ImageIcon(newimg);
        
        ImageIcon BlackKing = new ImageIcon("./src/icons/BlackKing.png");
        image = BlackKing.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        BlackKing = new ImageIcon(newimg);
        
        ImageIcon WhiteKing = new ImageIcon("./src/icons/WhiteKing.png");
        image = WhiteKing.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        WhiteKing = new ImageIcon(newimg);
        
        //Sets the correct image to the piece when it is displayed
        if (colour.equals("Black")) {
            if (null != type) {
                switch (type) {
                    case "Pawn":
                        this.setIcon(BlackPawn);
                        break;
                    case "Rook":
                        this.setIcon(BlackRook);
                        break;
                    case "Knight":
                        this.setIcon(BlackKnight);
                        break;
                    case "Bishop":
                        this.setIcon(BlackBishop);
                        break;
                    case "Queen":
                        this.setIcon(BlackQueen);
                        break;
                    case "King":
                        this.setIcon(BlackKing);
                        break;
                    default:
                        break;
                }
            }

        } else {
            if (null != type) {
                switch (type) {
                    case "Pawn":
                        this.setIcon(WhitePawn);
                        break;
                    case "Rook":
                        this.setIcon(WhiteRook);
                        break;
                    case "Knight":
                        this.setIcon(WhiteKnight);
                        break;
                    case "Bishop":
                        this.setIcon(WhiteBishop);
                        break;
                    case "Queen":
                        this.setIcon(WhiteQueen);
                        break;
                    case "King":
                        this.setIcon(WhiteKing);
                        break;
                    default:
                        break;
                }
            }
        }
        this.setBounds(x, y,60,60);

    }

    public void move(int x, int y) {
        oldX = x * TILE_SIZE + (MainScreen.TILE_SIZE * 1.5);
        oldY = y * MainScreen.TILE_SIZE + (MainScreen.TILE_SIZE * 1.5);

    }

}
