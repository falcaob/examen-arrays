package colores;

import java.util.Arrays;
import java.util.Scanner;

public class Colores {

	// Método que pide lista de colores al usuario
	public static String[] pedirListaColores() {
		Scanner sc = new Scanner(System.in);
		String[] listaColores = new String[5];

		System.out.println("Dame " + listaColores.length + " colores:");
		for (int i = 0; i <= listaColores.length - 1; i++) {
			System.out.print("Color " + (i + 1) + ": ");
			listaColores[i] = sc.next().toLowerCase();
		}
		// sc.close();
		Arrays.sort(listaColores);

		return listaColores;

	}

	// Método que muestra los colores reconocidos que hay en la lista de colores del
	// usuario
	public static void reconocidosListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {
		System.out.println("\nEn la lista de colores introducidos por el usuario\n"
				+ "se encuentran los siguientes colores reconocidos por el sistema:\n");
		for (String color : listaColoresReconocidos) {
			// boolean encontrado = false;
			// for (int i = 0; i <= listaColoresUsuario.length - 1 && encontrado == false;
			// i++) {
			// if (color.equals(listaColoresUsuario[i])) {
			// System.out.println(listaColoresUsuario[i]);
			// encontrado = true;
			// }
			// }
			if (Arrays.binarySearch(listaColoresUsuario, color) >= 0)
				System.out.println(color);
		}
	}

	// Método que muestra cuantas veces aparece cada color reconocido en la lista de
	// colores del usuario
	public static void cuantosReconocidosListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {
		System.out.println("\nEn la lista de colores introducidos por el usuario\n"
				+ "se encuentran los siguientes colores reconocidos por el sistema en las cantidades que se indican:\n");
		for (String color : listaColoresReconocidos) {
			int numVeces = 0;
			for (int i = 0; i <= listaColoresUsuario.length - 1; i++)
				if (color.equals(listaColoresUsuario[i]))
					numVeces++;
			if (numVeces > 0)
				System.out.println("Color: " + color + "\t|\t" + numVeces + " veces");
		}
	}

	// Método que ordena los colores de la lista del usuario en dos bloues:
	// lo reconocidos y los no reconocidos (ambos bloques ordenados alfabéticamente)
	public static String[] ordenarListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {

		int i = 0;
		String[] ordenado = new String[listaColoresUsuario.length];

		for (String colorReconocido : listaColoresReconocidos) {
			if (Arrays.binarySearch(listaColoresUsuario, colorReconocido) >= 0) {
				ordenado[i] = colorReconocido;
				i++;
			}
		}
		for (String colorUsuario : listaColoresUsuario) {
			if (Arrays.binarySearch(listaColoresReconocidos, colorUsuario) < 0) {
				ordenado[i] = colorUsuario;
				i++;
			}
		}

		return ordenado;

	}

	// Método que permitirá incluye un nuevo color en la lista de colores
	// reconocidos (que debe seguir quedando ordenada)
	public static String[] insertarColorReconocido(String[] listaColoresReconocidos, String color) {

		String[] listaFinal = listaColoresReconocidos;
		int indiceInsercion = Arrays.binarySearch(listaColoresReconocidos, color);

		if (indiceInsercion >= 0)
			System.out.println("\nEl color ya existe en la lista");
		else {
			listaFinal = new String[listaColoresReconocidos.length + 1];
			indiceInsercion = -indiceInsercion - 1;
			System.arraycopy(listaColoresReconocidos, 0, listaFinal, 0, indiceInsercion);
			System.arraycopy(listaColoresReconocidos, indiceInsercion, listaFinal, indiceInsercion + 1,
					listaColoresReconocidos.length - indiceInsercion);
			listaFinal[indiceInsercion] = color;
			System.out.println("\nEl color ha sido incluido en la lista");
		}

		return listaFinal;
	}

	// Método que elimina un color de la lista de colores
	// reconocidos (que debe seguir quedando ordenada)
	public static String[] eliminarColorReconocido(String[] listaColoresReconocidos, String color) {
		int indiceBorrado = Arrays.binarySearch(listaColoresReconocidos, color);

		if (indiceBorrado >= 0) {
			System.arraycopy(listaColoresReconocidos, indiceBorrado + 1, listaColoresReconocidos, indiceBorrado,
					listaColoresReconocidos.length - indiceBorrado - 1);
			listaColoresReconocidos = Arrays.copyOf(listaColoresReconocidos,
					listaColoresReconocidos.length - 1);
			System.out.println("\nEl color ha sido eliminado de la lista");
		}
		else System.out.println("\nEl color no existe en la lista");

		return listaColoresReconocidos;
	}

}