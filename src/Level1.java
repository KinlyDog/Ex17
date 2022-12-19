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

        int[][] cutTreeBranches = new int[h][w];
        int count = 0;

        while (count < n) {
            // branch growth
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    treeNum[i][j]++;
                }
            }

            if (count % 2 == 0) {
                count++;
                continue;
            }

            // create a cut map
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    boolean t = treeNum[i][j] > 2;

                    if (t && i > 0)     cutTreeBranches[i - 1][j] = 1;
                    if (t && j > 0)     cutTreeBranches[i][j - 1] = 1;
                    if (t && j < w - 1) cutTreeBranches[i][j + 1] = 1;
                    if (t && i < h - 1) cutTreeBranches[i + 1][j] = 1;
                }
            }

            // cut branches
            for (int i = 0; i < h; i ++) {
                for (int j = 0; j < w; j++) {
                    if (cutTreeBranches[i][j] != 0) {
                        cutTreeBranches[i][j] = 0;
                        treeNum[i][j] = 0;
                    }
                }
            }

            count++;
        }
        count = 0;

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
