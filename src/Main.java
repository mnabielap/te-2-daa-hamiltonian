
public class Main {
    public static void main(String[] args) {
        // ###################### INITIAL VAR ######################
        // 1 = small
        // 2 = medium
        // 3 = large
        int size = 1; 
        boolean isConnected = true;
        // 1 = DP
        // 2 = Backtracking
        int command = 1;
        // #########################################################
        int adj[][] = DatasetLoader.loadDataset(size, isConnected);

        long startTime, endTime, elapsedTime;
        double elapsedTimeInMS, elapsedTimeInSec;
        long beforeUsedMem, afterUsedMem, actualMemUsed;
        boolean isExist;
        
        startTime = System.nanoTime();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // #################### EXECUTE ####################
        isExist = (command==1) ? HamiltonDP.hamiltonExist(adj) : HamiltonBacktracking.hamiltonExist(adj);
        // #################################################
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        endTime = System.nanoTime();
        
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("used memory "+actualMemUsed/1024L+" KB");
        
        System.out.println(isExist);
        elapsedTime = endTime - startTime;
        System.out.println(elapsedTime +" ns");
        elapsedTimeInMS = (double) elapsedTime / 1_000_000;
        System.out.println(elapsedTimeInMS + " ms");
        elapsedTimeInSec = (double) elapsedTime / 1_000_000_000;
        System.out.println(elapsedTimeInSec + " s\n");
    }
    
}
