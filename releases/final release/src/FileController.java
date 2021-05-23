package lobby.blackJack;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class



public class FileController {
    String fname;

    public FileController(String fname){
        this.fname = fname;
        createCheck();
    }

    private void createCheck(){
        try {
            File file = new File(this.fname);
            if (file.createNewFile()) {} 
            
        } catch (IOException ez) {
            System.out.println("An error occurred.");
            ez.printStackTrace();
        }

    }

    public void write(String content) {
        try {
          FileWriter filewrite = new FileWriter(this.fname);
          filewrite.write(content);
          filewrite.close();
        } catch (IOException es) {
          System.out.println("An error occurred.");
          es.printStackTrace();
        }
    }

    public void deleteFile(){
        File file = new File(this.fname); 
        if (file.delete()) { 
        }else{
            System.out.println("unable to delete");
        }
    }

    public String readfile(){
        String data = "";
        try {
            File file = new File(this.fname);
            Scanner reader = new Scanner(file);
            data = reader.nextLine();
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
        return data;
    }

    
}

