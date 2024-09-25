import java.util.ArrayList;

public class DataSet {
    double observacion;
    double factor1;
    double factor2;
    double factor3;
    double yield;
    public static ArrayList<DataSet> Datos =new ArrayList<>();

    public DataSet (double Observation, double factor1, double factor2, double factor3, double yield){
        this.observacion= observacion;
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.factor3 = factor3;
        this.yield = yield;
    }

    public DataSet (double Observation, double factor1, double factor2, double yield){
        this.observacion= observacion;
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.yield = yield;
    }

    public DataSet (double Observation, double factor1, double yield){
        this.observacion= observacion;
        this.factor1 = factor1;
        this.yield = yield;
    }


    public static DataSet Polynomial(){
        Datos.add(new DataSet(1,108,95));
        Datos.add(new DataSet(1,115,96));
        Datos.add(new DataSet(1,106,95));
        Datos.add(new DataSet(1,97,97));
        Datos.add(new DataSet(1,95,93));
        Datos.add(new DataSet(1,91,94));
        Datos.add(new DataSet(1,97,95));
        Datos.add(new DataSet(1,83,93));
        Datos.add(new DataSet(1,83,92));
        Datos.add(new DataSet(1,78,86));
        Datos.add(new DataSet(1,54,73));
        Datos.add(new DataSet(1,67,80));
        Datos.add(new DataSet(1,56,65));
        Datos.add(new DataSet(1,53,69));
        Datos.add(new DataSet(1,61,77));
        Datos.add(new DataSet(1,115,96));
        Datos.add(new DataSet(1,81,87));
        Datos.add(new DataSet(1,78,89));
        Datos.add(new DataSet(1,30,60));
        Datos.add(new DataSet(1,45,63));
        Datos.add(new DataSet(1,99,95));
        Datos.add(new DataSet(1,32,61));
        Datos.add(new DataSet(1,25,55));
        Datos.add(new DataSet(1,28,56));
        Datos.add(new DataSet(1,90,94));
        Datos.add(new DataSet(1,89,93));
        return null;
    }
}
