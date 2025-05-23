//CATALINA 0
import DAOs.ClienteDAO;
import entities.*;
import repositories.ContratoRepositorio;
import services.App;

import java.util.List;
//comentario

public class Main {
    public static void main(String[] args) {

        //Iniciar el menu
        App menu = new services.App();
        try {
            menu.run();
        } catch (NullPointerException e) {
            System.out.println("El objeto al que se quiere acceder es nulo");
        }catch (NumberFormatException e){
            System.out.println("Error de formato");
        }        catch (Exception e) {
            System.out.println("Error surgido de tipo: " + e.getClass());
        }

    }
}
