package colores;

import java.util.Scanner;

public class InterfazUsuario {

	// Método que imprime el menú
	/*
	 * Método estático que no devuelve nada y no recibe ningún argumento por parámetro.
	 */
	public static void imprimirMenu() {
		//Imprime el encabezado del menú.
		System.out.println("MENÚ DE OPCIONES");
		//Imprime un línea separatoria.
		System.out.println("*******************************");
		//A continuación, imprime todas las opciones que puede elegir el usuario.
		//Estas opciones coinciden con los casos del Switch de nuestro Main.
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
	/*
	 * Método estático que no devuelve nada y espera recibir un objeto de la clase Scanner para la entrada de datos.
	 */
	public static void esperaIntro(Scanner sc) {
		//Limpia la entrada de datos para asegurarnos de que no hay saltos de línea antes de la nueva entrada.
		sc.nextLine();
	    // Imprime un mensaje indicando que el usuario debe presionar Enter para continuar
		System.out.println("\nPulsa Enter para continuar ...");
		//Esperamos a que el usuario presione Enter y se descarta cualquier entrada de datos
		sc.nextLine();
	}
}
