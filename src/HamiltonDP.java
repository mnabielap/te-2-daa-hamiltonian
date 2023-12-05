public class HamiltonDP {
    static boolean hamiltonianPath(int adj[][], int N) {
        boolean dp[][] = new boolean[N][(1<<N)];
        for (int i = 0; i < N; i++)
            dp[i][(1<<i)] = true;
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    for (int k = 0; k < N; k++) {
                        if ((i & (1 << k)) != 0 &&
                          adj[k][j] == 1 && j != k &&
                          dp[k][i^(1<<j)]) {
                            dp[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dp[i][(1<<N)-1]) {
                return true;
            }
        }
        return false;
    }
    
    static boolean hamiltonExist(int adj[][]) {
        int N = adj.length;
        if (hamiltonianPath(adj, N)) {
            return true;
        } else {
            return false;
        }
    }
}