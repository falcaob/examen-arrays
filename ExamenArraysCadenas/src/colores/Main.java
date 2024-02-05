package colores;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//Creamos un objeto de la clase Scanner para la entrada de datos.
		Scanner sc = new Scanner(System.in);
		//Declaramos una variable para guardar la opción del usuario que va a introducir el usuario.
		int opcion;
		//Declaramos un array de 4 elementos y lo inicializamos con los colores que reconoce el programa.
		String[] listaColoresReconocidos = {"amarillo", "azul", "rojo", "verde"};
		//Declaramos un array que inicializamos a nulo, donde vamos a meter los colores que introduzca el usuario.
		String[] listaColoresUsuario = null;
		
		//Utilizamos una estructura de repeticón do-while para mostrar el menú mientras el usuario no introduzca la opción para salir.
		do {
			//Hacemos una llamada al método que contiene el menú de la clase InterfazUsuario.
			InterfazUsuario.imprimirMenu();
			//Indicamos el rango de opciones que puede introducir el usuario.
			System.out.println("\nIndica una opción (1-8):");
			//A la variable opcion le asignamos la entrada de datos, el número que introducido el usuario.
			opcion = sc.nextInt();
			
			//Utilizamos una estructura condional que maneja varias opciones
			switch (opcion) {
			
			/*
			 * Casi todas las opciones van a respetar la misma estructura:
			 * En cada opción hacemos la llamada a los métodos correspondientes, pasándoles sus correspondientes parámetros.
			 * La mayoría son métodos estáticos por lo que los llamamos desde la clase.
			 * Imprimimos el resultado de lo anterior mediente un syso.
			 * Seguido hacemos una llamada al método que espera a que usuario introduzca Enter que se encuentra en la clase InterfazUsuario.
			 * Con la palabra reservada break, salimos de la opción.
			 */

			case 1: //Pedir lista de colores al usuario
				//Le asignamos al array para el usuario el método que muestra la lista de colores.
				listaColoresUsuario = Colores.pedirListaColores();
				System.out.println("Completada la lista de colores por el usuario");
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;
			case 2: //Qué colores reconocidos hay en la lista del usuario
				//Antes de la llamada al método, verificamos si la lista de colores introducidos por el usurio está vacía.
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				//Si no está vacía, llamamos al método estático de la clase Colores que muestra la lista de colores reconocidos
				//por el programa al que le hemos pasado también la lista de colores introducidos por el usuario.
				else Colores.reconocidosListaUsuario(listaColoresReconocidos,listaColoresUsuario);
				InterfazUsuario.esperaIntro(sc);
				break;
			case 3: //Cuántas veces cada color en la lista del usuario
				//De la misma forma que en la opción anterior, verificamos que la lista se haya completado
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				//Si no está vacía, llamamos al método que muestra los colores del usuario que coinciden 
				//la lista de reconocidos por el programa.
				else Colores.cuantosReconocidosListaUsuario(listaColoresReconocidos,listaColoresUsuario);
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;
			case 4: //Ordenar colores de la lista del usuario
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				else{
					//En este caso, mostramos la lista ordenada de colores haciendo uso del método de la clase
					//Arrays que nos permite mostrar el contanido del array sin necesidad de iterarlo.
					System.out.println("\nLa lista ordenada de colores (primero los reconocidos y después "
								+ "los no reconcidos) queda de la forma:");
					System.out.println(Arrays.toString(Colores.ordenarListaUsuario(listaColoresReconocidos,listaColoresUsuario)));
				}
					//Esperamos a que el usuario presione Enter.
					InterfazUsuario.esperaIntro(sc);
				break;
			case 5: //Mostrar lista de colores reconocidos
				System.out.println("\nLa lista ordenada de colores reconocidos es:");
				//De la misma forma que con el método anterior, toString convierte el array de candenas a una representación de cadena de texto.
				//y lo mostramos a través de una salida de datos en consola, syso.
				System.out.println(Arrays.toString(listaColoresReconocidos));
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;
			case 6: //Incluir nuevo color en lista de colores reconocidos
				//Mediante un mensaje en consola le pedimos al usuario que introduza una cadena que represente un color.
				System.out.println("\nIndique el nuevo color reconocido:");
				//Declaramos una variable que guarda el color que ha introducido el usuario
				String color = sc.next();
				//La variable con el color del usuario se lo pasamos al método, que va a buscar dentro del método
				//del array de colores, calculando su inserción, en qué posición deberia situarse.
				//Y por último lo introduce.
				listaColoresReconocidos = Colores.insertarColorReconocido(listaColoresReconocidos,color);
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;
			case 7: //Eliminar color en lista de colores reconocidos
				//De la misma forma que la opción anterior, pedimos al usuario que introduzca un color.
				System.out.println("\nIndique el color a eliminar:");
				//Guardamos el color del usuario en una nueva variable.
				color = sc.next();
				//Al array de colores reconocidos le asignamos el método de la clase Colores que busca
				//dentro de array de colores reconocidos, el color del usuario y devuelve el array con el color borrado
				//y una posición menos.
				listaColoresReconocidos = Colores.eliminarColorReconocido(listaColoresReconocidos,color);
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;
			case 8: //Salimos del programa
				//Salida por consola
				System.out.println("Nos vamos");
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;				
			default:
				//Salida por consola
				System.out.println("Opción no válida");
				//Esperamos a que el usuario presione Enter.
				InterfazUsuario.esperaIntro(sc);
				break;				
			}
		
		//El bucle continúa hasta que el usuario elige la opción de salir.
		}while(opcion != 8);
	}
}
