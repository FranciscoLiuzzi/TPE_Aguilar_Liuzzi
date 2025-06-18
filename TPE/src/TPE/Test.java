package TPE;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Maquina> maquinas = new ArrayList();

        Maquina m1 = new Maquina("M1", 7);
        Maquina m2 = new Maquina("M2", 3);
        Maquina m3 = new Maquina("M3", 4);
        Maquina m4 = new Maquina("M4", 1);

        maquinas.add(m1);
        maquinas.add(m2);
        maquinas.add(m3);
        maquinas.add(m4);

        Backtracking b = new Backtracking(maquinas);

        System.out.println(b.TPE(12));
    }
}
