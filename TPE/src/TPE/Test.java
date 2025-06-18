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
        
        ///////////////////////////////////////////////////////////
        
        String filePath = "src/resources/texto.txt"; // Path to your input file
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read target (first line)
            String line = reader.readLine();
            if (line != null) {
                objetivo = Integer.parseInt(line.trim());
            }
            
            // Read machines (subsequent lines)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
            ////////////////////////////////////////////////

        Backtracking b = new Backtracking(maquinas);

        System.out.println(b.TPE(objetivo));
        }
    
}