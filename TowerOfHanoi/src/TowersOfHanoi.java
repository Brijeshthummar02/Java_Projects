import java.util.Scanner;
class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("Enter ring count: ");
        int height;
        height = sc.nextInt();
        Towers t;
        t = new Towers(height);
        t.printTowers();

        TowerSolver solver;
        solver = new TowerSolver(t);

        solver.solve(height,1,3,2);



    }
}
