/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesspuzzlecreator;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Tile extends JPanel {

    private Piece piece = null;
    private boolean selected = true;
    private boolean dark;

    public Tile(boolean dark) {
        this.dark = dark;
        if (dark) {
            this.setBackground(Color.decode("#d18b47"));
        } else {
            this.setBackground(Color.decode("#ffce9e"));
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void deselect(JLayeredPane lp) {
        selected = false;
        this.setBackground(Color.decode("#000000"));
        if (this.piece != null) {
            lp.remove(this.piece);
            this.piece = null;
        }
    }

    public void select() {
        selected = true;
        if (dark) {
            this.setBackground(Color.decode("#d18b47"));
        } else {
            this.setBackground(Color.decode("#ffce9e"));
        }

    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void placePiece(String colour, String type, JLayeredPane lp) {
        if (selected) {
            if (this.piece == null) {
                Piece p = new Piece(colour, type, this.getX() + 5, this.getY() + 5);
                lp.add(p, 0);
                this.piece = p;

            } else {
                lp.remove(this.piece);
                Piece p = new Piece(colour, type, this.getX() + 5, this.getY() + 5);
                lp.add(p, 0);
                this.piece = p;
            }
        }

    }

    public void removePiece(JLayeredPane lp) {
        if (this.piece != null) {
            lp.remove(this.piece);
            this.piece = null;
        }
    }

}
