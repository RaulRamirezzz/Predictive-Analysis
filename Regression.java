import java.util.ArrayList;
import java.lang.Math;

public class Regression {
    public static void regresion(int grado){
        DataSet.Polynomial();
        ArrayList<DataSet> datos = DataSet.Datos;
        int n = datos.size();

        // Segmentar el dataset 70% - 30%
        ArrayList<DataSet> datosEntrenamiento = new ArrayList<>();
        ArrayList<DataSet> datosPrueba = new ArrayList<>();

        // Segmentar el dataset 30% - 70%
        ArrayList<DataSet> datosEntrenamiento2 = new ArrayList<>();
        ArrayList<DataSet> datosPrueba2 = new ArrayList<>();

        // Dividir el dataset en 70% - 30%
        int nEntrenamiento = (int) (n * 0.7);
        for (int i = 0; i < nEntrenamiento; i++) {
            datosEntrenamiento.add(datos.get(i));
        }
        for (int i = nEntrenamiento; i < n; i++) {
            datosPrueba.add(datos.get(i));
        }

        // Dividir el dataset en 30% - 70%
        int nEntrenamiento2 = (int) (n * 0.3);
        for (int i = 0; i < nEntrenamiento2; i++) {
            datosPrueba2.add(datos.get(i));
        }
        for (int i = nEntrenamiento2; i < n; i++) {
            datosEntrenamiento2.add(datos.get(i));
        }

        // Definir el grado del modelo
        int col = grado + 1;

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("--------------- 70% - 30% ---------------");

        // Calcular los coeficientes usando el conjunto de entrenamiento
        double matrizSumatorias[][] = Algebra.guardarMatriz(datosEntrenamiento, grado);
        double matrizGauss[][] = Algebra.gaussJordan(matrizSumatorias, grado);
        double[] soluciones = Algebra.separarResultados(matrizGauss, grado);

        // Calcular el error en el conjunto de prueba
        double error = Calculo.calcularError(datosPrueba, soluciones, grado);
        System.out.println("Error cuadrático medio: " + error);
        System.out.println("Raiz error cuadrático medio: " + Math.sqrt(error));

        // Calcular correlación y r²
        double correlacion = Calculo.calcularCorrelacion(datosEntrenamiento);
        double r2 = Calculo.calculateR2(datosPrueba, soluciones);
        System.out.println("Correlación (r): " + correlacion);
        System.out.println("Coeficiente de determinación (r²): " + r2);

        // Mostrar los coeficientes calculados
        for (int i = 0; i < col; i++) {
            System.out.println("B" + i + ": " + soluciones[i]);
        }

        // Simulación de predicciones
        System.out.println("Simulaciones:");
        Simulacion.simulacion(soluciones, grado);

        /////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("--------------- 30% - 70% ---------------");

        // Calcular los coeficientes usando el conjunto de entrenamiento
        double matrizSumatorias2[][] = Algebra.guardarMatriz(datosEntrenamiento2, grado);
        double matrizGauss2[][] = Algebra.gaussJordan(matrizSumatorias2, grado);
        double[] soluciones2 = Algebra.separarResultados(matrizGauss2, grado);

        // Calcular el error en el conjunto de prueba
        double error2 = Calculo.calcularError(datosPrueba2, soluciones2, grado);
        System.out.println("Error cuadrático medio: " + error2);
        System.out.println("Raiz error cuadrático medio: " + Math.sqrt(error2));

        // Calcular correlación y r²
        double correlacion2 = Calculo.calcularCorrelacion(datosEntrenamiento2);
        double r22 = Calculo.calculateR2(datosPrueba2, soluciones2);
        System.out.println("Correlación (r): " + correlacion2);
        System.out.println("Coeficiente de determinación (r²): " + r22);

        // Mostrar los coeficientes calculados
        for (int i = 0; i < col; i++) {
            System.out.println("B" + i + ": " + soluciones2[i]);
        }

        // Simulación de predicciones
        System.out.println("Simulaciones:");
        Simulacion.simulacion(soluciones2, grado);
    }
}
