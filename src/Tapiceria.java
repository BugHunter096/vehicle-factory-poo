public class Tapiceria
{

    private String tipoTapiceria;
    private String color;
    private double metrosCuadrados;
    private int stock;

    public Tapiceria(String tipoTapiceria, String color, double metrosCuadrados, int stock){

        this.tipoTapiceria = tipoTapiceria;
        this.color = color;
        this.metrosCuadrados = metrosCuadrados;
        this.stock = stock;

    }

    public Tapiceria(String tipoTapiceria, String color, double metrosCuadrados){

        this(tipoTapiceria, color, metrosCuadrados, 10);

    }

    public void setTipoTapiceria(String tipoTapiceria){

        this.tipoTapiceria = tipoTapiceria;

    }

    public String getTipoTapiceria(){

        return tipoTapiceria;

    }

    public void setColor(String color){

        this.color = color;

    }

    public String getColor(){

        return color;

    }

    public void setMetrosCuadrados(double metrosCuadrados){

        this.metrosCuadrados = metrosCuadrados;

    }

    public double getMetrosCuadrados(){

        return metrosCuadrados;

    }

    public int getStock(){

        return stock;

    }

    public void aumentarStock(int cantidad){

        stock = stock + cantidad;

    }

    public boolean reducirStock(int cantidad){

        if (cantidad <= stock){

            stock = stock - cantidad;
            return true;

        }

        return false;
    }

    public String toString(){

        return "Tapiceria " + tipoTapiceria +
               " | color: " + color +
               " | metros cuadrados: " + metrosCuadrados +
               " | stock: " + stock;

    }
}
