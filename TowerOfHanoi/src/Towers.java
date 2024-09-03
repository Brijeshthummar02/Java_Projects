import org.w3c.dom.ls.LSOutput;

public class Towers {
    private int maxHeight;
    private int[] heights;
    private int[][] towers;

    public Towers(int maxHeight) {
        this.maxHeight = maxHeight;
        heights = new int[3];
        towers = new int[3][maxHeight];
        heights[0] = maxHeight;

        for (int i = 0; i < maxHeight; i++) {
            towers[0][i] = maxHeight - i;
        }
    }

    public void move(int source, int destination) {
        int sourceIndex = source - 1;
        int destinationIndex = destination - 1;
        int destinationTopRingIndex =
                heights[destinationIndex] - 1;
        int sourceTopRingIndex = heights[sourceIndex] - 1;

        towers[destinationIndex][destinationTopRingIndex + 1]
                = towers[sourceIndex][sourceTopRingIndex];

        towers[sourceIndex][sourceTopRingIndex] = 0;

        heights[sourceIndex]--;
        heights[destinationIndex]++;

    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int[][] getTowers() {
        return towers;
    }

    public int[] getHeights() {
        return heights;
    }

    private void print(char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }

    public void printTowers() {
        int h1 = heights[0], h2 = heights[1], h3 = heights[2];
        int[][] ringSizes = towers;
        int[] spaces = {maxHeight - h1, maxHeight - h2, maxHeight - h3};
        int[] rings = {h1, h2, h3};
        for (int i = 0; i < 3; i++) {
            if (spaces[i] > 0) {
                print(' ', maxHeight);
                System.out.print('|');
                print(' ', maxHeight);
                spaces[i]--;
            } else {
                int ringIndex = rings[i] - 1;
                print(' ', maxHeight - ringSizes[i][ringIndex]);
                print('=', ringSizes[i][ringIndex]);
                System.out.print("|");
                print('=', ringSizes[i][ringIndex]);
                print(' ', maxHeight - ringSizes[i][ringIndex]);
                rings[i]--;
            }
        }
        System.out.println();
    }
}