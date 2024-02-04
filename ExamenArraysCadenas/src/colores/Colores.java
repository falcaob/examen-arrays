package colores;

import java.util.Arrays;
import java.util.Scanner;

public class Colores {

	// Método que pide lista de colores al usuario
	
	/*
	 * Método estático al que no le pasamos ningún argumento 
	 * y devuelve un array de cadenas.
	 */
	public static String[] pedirListaColores() {
		//Crea un objeto de la clase Scanner llamado 'sc' para la entrada de datos por consola.
		Scanner sc = new Scanner(System.in);
		//Creamos e inicializamos un array de cadenas de longitud 5.
		String[] listaColores = new String[5];
		
		//Imprimimos un mensaje por consola que pide al usuario los 5 colores.
		System.out.println("Dame " + listaColores.length + " colores:");
		//Mediante un bucle vamos pidiendo al usuario que introduzca los colores uno a uno
		//Desde el indice 0 hasta la longitud -1 (para incluir el último elemnto) del array creado anteriormente. 
		//aumentando cada interacción en 1 unidad
		for (int i = 0; i <= listaColores.length - 1; i++) {
			//Imprime por consola el color a intrudir y su posición en el array.
			System.out.print("Color " + (i + 1) + ": ");
			//A través del indice, va guardando cada color introduccido por el usuario en su posición en el array
			//Todos los colores los introduce en minúsculas gracias al método toLowerCase de la clase String.
			listaColores[i] = sc.next().toLowerCase();
		}
		// sc.close();
		
		//Gracias al método sort de la clase Arrays, ordena los colores alfabéticamente.
		Arrays.sort(listaColores);

		//El método devuelve un array de cadenas de colores ordenado.
		return listaColores;

	}

	// Método que muestra los colores reconocidos que hay en la lista de colores del
	// usuario
	
	/*
	 * Método estático que no devuelve ningún valor y recibe por parámetros 2 arrays de cadenas
	 */
	public static void reconocidosListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {
		//Imprime un mensaje por consola
		System.out.println("\nEn la lista de colores introducidos por el usuario\n"
				+ "se encuentran los siguientes colores reconocidos por el sistema:\n");
		//Bucle extendido for each que itera los colores reconocidos por el programa
		//Por cada elemento del array de colores reconocidos
		for (String color : listaColoresReconocidos) {
			/*
			 * binarySearch es un método de la clase Arrays que busca un elemento en un array ordenado.
			 * 
			 * Devuelve el índice del elemento buscado si se encuentra en el array; de lo contrario, 
			 * devuelve un valor negativo que indica dónde el elemento debería estar insertado.
			 */
			//Por parámetros le pasamos le array en el que queremos buscar y la lo que queremos encontrar
			//que en este caso sería el 'color'.
			//Si el resultado es un índice no negativo, significa que el elemento está presente en el array.
			if (Arrays.binarySearch(listaColoresUsuario, color) >= 0)
				//Imprime el color si coindice con los reconocidos.
				System.out.println(color);
		}
	}

	// Método que muestra cuantas veces aparece cada color reconocido en la lista de
	// colores del usuario
	
	/*
	 * Método estático que no devuelve ningún valor y le pasamos por parámetros 2 arrays de candenas.
	 */
	public static void cuantosReconocidosListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {
		//Imprime un mensaje por consola
		System.out.println("\nEn la lista de colores introducidos por el usuario\n"
				+ "se encuentran los siguientes colores reconocidos por el sistema en las cantidades que se indican:\n");
		//Mediante un bucle extendido for each itera los colores reconocidos por el programa.
		//Por cada elemento del array de colores reconocidos.
		for (String color : listaColoresReconocidos) {
			//Declaramos e inicializamos una variable que va a contar los colores las veces que se repite el color.
			int numVeces = 0;
			//Bucle estándar que itera sobre la lista de colores introducidos por el usuario.
			//Desde el indice 0 hasta la longitud de los elementos de lista de colores del usuario,
			//vamos aumentando de 1 en 1.
			for (int i = 0; i <= listaColoresUsuario.length - 1; i++)
				//Con el método equals de la clase String, comparamos en cada posición,
				//si cada color se encuentra en el array de la lista del usurio.
				if (color.equals(listaColoresUsuario[i]))
					//Si se encuentral, incrementamos la variable que hace de contador.
					numVeces++;
			//Si el contado es mayor que 0.
			if (numVeces > 0)
				//Imprimimos por consola el color que se repiye t el número de veces que se repite.
				//"\t|\t" > es una secuencia de escape que representa un carácter de tabulación,
				//se utilizan para alinear la información en columnas.
				System.out.println("Color: " + color + "\t|\t" + numVeces + " veces");
		}
	}

	// Método que ordena los colores de la lista del usuario en dos bloques:
	// lo reconocidos y los no reconocidos (ambos bloques ordenados alfabéticamente)
	
	/*
	 * Método estático que devuelve un array de cadenas y le pasamos por parámetros 2 arrays de cadenas.
	 */
	public static String[] ordenarListaUsuario(String[] listaColoresReconocidos, String[] listaColoresUsuario) {
		//Declaramos e inicializamos una variable cuya función es la de índice.
		int i = 0;
		//Creamos un array donde guardamos la longitud de la lista ordenada de colores introducida por el usuario.
		String[] ordenado = new String[listaColoresUsuario.length];
		//Con un bucle extendido for each iteramos la lista de colores reconocidos por el programa.
		//Por cada elemento del array de colores del sistema.
		for (String colorReconocido : listaColoresReconocidos) {
			//De la misma forma que en los métodos anteriores comprobamos si los colores introducidos
			//por el usuario se encuentra entre los colores reconocidos.
			//Al método de la clase Array, binarySearch le pasamos dónde queremos buscar y que es lo que queremos encontrar 
			//y si el índice es no negativo seguimos la sentencia dentro del condicional.
			if (Arrays.binarySearch(listaColoresUsuario, colorReconocido) >= 0) {
				//Si el color está, lo metemos en la referencia del array creado anteriormente.
				ordenado[i] = colorReconocido;
				//e incrementamos la variable del índice
				i++;
			}
		}
		//Ahora iteramos con otro for each la lista del colores del usuario.
		//Por cada color que el usuario haya introducido y está guardado en el array listaColoresUsuario.
		for (String colorUsuario : listaColoresUsuario) {
			//Volvemos a hacer una búsqueda de la misma forma pero buscando los colores que no coinciden.
			if (Arrays.binarySearch(listaColoresReconocidos, colorUsuario) < 0) {
				//Si no está en la lista de colores reconocidos binarySearch devuelve un índice negativo y
				//lo introduce mediante índices en el array ordenado.
				ordenado[i] = colorUsuario;
				i++;
			}
		}
		
		//Devuelve el array ordenado que contiene los colores introduccidos por el usuario reconocidos
		//seguido de los que no están en la lista.
		return ordenado;

	}

	// Método que permitirá incluye un nuevo color en la lista de colores
	// reconocidos (que debe seguir quedando ordenada)
	
	/*
	 * Método estático que devuelve un array de cadenas y recibe por parámetros un array de cadena y una cadena.
	 */
	
	public static String[] insertarColorReconocido(String[] listaColoresReconocidos, String color) {
		//Inicializamos con una nueva referencia al array de colores reconocidos.
		String[] listaFinal = listaColoresReconocidos;
		//Buscamos la posición del color que le pasamos por parámetros.
		//A binarySeach le pasamos el array donde queremos buscar y qué es lo que queremos encontrar.
		int indiceInsercion = Arrays.binarySearch(listaColoresReconocidos, color);
		
		//Con un condicional elegimos qué hacer si el color ya está en la lista o no.
		if (indiceInsercion >= 0)
			//Si está en la lista imprimimos lo siguiente en consola.
			System.out.println("\nEl color ya existe en la lista");
		else {
			//Si el color no está en la lista aumentamos la longitud del array de color reconocidos.
			listaFinal = new String[listaColoresReconocidos.length + 1];
			//Calculamos la pocisión de donde debería estar el nuevo color dentro del array ordenado.
			indiceInsercion = -indiceInsercion - 1;
			/*
			 * arraycopy es un método de la clase System y se utiliza para copiar elementos de un array a otro.
			 * Permite copiar segementos o el array completo.
			 */
			//Copiamos los elementos desde la primera posición del array de colores del programa al array de destino,
			//en el array de destino, los elementos empezarán a copiarse desde la posición 0 e 
			//indiceInsercion es el número de elementos que se copiarán (como la longitud).
			/*
			 * En resumen, se copiarán los primeros indiceInsercion elementos de 
			 * listaColoresReconocidos al principio de listaFinal.
			 */
			System.arraycopy(listaColoresReconocidos, 0, listaFinal, 0, indiceInsercion);
			//Copiamos los elementos restantes desde la posición de inserción del nuevo color,
			//hasta el final de la lista de colores reconocidosa, al array de destino listaFinal.
			//Después, desde la siguiente posición al indice de inserción copia todos los elementos restantes.
			System.arraycopy(listaColoresReconocidos, indiceInsercion, listaFinal, indiceInsercion + 1,
					listaColoresReconocidos.length - indiceInsercion);
			//Insertamos el nuevo color en la posición del índice de inserción.
			listaFinal[indiceInsercion] = color;
			//Imprimimos en consola que el proceso ha sido exitoso.
			System.out.println("\nEl color ha sido incluido en la lista");
		}
		//Devolvemos el nuevo array con el color introducido
		return listaFinal;
	}

	// Método que elimina un color de la lista de colores
	// reconocidos (que debe seguir quedando ordenada)
	
	/*
	 * étodo estático que devuelve un array de cadenas y recibe por parámetros un array de cadena y una cadena. 
	 */
	public static String[] eliminarColorReconocido(String[] listaColoresReconocidos, String color) {
		//A una nueva variable le asignamos el color que queremos borrar,
		//haciendo uso de binarySearh, buscamos en la lista de colores el color que queremos borrar.
		int indiceBorrado = Arrays.binarySearch(listaColoresReconocidos, color);

		//De la misma forma que el método anterior, verificamos si el color está en la lista.
		if (indiceBorrado >= 0) {
			//Desplaza los elementos a la izquierda desde la posición del color a borrar, hasta el final del array.
			System.arraycopy(listaColoresReconocidos, indiceBorrado + 1, listaColoresReconocidos, indiceBorrado,
					listaColoresReconocidos.length - indiceBorrado - 1);
			/*
			 * copyOf es un método de la clase Arrays que crea una copia de un array con una longitud específica.
			 */
			//Redimensionamos el array quitandole el último índice de la siguiente forma:
			//Con 'listaColoresReconocidos.length - 1' especificamos la nueva longitud del array copiado, que es un elemento menos que la longitud original. 
			//Asignamos la referencia del nuevo array a la variable listaColoresReconocidos.
			listaColoresReconocidos = Arrays.copyOf(listaColoresReconocidos,
					listaColoresReconocidos.length - 1);
			//Imprimos por consola el éxito del proceso.
			System.out.println("\nEl color ha sido eliminado de la lista");
		}
		//Si el color no se ha encontrado en la lista imprimimos el siguiente mensaje.
		else System.out.println("\nEl color no existe en la lista");
		
		//Devolvemos la lista de colores con el elemento borrado.
		return listaColoresReconocidos;
	}

}