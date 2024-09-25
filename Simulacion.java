public class Simulacion {
    public static void simulacion(double[] soluciones, int pol) {
        double[] ejemplos = {45, 78, 86, 102, 53};
        double resultado = 0;
        if (pol == 1) {
            for (int i = 0; i < ejemplos.length; i++) {
                resultado = soluciones[0] + ejemplos[i] * soluciones[1];
                System.out.println("X" + ejemplos[i] + ": " + resultado);
                resultado = 0;
            }
        } else {
            for (int i = 0; i < ejemplos.length; i++) {
                for (int j = 0; j < pol; j++) {
                    resultado += soluciones[j] * Math.pow(ejemplos[i], j);
                }
                System.out.println("X" + ejemplos[i] + ": " + resultado);
                resultado = 0;
            }
        }
    }
}
