public abstract class Vehiculo
{
    
    private String color;
    private int numPlazas;
    private double tara;
    private double pesoMaxAutorizado;
    
    public Vehiculo(String color, int numPlazas, double tara, double pesoMaxAutorizado){
    
        this.color = color;
        this.numPlazas = numPlazas;
        this.tara = tara;
        this.pesoMaxAutorizado = pesoMaxAutorizado;
    
    }
    
    public void setColor(String color){
        
        this.color = color;
        
    }
    
    public String getColor(){
        
        return color;
        
    }
    
    public int getNumPlazas(){
        
        return numPlazas;
        
    }
    
    public void setTara(double tara){
        
        this.tara = tara;
        
    }
    
    public double getTara(){
        
        return tara;
        
    }
    
    public void setPesoMaxAutorizado(double pesoMaxAutorizado){
        
        this.pesoMaxAutorizado = pesoMaxAutorizado;
        
    }
    
    public double getPesoMaxAutorizado(){
        
        return pesoMaxAutorizado;
    }
    


    public String toString(){

        return getClass().getSimpleName() +
               " | color: " + color +
               " | plazas: " + numPlazas +
               " | tara: " + tara +
               " | peso maximo autorizado: " + pesoMaxAutorizado;
    }

}
