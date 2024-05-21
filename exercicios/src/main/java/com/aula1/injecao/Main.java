package main.java.com.aula1.injecao;

public class Main {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Anny");
        Docente docente = new Docente("Raiani");

        Enem enemEstudante = new Enem(estudante);
        Enem enemDocente = new Enem(docente);

        enemEstudante.iniciar();
        enemDocente.iniciar();
    }
}
