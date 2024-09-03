class TowerSolver {
    private int count=0;
    private Towers t;
    TowerSolver(Towers t) {this.t = t;}
    public void solve(int towerHeight, int source, int destination, int aux){
        if(towerHeight == 1){
            t.move(source, destination);
            System.out.println("STEP" +(++count));
            t.printTowers();
        }else{
            solve(towerHeight-1, source, aux, destination);
            t.move(source, destination);
            System.out.println("STEP" +(++count));
            t.printTowers();
            solve(towerHeight-1, aux, destination, source);
        }
    }
}
