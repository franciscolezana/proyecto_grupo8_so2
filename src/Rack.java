import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class Rack extends JPanel {
    int[][] slots;
    JLabel[][] uiSlots;
    int x, y;

    public Rack() {
        this.setLayout(new GridLayout(5,4));
        this.slots = new int[5][4];
        this.uiSlots = new JLabel[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                this.uiSlots[i][j] = new JLabel();
                this.uiSlots[i][j].setBackground(new Color(255,255,255));
                this.uiSlots[i][j].setPreferredSize(new Dimension(50,50));
                this.uiSlots[i][j].setOpaque(true);
                this.add(this.uiSlots[i][j]);
            }
        }
        this.rePaint();
    }

    public int putBox(Box box) {
        switch (box.getSize()) {
            case Sizes.Small:
                return putSmallBox();
            case Sizes.Big:
                return putBigBox();
            default:
                return -1;
        }
    }

    public int pickBox(int size) {
        switch (size) {
            case Sizes.Big:
                return pickBigBox();
            case Sizes.Small:
                return pickSmallBox();
            default:
                return -1;
        }
    }

    private int pickSmallBox() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.slots[i][j] != 1)
                    continue;

                this.slots[i][j] = 0;
                this.rePaint();
                return 0;
            }
        }
        return -1;
    }

    private int pickBigBox() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.slots[i][j] != 2 )
                    continue;

                this.slots[i][j] = 0;
                this.slots[i][j+1] = 0;
                this.rePaint();
                return 0;
            }
        }
        return -1;
    }

    private int putSmallBox() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.slots[i][j] != 0)
                    continue;

                this.slots[i][j] = Sizes.Small;
                this.rePaint();
                return 0;
            }
        }
        return -1;
    }

    private int putBigBox() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.slots[i][j] != 0 || this.slots[i][j+1] != 0)
                    continue;

                this.slots[i][j] = Sizes.Big;
                this.slots[i][j+1] = Sizes.Big;
                this.rePaint();
                return 0;
            }
        }
        return -1;
    }

    public int getFreeSlots() {
        return 0;
    }

    public int getNonFreeSlots() {
        return 0;
    }

    public void printRack() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" | ");
                System.out.print(this.slots[i][j]);
                if (j < 3) continue;
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void rePaint() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Color color;
                switch (slots[i][j]) {
                    case Sizes.Big:
                        color = new Color(147, 186, 207);
                        break;
                    case Sizes.Small:
                        color = new Color(184, 138, 205);
                        break;
                    default:
                        color = new Color(255, 255, 255);
                        break;
                }

                this.uiSlots[i][j].setBackground(color);
                this.uiSlots[i][j].setBorder(BorderFactory.createLineBorder(new Color(110, 47, 0)));
                this.uiSlots[i][j].setPreferredSize(new Dimension(50,50));
                this.uiSlots[i][j].setOpaque(true);
                this.add(uiSlots[i][j]);
            }
        }
    }
}
