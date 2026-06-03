public class Motor
{
    
    private String tipoMotor;
    private double cilindrada;
    private double potencia;
    private int numCilindros;
    private int stock;
    
    public Motor(String tipoMotor, double cilindrada, double potencia, int numCilindros, int stock){
        
        this.tipoMotor = tipoMotor;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.numCilindros = numCilindros;
        this.stock = stock;
        
    }
    
    public void setTipoMotor(String tipoMotor){
        
        this.tipoMotor = tipoMotor;
        
    }
    
    public String getTipoMotor(){
        
        return tipoMotor;
        
    }
    
    public void setCilindrada(double cilindrada){
        
        this.cilindrada = cilindrada;
        
    }
    
    public double getCilindrada(){
        
        return cilindrada;
        
    }
    
    public void setPotencia(double potencia){
        
        this.potencia = potencia;
        
    }
    
    public double getPotencia(){
        
        return potencia;
        
    }
    
    public void setNumCilindros(int numCilindros){
        
        this.numCilindros = numCilindros;
        
    }
    
    public int getNumCilindros(){
        
        return numCilindros;
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
        
        return "Motor " + tipoMotor +
               " | cilindrada: " + cilindrada +
               " | potencia: " + potencia +
               " | cilindros: " + numCilindros +
               " | stock: " + stock;
    
    }
}