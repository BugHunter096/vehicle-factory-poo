public class Ruedas
{

    private String tipoRueda;
    private double anchuraMm;
    private double diametroLlanta;
    private double indiceCarga;
    private int codVelocidad;
    private int stock;

    public Ruedas(String tipoRueda, double anchuraMm, double diametroLlanta, double indiceCarga, int codVelocidad, int stock){

        this.tipoRueda = tipoRueda;
        this.anchuraMm = anchuraMm;
        this.diametroLlanta = diametroLlanta;
        this.indiceCarga = indiceCarga;
        this.codVelocidad = codVelocidad;
        this.stock = stock;
    }

    public Ruedas(String tipoRueda, double anchuraMm, double diametroLlanta, double indiceCarga, int codVelocidad){

        this(tipoRueda, anchuraMm, diametroLlanta, indiceCarga, codVelocidad, 10);

    }

    public void setTipoRueda(String tipoRueda){

        this.tipoRueda = tipoRueda;

    }

    public String getTipoRueda(){

        return tipoRueda;

    }

    public void setAnchuraMm(double anchuraMm){

        this.anchuraMm = anchuraMm;

    }

    public double getAnchuraMm(){

        return anchuraMm;

    }

    public void setDiametroLlanta(double diametroLlanta){

        this.diametroLlanta = diametroLlanta;

    }

    public double getDiametroLlanta(){

        return diametroLlanta;

    }

    public void setIndiceCarga(double indiceCarga){

        this.indiceCarga = indiceCarga;

    }

    public double getIndiceCarga(){

        return indiceCarga;
    }

    public void setCodVelocidad(int codVelocidad){

        this.codVelocidad = codVelocidad;

    }

    public int getCodVelocidad(){

        return codVelocidad;
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

        return "Ruedas " + tipoRueda +
               " | anchura: " + anchuraMm +
               " | llanta: " + diametroLlanta +
               " | carga: " + indiceCarga +
               " | velocidad: " + codVelocidad +
               " | stock: " + stock;
    }
}
