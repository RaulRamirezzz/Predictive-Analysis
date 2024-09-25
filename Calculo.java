import java.util.ArrayList;

public class Calculo {
    public static double calcularError(ArrayList<DataSet> datos, double[] coeficientes, int grado) {
        int m = datos.size();
        double errorCuadraticoMedio = 0.0;

        for (DataSet dato : datos) {
            double x = dato.factor1;
            double y = dato.yield;

            // Calcular el valor predicho por el polinomio
            double valorPredicho = 0;
            for (int j = 0; j <= grado; j++) {
                valorPredicho += coeficientes[j] * Math.pow(x, j);
            }

            // Calcular el cuadrado de la diferencia y sumarlo al error cuadrático medio
            errorCuadraticoMedio += Math.pow(valorPredicho - y, 2);
        }

        // Calcular el ECM promediando las diferencias cuadráticas
        errorCuadraticoMedio /= m;

        return errorCuadraticoMedio;
    }

    public static double calcularCorrelacion(ArrayList<DataSet> datos) {
        int n = datos.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        for (DataSet dato : datos) {
            double x = dato.factor1;
            double y = dato.yield;

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }

        // Fórmula de correlación
        double correlacion = (n * sumXY - sumX * sumY) / Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        return correlacion;
    }

    // Método para calcular el R^2
    public static double calculateR2(ArrayList<DataSet> datos, double[] coeficientes) {
        double sumSquaredTotal = 0;
        double sumSquaredResidual = 0;
        double meanY = 0;

        // Calcular la media de Y
        for (DataSet p : datos) {
            meanY += p.yield;
        }
        meanY /= datos.size();

        for (DataSet p : datos) {
            double prediccion = 0;
            double x = p.factor1;

            // Calcular la predicción basada en el polinomio con coeficientes
            for (int i = 0; i < coeficientes.length; i++) {
                prediccion += coeficientes[i] * Math.pow(x, i);
            }

            // Suma de cuadrados total
            sumSquaredTotal += Math.pow(p.yield - meanY, 2);

            // Suma de cuadrados residual (diferencia entre observado y predicho)
            sumSquaredResidual += Math.pow(p.yield - prediccion, 2);
        }

        // Calcular R^2 = 1 - (SS_res / SS_tot)
        return 1 - (sumSquaredResidual / sumSquaredTotal);
    }
}
