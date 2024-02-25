import java.util.ArrayList;
import java.util.List;

// Ejercicio1
// Explique que es un metodo recursivo
// La recursividad es un método de cual se llama a el mísmo

public class Ejercicio2 {

    // 1. Suma de los números naturales hasta n
    public static int sumaNaturales(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    // 2. Factorial de un número
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // 3. Potencia n-ésima de un número
    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    // 4. Suma de los elementos de una lista
    public static int sumaLista(List<Integer> lista) {
        if (lista.isEmpty()) {
            return 0;
        } else {
            return lista.get(0) + sumaLista(lista.subList(1, lista.size()));
        }
    }

    // 5. Media aritmética de una lista
    public static double mediaLista(List<Integer> lista) {
        int suma = sumaLista(lista);
        return (double) suma / lista.size();
    }

    // 6. Desviación típica de una lista
    public static double desviacionTipica(List<Integer> lista) {
        double media = mediaLista(lista);
        double sumaCuadrados = 0;
        for (int num : lista) {
            sumaCuadrados += Math.pow(num - media, 2);
        }
        return Math.sqrt(sumaCuadrados / lista.size());
    }

    // 7. Suma de los primeros números pares hasta n
    public static int sumaPares(int n) {
        if (n <= 1) {
            return 0;
        } else {
            if (n % 2 == 0) {
                return n + sumaPares(n - 2);
            } else {
                return sumaPares(n - 1);
            }
        }
    }

    // 8. Suma de los elementos pares de una lista
    public static int sumaParesLista(List<Integer> lista) {
        if (lista.isEmpty()) {
            return 0;
        } else {
            int primerElemento = lista.get(0);
            if (primerElemento % 2 == 0) {
                return primerElemento + sumaParesLista(lista.subList(1, lista.size()));
            } else {
                return sumaParesLista(lista.subList(1, lista.size()));
            }
        }
    }

    // 9. Obtener lista de números pares
    public static List<Integer> obtenerListaPares(List<Integer> lista) {
        if (lista.isEmpty()) {
            return new ArrayList<>();
        } else {
            int primerElemento = lista.get(0);
            List<Integer> restoLista = obtenerListaPares(lista.subList(1, lista.size()));
            if (primerElemento % 2 == 0) {
                restoLista.add(0, primerElemento);
            }
            return restoLista;
        }
    }

    // 10. Lista de los primeros números pares hasta n
    public static List<Integer> listaPares(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        } else {
            List<Integer> lista = listaPares(n - 1);
            if (n % 2 == 0) {
                lista.add(n);
            }
            return lista;
        }
    }

    // 11. Producto escalar de dos listas
    // El throw lo utilizo para hacer una excepcion , ya que no se puede utilizar 2 listas de diferente longitud
    public static int productoEscalar(List<Integer> lista1, List<Integer> lista2) {
        if (lista1.size() != lista2.size()) {
            throw new IllegalArgumentException("Las listas deben tener la misma longitud");
        } else if (lista1.isEmpty()) {
            return 0;
        } else {
            return lista1.get(0) * lista2.get(0) + productoEscalar(lista1.subList(1, lista1.size()), lista2.subList(1, lista2.size()));
        }
    }

    // 12. Elemento n-ésimo de la sucesión de Fibonacci
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // 13. Cociente entre el decimotercero y el decimosegundo elemento de Fibonacci
    public static double cocienteFibonacci() {
        double decimoTercero = fibonacci(13);
        double decimoSegundo = fibonacci(12);
        return decimoTercero / decimoSegundo;
    }

    // 14. Relación entre la sucesión de Fibonacci y la razón áurea
    public static double[] relacionFibonacciRazonAurea() {
        double ratio = fibonacci(13) / (double) fibonacci(12);
        double goldenRatio = 1 + Math.sqrt(5) / 2;
        return new double[]{ratio, goldenRatio};
    }

    // Ejercicio 3
    // ¿En qué consiste el problema de las Torres de Hanoi? ¿Cómo puede resolverse?
    // Te dan un conjunto de tres varillas y discos, con cada disco de un tamaño diferente. Llamemos a las varillas A, B y C, y numeremos los discos desde 1, el disco más pequeño, hasta , el disco más grande. Al principio, todos los discos están en la varilla A, en orden de tamaño decreciente de la parte inferior a la parte superior, de modo que el disco está en la parte inferior y el disco 1 está en la parte superior.
    // El objetivo es pasar todos los discos de la varilla A a la varilla B:
    public static void torresHanoi(int n, String torreOrigen, String torreDestino, String torreAuxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de la torre " + torreOrigen + " a la torre " + torreDestino);
            return;
        }
        torresHanoi(n - 1, torreOrigen, torreAuxiliar, torreDestino);
        System.out.println("Mover disco " + n + " de la torre " + torreOrigen + " a la torre " + torreDestino);
        torresHanoi(n - 1, torreAuxiliar, torreDestino, torreOrigen);
    }

    public static void main(String[] args) {
        int numDiscos = 3;
        torresHanoi(numDiscos, "Torre A", "Torre C", "Torre B");
    }

    // Ejercicio 4
    public static double integralEXCuadrado(double limInf, double limSup, double h) {
        return integralEXCuadradoRecursivo(limInf, limSup, h, limInf);
    }

    private static double integralEXCuadradoRecursivo(double limInf, double limSup, double h, double x) {
        if (x >= limSup) {
            return 0;
        } else {
            double fx = Math.exp(x * x); // Evaluamos la función en x
            double areaRectangulo = fx * h; // Área del rectángulo en x
            return areaRectangulo + integralEXCuadradoRecursivo(limInf, limSup, h, x + h); // Sumamos el área del rectángulo actual y seguimos con el siguiente punto
        }
    }
    // Ejercicio 5
    // una versión recursiva de un método puede provocar un desbordamiento de pila si no se gestiona correctamente la recursión o si la entrada es lo suficientemente grande como para superar el límite de la pila de llamadas del sistema. En contraste, una versión no recursiva del mismo método suele ser más eficiente en cuanto a memoria y menos propensa a causar desbordamientos de pila.
    

    // Ejercicio 6 
    // public class SumaCodigos {

    public static int sumaCodigos(String str) {
        if (str.isEmpty()) {
            return 0;
        } else {
            int codigo = str.charAt(0);
            return codigo + sumaCodigos(str.substring(1));
        }
    }
}
    // seguimos en el ejercicio 6 pero necesitamos dos clases
    // public class OtroLugar {

    public static void otroMetodo() {
        String cadena = "Hola Paloma";
        int suma = SumaCodigos.sumaCodigos(cadena);
        System.out.println("La suma de los códigos Unicode de \"" + cadena + "\" es: " + suma);
    }

    // Ejercicio 7
    public class CifradoCesar {

        public static String cifrarCadena(String str, int desplazamiento) {
            if (str.isEmpty()) {
                return "";
            } else {
                String primerCaracter = str.substring(0, 1);
                String nuevoCaracter = cifrarCaracter(primerCaracter, desplazamiento);
                return nuevoCaracter + cifrarCadena(str.substring(1), desplazamiento);
            }
        }
    
        private static String cifrarCaracter(String c, int desplazamiento) {
            if (Character.isLetter(c.charAt(0))) {
                int codigo = (c.charAt(0) - 'a' + desplazamiento) % 26 + 'a';
                return String.valueOf((char) codigo);
            } else {
                return c; 
            }
        }
    
        public static void main(String[] args) {
            String mensaje = "César dice hola";
            int desplazamiento = 3;
            String mensajeCifrado = cifrarCadena(mensaje, desplazamiento);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);
        }
    }
    // Ejercicio 8

        public static String conCodigoPar(String str) {
            if (str.isEmpty()) {
                return "";
            } else {
                char primerCaracter = str.charAt(0);
                if (primerCaracter % 2 == 0) {
                    return primerCaracter + conCodigoPar(str.substring(1));
                } else {
                    return conCodigoPar(str.substring(1));
                }
            }
        }
    
        public static void main(String[] args) {
            String cadena = "Llego mañana";
            String cadenaPar = conCodigoPar(cadena);
            System.out.println("Cadena con caracteres de código par: " + cadenaPar);
        }
    }





