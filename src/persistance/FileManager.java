package persistance;

import java.util.ArrayList;
import java.io.*;

public class FileManager {
    private String pathFile;

    public FileManager(String pathFile){
        this.pathFile = pathFile;
    }

    public File getFile(){
        return new File(this.pathFile);
    }

    public ArrayList<String> getDataFile(){
        ArrayList<String> lines = null;
        try {
            File file = this.getFile();
            if (file.exists()){
                lines = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    lines.add(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return lines;
    }

    public boolean writeFile(String line){
        boolean writer = false;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.getFile(), true));
            bufferedWriter.write(line);
            bufferedWriter.flush();
            bufferedWriter.close();

            writer = true;
        }catch (IOException e){
            e.printStackTrace(System.out);
        }

        return writer;
    }

    public boolean rewriteFile(ArrayList<String> lines) {
        try {
            File file = new File(pathFile);
            // Sobreescribir el archivo
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al reescribir archivo: " + e.getMessage());
            return false;
        }
    }

}
