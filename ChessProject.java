/*
Sai Avula
2.28.24
ChessProject.java
Chess Game for fun
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChessProject extends JFrame
{
    //This is the main where i created and instance of the class and ran the run method
    public static void main (String [] args)
    {
        ChessProject hg2016 = new ChessProject();
        hg2016.run();
    }
    //Run Method where I created the Frame and runs the HGPanel class
    public void run()
    {
        JFrame frame = new JFrame("Chess Game");
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // or JFrame.EXIT_ON_CLOSE); or frame.EXIT_ON_CLOSE);
        frame.setLocation(400,50);
        frame.setResizable(true);
        HGPanel hgp = new HGPanel();
        frame.setContentPane(hgp);  // OR frame.getContentPane().add(p_in);
        frame.setVisible(true);
        hgp.grabFocus();
    }
}

class HGPanel extends JPanel implements MouseListener {

    Rectangle[][] squares;
    Point[][] squarepoint;
    int x, y;
    Image green;
    Image white;
    int oddcounter;
    Image whiterook1, whiterook2;
    Image whitebishop1, whitebishop2;
    Image whitehorse1, whitehorse2;
    Image whiteking, whitequeen;
    Image whitepawn1, whitepawn2, whitepawn3, whitepawn4, whitepawn5, whitepawn6;
    Image whitepawn7, whitepawn8;
    Rectangle wrookrect1, wrookrect2, wbishoprect1, wbishoprect2;
    Rectangle whorserect1, whorserect2, wkingrect, wqueenrect;
    Rectangle[] wpawnrect;
    Image blackrook1, blackrook2;
    Image blackbishop1, blackbishop2;
    Image blackhorse1, blackhorse2;
    Image blackking, blackqueen;
    Image blackpawn1, blackpawn2, blackpawn3, blackpawn4, blackpawn5, blackpawn6;
    Image blackpawn7, blackpawn8;
    Rectangle bl_rookrect1, bl_rookrect2, bl_bishoprect1, bl_bishoprect2;
    Rectangle bl_horserect1, bl_horserect2, bl_kingrect, bl_queenrect;
    Rectangle[] bl_pawnrect;
    // Constructor where I declare all of the variables
    public HGPanel() {
        setBackground(Color.green);
        y = 0;
        x = 8;
        addMouseListener(this);
        whiterook1 = new ImageIcon("White_Rook.png").getImage();
        whiterook2 = new ImageIcon("White_Rook.png").getImage();
        whitehorse1 = new ImageIcon("White_Horse.png").getImage();
        whitehorse2 = new ImageIcon("White_Horse.png").getImage();
        whitebishop1 = new ImageIcon("White_Bishop.png").getImage();
        whitebishop2 = new ImageIcon("White_Bishop.png").getImage();
        whiteking = new ImageIcon("White_King.png").getImage();
        whitequeen = new ImageIcon("White_Queen.png").getImage();
        whitepawn1 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn2 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn3 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn4 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn6 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn7 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn8 = new ImageIcon("White_Pawn.png").getImage();
        whitepawn5 = new ImageIcon("White_Pawn.png").getImage();
        blackrook1 = new ImageIcon("Black_Rook.png").getImage();
        blackrook2 = new ImageIcon("Black_Rook.png").getImage();
        blackhorse1 = new ImageIcon("Black_Horse.png").getImage();
        blackhorse2 = new ImageIcon("Black_Horse.png").getImage();
        blackbishop1 = new ImageIcon("Black_Bishop.png").getImage();
        blackbishop2 = new ImageIcon("Black_Bishop.png").getImage();
        blackking = new ImageIcon("Black_King.png").getImage();
        blackqueen = new ImageIcon("Black_Queen.png").getImage();
        blackpawn1 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn2 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn3 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn4 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn6 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn7 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn8 = new ImageIcon("Black_Pawn.png").getImage();
        blackpawn5 = new ImageIcon("Black_Pawn.png").getImage();

        squares = new Rectangle[8][8];
        squarepoint = new Point[8][8];
        wpawnrect = new Rectangle[8];
        bl_pawnrect = new Rectangle[8];
        for (int i = 0; i < 8; i++) {
            for (int n = 0; n < 8; n++) {
                squarepoint[i][n] = new Point(x, y);
                y += 90;
            }
            y = 0;
            x += 90;
        }
        green = new ImageIcon("GreenSquare.png").getImage();
        white = new ImageIcon("WhiteSquare.png").getImage();
        for (int i = 0; i < 8; i++) {
            for (int n = 0; n < 8; n++) {
                squares[i][n] = new Rectangle((int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90);
            }
        }
        // Rectangles for all of the white pieces
        wrookrect1 = new Rectangle((int) squarepoint[0][7].getX(), (int) squarepoint[0][7].getY(), 90, 90);
        wrookrect2 = new Rectangle((int) squarepoint[7][7].getX(), (int) squarepoint[7][7].getY(), 90, 90);
        whorserect1 = new Rectangle((int) squarepoint[1][7].getX(), (int) squarepoint[1][7].getY(), 90, 90);
        whorserect2 = new Rectangle((int) squarepoint[6][7].getX(), (int) squarepoint[6][7].getY(), 90, 90);
        wbishoprect1 = new Rectangle((int) squarepoint[2][7].getX(), (int) squarepoint[2][7].getY(), 90, 90);
        wbishoprect2 = new Rectangle((int) squarepoint[5][7].getX(), (int) squarepoint[5][7].getY(), 90, 90);
        wkingrect = new Rectangle((int) squarepoint[3][7].getX(), (int) squarepoint[3][7].getY(), 90, 90);
        wqueenrect = new Rectangle((int) squarepoint[4][7].getX(), (int) squarepoint[4][7].getY(), 90, 90);
        wpawnrect[0] = new Rectangle((int) squarepoint[0][6].getX(), (int) squarepoint[0][6].getY(), 90, 90);
        wpawnrect[1] = new Rectangle((int) squarepoint[1][6].getX(), (int) squarepoint[1][6].getY(), 90, 90);
        wpawnrect[2] = new Rectangle((int) squarepoint[2][6].getX(), (int) squarepoint[2][6].getY(), 90, 90);
        wpawnrect[3] = new Rectangle((int) squarepoint[3][6].getX(), (int) squarepoint[3][6].getY(), 90, 90);
        wpawnrect[4] = new Rectangle((int) squarepoint[4][6].getX(), (int) squarepoint[4][6].getY(), 90, 90);
        wpawnrect[5] = new Rectangle((int) squarepoint[5][6].getX(), (int) squarepoint[5][6].getY(), 90, 90);
        wpawnrect[6] = new Rectangle((int) squarepoint[6][6].getX(), (int) squarepoint[6][6].getY(), 90, 90);
        wpawnrect[7] = new Rectangle((int) squarepoint[7][6].getX(), (int) squarepoint[7][6].getY(), 90, 90);

        // Rectangles for all of the black pieces 
        bl_rookrect1 = new Rectangle((int) squarepoint[0][0].getX(), (int) squarepoint[0][0].getY(), 90, 90);
        bl_rookrect2 = new Rectangle((int) squarepoint[7][0].getX(), (int) squarepoint[7][0].getY(), 90, 90);
        bl_horserect1 = new Rectangle((int) squarepoint[1][0].getX(), (int) squarepoint[1][0].getY(), 90, 90);
        bl_horserect2 = new Rectangle((int) squarepoint[6][0].getX(), (int) squarepoint[6][0].getY(), 90, 90);
        bl_bishoprect1 = new Rectangle((int) squarepoint[2][0].getX(), (int) squarepoint[2][0].getY(), 90, 90);
        bl_bishoprect2 = new Rectangle((int) squarepoint[5][0].getX(), (int) squarepoint[5][0].getY(), 90, 90);
        bl_kingrect = new Rectangle((int) squarepoint[3][0].getX(), (int) squarepoint[3][0].getY(), 90, 90);
        bl_queenrect = new Rectangle((int) squarepoint[4][0].getX(), (int) squarepoint[4][0].getY(), 90, 90);
        bl_pawnrect[0] = new Rectangle((int) squarepoint[0][1].getX(), (int) squarepoint[0][1].getY(), 90, 90);
        bl_pawnrect[1] = new Rectangle((int) squarepoint[1][1].getX(), (int) squarepoint[1][1].getY(), 90, 90);
        bl_pawnrect[2] = new Rectangle((int) squarepoint[2][1].getX(), (int) squarepoint[2][1].getY(), 90, 90);
        bl_pawnrect[3] = new Rectangle((int) squarepoint[3][1].getX(), (int) squarepoint[3][1].getY(), 90, 90);
        bl_pawnrect[4] = new Rectangle((int) squarepoint[4][1].getX(), (int) squarepoint[4][1].getY(), 90, 90);
        bl_pawnrect[5] = new Rectangle((int) squarepoint[5][1].getX(), (int) squarepoint[5][1].getY(), 90, 90);
        bl_pawnrect[6] = new Rectangle((int) squarepoint[6][1].getX(), (int) squarepoint[6][1].getY(), 90, 90);
        bl_pawnrect[7] = new Rectangle((int) squarepoint[7][1].getX(), (int) squarepoint[7][1].getY(), 90, 90);

    }
    //paintcomponent is where I draw all of my Images
    public void paintComponent(Graphics g) {
        //I use this for loop to break the 2D array and as a result it draws all of the chess squares
        for (int i = 0; i < 8; i++) {
            if(i % 2 == 1) oddcounter = 0;
            else oddcounter = 1;
            for (int n = 0; n < 8; n++)
            {
                if(oddcounter % 2 == 1)
                {
                    g.drawImage(green,(int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90, null);
                }
                else if(oddcounter % 2 == 0)
                {
                    g.drawImage(white,(int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90, null);
                }
                oddcounter++;
            }
        }

        // This is where I draw all of the white pieces
        g.drawImage(whiterook1, (int)wrookrect1.getX(), (int)wrookrect1.getY(), 90, 90, null);
        g.drawImage(whiterook2, (int)wrookrect2.getX(), (int)wrookrect2.getY(), 90, 90, null);
        g.drawImage(whitehorse1, (int) whorserect1.getX(), (int) whorserect1.getY(), 90, 90, null);
        g.drawImage(whitehorse2, (int) whorserect2.getX(), (int) whorserect2.getY(), 90, 90, null);
        g.drawImage(whitebishop1, (int) wbishoprect1.getX(), (int) wbishoprect1.getY(), 90, 90, null);
        g.drawImage(whitebishop2, (int) wbishoprect2.getX(), (int) wbishoprect2.getY(), 90, 90, null);
        g.drawImage(whiteking, (int) wkingrect.getX(), (int) wkingrect.getY(), 90, 90, null);
        g.drawImage(whitequeen, (int) wqueenrect.getX(), (int) wqueenrect.getY(), 90, 90, null);
        g.drawImage(whitepawn1, (int) wpawnrect[0].getX(), (int) wpawnrect[0].getY(), 90, 90, null);
        g.drawImage(whitepawn2, (int) wpawnrect[1].getX(), (int) wpawnrect[1].getY(), 90, 90, null);
        g.drawImage(whitepawn3, (int) wpawnrect[2].getX(), (int) wpawnrect[2].getY(), 90, 90, null);
        g.drawImage(whitepawn4, (int) wpawnrect[3].getX(), (int) wpawnrect[3].getY(), 90, 90, null);
        g.drawImage(whitepawn5, (int) wpawnrect[4].getX(), (int) wpawnrect[4].getY(), 90, 90, null);
        g.drawImage(whitepawn6, (int) wpawnrect[5].getX(), (int) wpawnrect[5].getY(), 90, 90, null);
        g.drawImage(whitepawn7, (int) wpawnrect[6].getX(), (int) wpawnrect[6].getY(), 90, 90, null);
        g.drawImage(whitepawn8, (int) wpawnrect[7].getX(), (int) wpawnrect[7].getY(), 90, 90, null);

        // This is where I draw all of the black pieces
        g.drawImage(blackrook1, (int)bl_rookrect1.getX(), (int)bl_rookrect1.getY(), 90, 90, null);
        g.drawImage(blackrook2, (int)bl_rookrect2.getX(), (int)bl_rookrect2.getY(), 90, 90, null);
        g.drawImage(blackhorse1, (int) bl_horserect1.getX(), (int) bl_horserect1.getY(), 90, 90, null);
        g.drawImage(blackhorse2, (int) bl_horserect2.getX(), (int) bl_horserect2.getY(), 90, 90, null);
        g.drawImage(blackbishop1, (int) bl_bishoprect1.getX(), (int) bl_bishoprect1.getY(), 90, 90, null);
        g.drawImage(blackbishop2, (int) bl_bishoprect2.getX(), (int) bl_bishoprect2.getY(), 90, 90, null);
        g.drawImage(blackking, (int) bl_kingrect.getX(), (int) bl_kingrect.getY(), 90, 90, null);
        g.drawImage(blackqueen, (int) bl_queenrect.getX(), (int) bl_queenrect.getY(), 90, 90, null);
        g.drawImage(blackpawn1, (int) bl_pawnrect[0].getX(), (int) bl_pawnrect[0].getY(), 90, 90, null);
        g.drawImage(blackpawn2, (int) bl_pawnrect[1].getX(), (int) bl_pawnrect[1].getY(), 90, 90, null);
        g.drawImage(blackpawn3, (int) bl_pawnrect[2].getX(), (int) bl_pawnrect[2].getY(), 90, 90, null);
        g.drawImage(blackpawn4, (int) bl_pawnrect[3].getX(), (int) bl_pawnrect[3].getY(), 90, 90, null);
        g.drawImage(blackpawn5, (int) bl_pawnrect[4].getX(), (int) bl_pawnrect[4].getY(), 90, 90, null);
        g.drawImage(blackpawn6, (int) bl_pawnrect[5].getX(), (int) bl_pawnrect[5].getY(), 90, 90, null);
        g.drawImage(blackpawn7, (int) bl_pawnrect[6].getX(), (int) bl_pawnrect[6].getY(), 90, 90, null);
        g.drawImage(blackpawn8, (int) bl_pawnrect[7].getX(), (int) bl_pawnrect[7].getY(), 90, 90, null);

    }
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if(bl_rookrect1.contains(x,y))
        {
            rookLogic();
        }
        if(bl_rookrect2.contains(x,y))
        {
            rookLogic();
        }
        if(wrookrect1.contains(x,y))
        {
            rookLogic();
        }
        if(wrookrect2.contains(x,y))
        {
            rookLogic();
        }
        if(bl_horserect1.contains(x,y))
        {
            horseLogic();
        }
        if(bl_horserect2.contains(x,y))
        {
            horseLogic();
        }
        if(whorserect1.contains(x,y))
        {
            horseLogic();
        }
        if(whorserect2.contains(x,y))
        {
            horseLogic();
        }
        if(bl_bishoprect1.contains(x,y))
        {
            bishopLogic();
        }
        if(bl_bishoprect2.contains(x,y))
        {
            bishopLogic();
        }
        if(wbishoprect1.contains(x,y))
        {
            bishopLogic();
        }
        if(wbishoprect2.contains(x,y))
        {
            bishopLogic();
        }
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }
    public void rookLogic()
    {

    }
    public void pawnLogic()
    {

    }
    public void queenLogic()
    {

    }
    public void KingLogic()
    {

    }
    public void bishopLogic()
    {
        
    }
    public void horseLogic()
    {
        
    }
}