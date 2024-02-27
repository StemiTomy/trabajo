package JAVA.Pruebas;

public class EncontrarNumMasCercanoA0 {

    // To debug: System.err.println("Debug messages...");
    public static int computeClosestToZero(int[] ts) {
        if (ts.length == 0) {
            return 0;
        }
        int numeroMasCercano = ts[0];
        for (int i = 1; i < ts.length; i++) {
            if (Math.abs(ts[i]) < Math.abs(numeroMasCercano) ||
                (Math.abs(ts[i]) == Math.abs(numeroMasCercano) && ts[i] > 0)) {
                numeroMasCercano = ts[i];
            }
        }
        
        return numeroMasCercano;
    }

    /* Ignore and do not change the code below */
    /*
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int solution = computeClosestToZero(ts);
        System.setOut(outStream);
        System.out.println(solution);
    }
    */
    /* Ignore and do not change the code above */
}
