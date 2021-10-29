package pruebas;

import java.io.*;
import java.util.ArrayList;

public class flujoEscritura {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        String comandoWindows = "CMD /C DIR";

        String comando = comandoWindows;
        Process p;
        int status;

        try {
            p = rt.exec(comando);

            status = p.waitFor();
            System.out.println(status);

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            File archivo = new File(isr.toString());
            try(FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr)){

                ArrayList<String> lista = new ArrayList<String>();
                String linea = br.readLine();

                while(linea != null) {
                    lista.add(linea);
                    linea = br.readLine();

                }
                StringReader memory = new StringReader(lista.toString());

                System.out.println(memory);
            }catch(IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
