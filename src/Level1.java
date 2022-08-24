public class Level1 {
    public static String[] TreeOfLife(int h, int w, int n, String[] tree) {
        int[][] treeNum = new int[h][w];

        // convert string tree to num tree
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tree[i].charAt(j) == '.') {
                    treeNum[i][j] = 0;
                } else {
                    treeNum[i][j] = 1;
                }
            }
        }

        int[][] cut = new int[h][w];
        int k = 0;

        while (k < n) {
            // branch growth
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    treeNum[i][j]++;
                }
            }

            if (k % 2 == 0) {
                k++;
                continue;
            }

            // create a cut map
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    if (treeNum[i][j] > 2) {
                        cut[i][j] = 1;

                        if (i > 0) cut[i - 1][j] = 1;
                        if (j > 0) cut[i][j - 1] = 1;
                        if (j < w - 1) cut[i][j + 1] = 1;
                        if (i < h - 1) cut[i + 1][j] = 1;
                    }
                }
            }

            // cut branches
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    if (cut[i][j] != 0) {
                        cut[i][j] = 0;
                        treeNum[i][j] = 0;
                    }
                }
            }

            k++;
        }

        String[] str = new String[h];

        // convert num tree to string tree
        for (int i = 0; i < h; i++) {
            str[i] = "";

            for (int j = 0; j < w; j++) {
                if (treeNum[i][j] > 0) {
                    str[i] += "+";
                } else {
                    str[i] += ".";
                }
            }
        }

        return str;
    }
}
