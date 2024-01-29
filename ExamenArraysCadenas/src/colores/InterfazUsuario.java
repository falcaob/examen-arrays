package colores;

import java.util.Scanner;

public class InterfazUsuario {

	// Método que imprime el menú
	public static void imprimirMenu() {
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("*******************************");
		System.out.println("1. Completar lista de colores de usuario");
		System.out.println("2. ¿Qué colores reconocidos hay en la lista del usuario?");
		System.out.println("3. ¿Cuántas veces cada color en la lista del usuario?");
		System.out.println("4. Ordenar listado de colores introducidos por el usuario");
		System.out.println("5. Mostrar lista de colores reconocidos");
		System.out.println("6. Incluir nuevo color en la lista de colores reconocidos");
		System.out.println("7. Eliminar color de la lista de colores reconocidos");
		System.out.println("8. Salir");
	}

	// Método que espera hasta que se pulse Intro
	public static void esperaIntro(Scanner sc) {
		sc.nextLine();
		System.out.println("\nPulsa Enter para continuar ...");
		sc.nextLine();
	}
}
