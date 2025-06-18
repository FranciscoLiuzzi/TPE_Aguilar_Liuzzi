package TPE;

import java.util.ArrayList;

public class Backtracking {
    private ArrayList<Maquina> BestSolucion;
    private ArrayList<Maquina> Maquinas;

    public Backtracking(ArrayList<Maquina> maquinas) {
        this.BestSolucion = new ArrayList();
        this.Maquinas = maquinas;
    }

    public ArrayList<Maquina> TPE(int Objetivo){
        ArrayList<Maquina> SolucionTemporal = new ArrayList();
        Backtrack(Objetivo, SolucionTemporal);

        return new ArrayList<>(BestSolucion);
    }

    public void Backtrack(int Objetivo, ArrayList<Maquina> SolucionTemporal){
        //CHECK ESTADO FINAL
        if (Objetivo == 0) {
            //CHECK SOLUCION
            if (BestSolucion.isEmpty() || SolucionTemporal.size() < BestSolucion.size()) {
                BestSolucion = new ArrayList(SolucionTemporal);
            }
            return;
        }

        //PODA
        //if (SolucionTemporal.size() >= BestSolucion.size()) {
        //    return;
        //}

        //BACKTRACK
        for (int i = 0; i < Maquinas.size(); i++) {
            //MiniPODA
            if (Maquinas.get(i).getPiezas() <= Objetivo) {
                SolucionTemporal.add(Maquinas.get(i));

                Backtrack(Objetivo - Maquinas.get(i).getPiezas(), SolucionTemporal);

                SolucionTemporal.remove(SolucionTemporal.size() - 1);
            }
        }
        return;
    }
    
    public ArrayList<Maquina> Greedy(){
        ArrayList<Maquina> Solucion = new ArrayList();

        Maquinas.sort(null);

        return Solucion;
    }
}