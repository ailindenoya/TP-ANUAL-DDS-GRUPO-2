import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;
public class validadorDePasswords {
    private boolean esRobusta = true;
    public boolean validarLargo(String password) {
        if (!(password.length() >= 12)) {
            System.out.println("La password debe tener mas de 12 caracteres");
            esRobusta = false;
        }
        return esRobusta;
    }

    public boolean validarMayusculas(String password) {

        String mayuscula = "(.*[A-Z].*)";
        if (!password.matches(mayuscula)) {
            System.out.println("La password debe tener al menos un caracter en mayuscula");
            esRobusta = false;
        }
        return esRobusta;
    }

    public boolean validarMinusculas(String password) {

        String minuscula = "(.*[a-z].*)";
        if (!password.matches(minuscula)) {
            System.out.println("La password debe tener al menos un caracter en minuscula");
            esRobusta = false;
        }
        return esRobusta;
    }

    public boolean validarNumeros(String password) {

        String numeros = "(.*[0-9].*)";
        if (!password.matches(numeros)) {
            System.out.println("La password debe tener al menos un numero");
            esRobusta = false;
        }
        return esRobusta;
    }

    public boolean validarCaracteresEspeciales(String password) {

        String caracteresEspeciales = "(.*[@#$%].*$)";
        if (!password.matches(caracteresEspeciales)) {
            System.out.println("La password debe tener al menos alguno de los siguientes caracteres: @#$%");
            esRobusta = false;
        }
        return esRobusta;
    }

        public boolean validarQueNoEsteEntrePeores (String password) throws IOException {
            URL passComunes = new URL("https://raw.githubusercontent.com/OWASP/passfault/master/wordlists/wordlists/10k-worst-passwords.txt");
            Scanner buscadorDePass = new Scanner(passComunes.openStream());
            while (buscadorDePass.hasNextLine()) {
                String passEncontrada = buscadorDePass.nextLine();
                if (Objects.equals(passEncontrada, password)) {
                    System.out.println("La password es demasiado comun");
                    esRobusta = false;
                }
            }
            return esRobusta;
    }

    public boolean esRobusta (String password) throws IOException{
        boolean passwordAVerificar = this.validarLargo(password) && this.validarMayusculas(password) && this.validarMinusculas(password) && this.validarCaracteresEspeciales(password) && this.validarNumeros(password) && this.validarQueNoEsteEntrePeores(password);

            if(passwordAVerificar){
            System.out.println("La password es correcta");
            return passwordAVerificar;
        }
        else{
            return passwordAVerificar;
            }
    }
    public boolean getEsRobusta(){
        return esRobusta;
    }
}
