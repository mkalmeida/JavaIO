import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UsingIO {

    private static final String MY_FILE = "/home/michaella/Desktop/Java II/ArquivosGerados/meuarquivo.txt";

    public UsingIO() {
        //final File file = new File(MY_FILE);

        /*try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Arquivo criado");
            } else {
                System.out.println("Arquivo já existente");
            }

            writefile();
            readfile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
        writefile();

         } catch (IOException e) {
            e.printStackTrace();
        }

        readfile();
    }

    private void writefile() throws IOException {
        final File file = new File(MY_FILE);

        boolean fileCreated = false;

        if(!file.exists()){
            fileCreated = file.createNewFile();
        }

        if(fileCreated || file.exists()){
            //fileOutputStream cria um arquivo se ele não existir tirando a necessidade do codigo de cima
            final OutputStream output = new FileOutputStream(file);

            output.write("Ola Mundo IO".getBytes("UTF-8"));
            output.close();
        }
    }

    private void readfile() {

        /*InputStream input = null;
        
        try {
            input = new FileInputStream(MY_FILE);
        //vou ler bytes e não strings então devo converter byte para texto
        // 1 byte = 8 bits
        // 1 char UTF-16 = 2 bytes
        // 1 char UTF-8 = 1 byte

        int content;

        while ((content = input.read()) != -1){
            System.out.print((char) content);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        //modo simplicaficado - try-with-resources (isso é possível, pois o FileInputStream implementa a interface AutoCloseable)
        try (final InputStream input = new FileInputStream(MY_FILE)){
            int content;

            while((content = input.read()) != -1){
                System.out.print((char)content);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UsingIO();
    }
}
