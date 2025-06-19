package TPE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Maquina> maquinas = new ArrayList();
        int objetivo = 0;
        
        String ruta = "src/resources/texto.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line = reader.readLine();
            if (line != null) {
                objetivo = Integer.parseInt(line.trim());
            }
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String nombre = parts[0].trim();
                        int piezas = Integer.parseInt(parts[1].trim());
                        Maquina m = new Maquina(nombre, piezas);
                        maquinas.add(m);
                    }
                }
            }
        } catch (FileNotFoundException e) {
        	System.out.println();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        Backtracking b = new Backtracking();

        System.out.println(b.TPE(objetivo, maquinas));
        System.out.println(b.Greedy(objetivo, maquinas));
        }
    
}