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
        menu.run();

    }
}
