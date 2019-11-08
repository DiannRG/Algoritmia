package grafo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Menu {

    public static String csvFile = "C:\\Users\\diana\\Desktop\\grafo\\grafo.csv";
    public static BufferedReader br = null;
    public static String line = "";
    public static String cvsSplitBy = ",";

    public static void main(String[] args) {
        //Metodo para mostrar el documento
        MostrarCSV();

    }

    public static void MostrarCSV() {
        try {
            //Se crea la instacia para llamar la lista y poder meter los datos
            Grafo g = new Grafo();
            int contador = 0;
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (g.Nodos.size() == 0) {
                    
                String[] datos = line.split(cvsSplitBy);
                //Imprime datos del docuemnto por columna--------------------
                //System.out.println(datos[0] +", " +datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
                //---------------------------------------------
                for (int i = 0; i < datos.length; i++) {

                    g.Nodos.add(new Nodo(datos[i]));
                }
                for (int i = 0; i < g.Nodos.size(); i++) {
                      System.out.println(g.Nodos.get(i).toString());
                }
                }else{
                    String[] datos = line.split(cvsSplitBy);
                    for (int i = 0; i < datos.length; i++) {
                        if (datos[i].equals("1")) {
                            //otra para llamar a la lista de la clase arista
                            Arista ar = new Arista();
                            ar.nodo1 = g.Nodos.get(contador);
                            ar.nodo2 = g.Nodos.get(i);
                            g.Aristas.add(ar);
                        }
                    }
                     contador += 1;
                }
                line = br.readLine();
            }
            for (int i = 0; i < g.Aristas.size(); i++) {
                System.out.println(g.Aristas.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
