package TPE;

import java.util.ArrayList;

public class Backtracking {
    private ArrayList<Maquina> bestSolucion;
    private ArrayList<Maquina> maquinas;
    private int iterations;

    public Backtracking(ArrayList<Maquina> maquinas) {
        this.bestSolucion = new ArrayList();
        this.maquinas = maquinas;
        this.iterations = 0;
    }

    public ArrayList<Maquina> TPE(int Objetivo){
        ArrayList<Maquina> SolucionTemporal = new ArrayList();
        Backtrack(Objetivo, SolucionTemporal);
       
        System.out.println(iterations);
        return new ArrayList<>(bestSolucion);
    }

    
    /*
     * <<Breve explicación de la estrategia de resolución. Por ejemplo:
     * - Cómo se genera el árbol de exploración.
     * - Cuáles son los estados finales y estados solución.
     * - Posibles podas.
     * - etc.>>
     */
    public void Backtrack(int Objetivo, ArrayList<Maquina> SolucionTemporal){
    	this.iterations++;
    	
        //CHECK ESTADO FINAL
        if (Objetivo == 0) {
            //CHECK SOLUCION
            if (bestSolucion.isEmpty() || SolucionTemporal.size() < bestSolucion.size()) {
                bestSolucion = new ArrayList(SolucionTemporal);
            }
            return;
        }

        //PODA
        if (!bestSolucion.isEmpty()) {
        	if (SolucionTemporal.size() >= bestSolucion.size()) {
                return;
            }
        }

        //BACKTRACK
        for (int i = 0; i < maquinas.size(); i++) {
            //MiniPODA
            if (maquinas.get(i).getPiezas() <= Objetivo) {
                SolucionTemporal.add(maquinas.get(i));

                Backtrack(Objetivo - maquinas.get(i).getPiezas(), SolucionTemporal);

                SolucionTemporal.remove(SolucionTemporal.size() - 1);
            }
        }
        return;
    }
    
    
    /*
     * <<Breve explicación de la estrategia de resolución. Por ejemplo:
     * - Cómo se genera el árbol de exploración.
     * - Cuáles son los estados finales y estados solución.
     * - Posibles podas.
     * - etc.>>
     */
    public ArrayList<Maquina> Greedy(int Objetivo){
        ArrayList<Maquina> Solucion = new ArrayList();

        maquinas.sort(null);
        
        

        return Solucion;
    }
}