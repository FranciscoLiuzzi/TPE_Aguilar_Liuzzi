package TPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TPE {
    private ArrayList<Maquina> bestSolucion;
    private int iterations;

    public TPE() {
        this.bestSolucion = new ArrayList();
        this.iterations = 0;
    }

    public ArrayList<Maquina> Backtracking(int Objetivo, ArrayList<Maquina> Maquinas){
        ArrayList<Maquina> SolucionTemporal = new ArrayList();
        Collections.sort(Maquinas, new Comparator<Maquina>() {
            @Override
            public int compare(Maquina m1, Maquina m2) {
                return Integer.compare(m2.getPiezas(), m1.getPiezas());
            }
        });
        Backtrack(Objetivo, SolucionTemporal, Maquinas, 0);
        
        System.out.println("Backtracking");
        System.out.println("Secuencia de maquinas: " + bestSolucion);
        System.out.println("Cantidad de piezas producidas: " + Objetivo);
        System.out.println("Cantidad de puestas en funcionamiento requeridas: " + bestSolucion.size());
        System.out.println("Metrica de analisis - cantidad de estados generados: " + iterations);
        return new ArrayList<>(bestSolucion);
    }

    
    /*
    <<Breve explicación de la estrategia de resolución. Por ejemplo:
    Cómo se genera el árbol de exploración:
    En cada paso del algoritmo se prueba usar cualquiera de las máquinas disponibles.
    Esto genera distintas combinaciones posibles (ramas del árbol), y en cada nivel se suma una máquina a la secuencia.*
    Cuáles son los estados finales y estados solución:
    Un estado final es cuando el objetivo llega a 0 (es decir, se completó la producción).
    Un estado es solución si además de llegar a 0, lo hizo usando la menor cantidad de máquinas posible.*
    Posibles podas:
    Si ya hay una solución guardada y la actual usa igual o más máquinas, se corta ese camino (poda por cantidad).
    Se utiliza un indice para evitar combinaciones que son en escencia la misma en distinto orden de activacion*
    Conclusion:
    El algoritmo explora todas las combinaciones válidas pero trata de optimizar el recorrido usando podas,
    buscando siempre la solución más corta en cantidad de puestas en marcha.*/
    public void Backtrack(int Objetivo, ArrayList<Maquina> SolucionTemporal, ArrayList<Maquina> Maquinas, int index){
    	this.iterations++;
    	
        //CHECK ESTADO FINAL
        if (Objetivo == 0) {
            //CHECK SOLUCION
            if (bestSolucion.isEmpty() || SolucionTemporal.size() < bestSolucion.size()) {
                bestSolucion = new ArrayList(SolucionTemporal);
            }
        } else {
        	//PODA
            if (bestSolucion.isEmpty() || (SolucionTemporal.size() < bestSolucion.size())) {
            	//BACKTRACK
            	for (int i = index; i < Maquinas.size(); i++) {
                    //MiniPODA
                    if (Maquinas.get(i).getPiezas() <= Objetivo) {
                        SolucionTemporal.add(Maquinas.get(i));

                        Backtrack(Objetivo - Maquinas.get(i).getPiezas(), SolucionTemporal, Maquinas, i);

                        SolucionTemporal.remove(SolucionTemporal.size() - 1);
                    }
                }
            }     
        }
    }
    
    /*
    <<Breve explicación de la estrategia de resolución.*
    Cuáles son los candidatos:
    Las máquinas disponibles en la lista original (todas).*
    Estrategia de selección de candidatos:
    Se ordenan de mayor a menor según la cantidad de piezas que producen,
    y se elige siempre la que más piezas aporta, la primera, sin pasarse del objetivo restante,*
    Consideraciones respecto a encontrar o no solución:
    Si no se puede elegir ninguna máquina que encaje con lo que falta producir, se corta el algoritmo.
    En ese caso, se considera que no hay una solución posible con Greedy.*
    Conclusion:
    Es una estrategia rápida que no prueba todas las combinaciones,
    por lo tanto puede no encontrar la solución óptima, pero sí una bastante buena en poco tiempo.*/
    public ArrayList<Maquina> Greedy(int Objetivo, ArrayList<Maquina> maquinas){
    	
    	Collections.sort(maquinas, new Comparator<Maquina>() {
            @Override
            public int compare(Maquina m1, Maquina m2) {
                return Integer.compare(m2.getPiezas(), m1.getPiezas());
            }
        });
    	
    	int candidatos = 0;
    	int index = 0;
    	ArrayList<Maquina> Solucion = new ArrayList();
    	int remaining = Objetivo;
    	
    	while ((remaining > 0)&&(!maquinas.isEmpty())) {
    		Maquina actual = maquinas.get(0);
    		System.out.println("Considere el: "+actual.getName());
    		candidatos++;
    		
    		if (actual.getPiezas() <= remaining) {
        		Solucion.add(actual);
        		remaining = remaining - actual.getPiezas();
    		} else {
    			maquinas.removeFirst();
    		}
    	}
    	
    	System.out.println("Greedy");
    	if (remaining == 0) {
    		System.out.println("Secuencia de maquinas: " + Solucion);
            System.out.println("Cantidad de piezas producidas: " + (Objetivo - remaining));
            System.out.println("Cantidad de puestas en funcionamiento requeridas: " + Solucion.size());
            System.out.println("Metrica de analisis - cantidad de candidatos considerados: " + candidatos);
    	} else {
    		System.out.println("No hay solucion");
            System.out.println("Metrica de analisis - cantidad de candidatos considerados: " + candidatos);
    	}

        return (remaining == 0) ? Solucion : null;
    }
}