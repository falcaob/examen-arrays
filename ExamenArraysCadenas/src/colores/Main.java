package colores;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		String[] listaColoresReconocidos = {"amarillo", "azul", "rojo", "verde"};
		String[] listaColoresUsuario = null;
		
		do {
			InterfazUsuario.imprimirMenu();
			System.out.println("\nIndica una opción (1-8):");
			opcion = sc.nextInt();
			
			switch (opcion) {

			case 1: //Pedir lista de colores al usuario
				listaColoresUsuario = Colores.pedirListaColores();
				System.out.println("Completada la lista de colores por el usuario");
				InterfazUsuario.esperaIntro(sc);
				break;
			case 2: //Qué colores reconocidos hay en la lista del usuario
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				else Colores.reconocidosListaUsuario(listaColoresReconocidos,listaColoresUsuario);
				InterfazUsuario.esperaIntro(sc);
				break;
			case 3: //Cuántas veces cada color en la lista del usuario
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				else Colores.cuantosReconocidosListaUsuario(listaColoresReconocidos,listaColoresUsuario);
				InterfazUsuario.esperaIntro(sc);
				break;
			case 4: //Ordenar colores de la lista del usuario
				if (listaColoresUsuario == null) System.out.println("Rellene antes la lista de colores");
				else{
					System.out.println("\nLa lista ordenada de colores (primero los reconocidos y después "
								+ "los no reconcidos) queda de la forma:");
					System.out.println(Arrays.toString(Colores.ordenarListaUsuario(listaColoresReconocidos,listaColoresUsuario)));
				}
					InterfazUsuario.esperaIntro(sc);
				break;
			case 5: //Mostrar lista de colores reconocidos
				System.out.println("\nLa lista ordenada de colores reconocidos es:");
				System.out.println(Arrays.toString(listaColoresReconocidos));
				InterfazUsuario.esperaIntro(sc);
				break;
			case 6: //Incluir nuevo color en lista de colores reconocidos
				System.out.println("\nIndique el nuevo color reconocido:");
				String color = sc.next();
				listaColoresReconocidos = Colores.insertarColorReconocido(listaColoresReconocidos,color);
				InterfazUsuario.esperaIntro(sc);
				break;
			case 7: //Eliminar color en lista de colores reconocidos
				System.out.println("\nIndique el color a eliminar:");
				color = sc.next();
				listaColoresReconocidos = Colores.eliminarColorReconocido(listaColoresReconocidos,color);
				InterfazUsuario.esperaIntro(sc);
				break;
			case 8: //Salimos del programa
				System.out.println("Nos vamos");
				InterfazUsuario.esperaIntro(sc);
				break;				
			default:
				System.out.println("Opción no válida");				
				InterfazUsuario.esperaIntro(sc);
				break;				
			}
			
		}while(opcion != 8);
	}
	
	
	


}
