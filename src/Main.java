//MARIANA CATALINA SANDOVAL PEREZ
//ELIOHT THOMAS GOMEZ MORALES
//DAVID SANTIAGO MURCIA BARRERA
//MARIANA CUADROS ARENA

import entities.*;
import services.App;

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
