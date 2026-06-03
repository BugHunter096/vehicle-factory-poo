import java.util.ArrayList;

public class Planificador
{
    
    private ArrayList<CadenaMontaje> listaCadenas;
    private int segundoActual;
    private boolean simulacionActiva;
    
    public Planificador(){
        
        listaCadenas = new ArrayList<CadenaMontaje>();
        segundoActual = 0;
        simulacionActiva = false;
        
    }
    
    public void addCadena(CadenaMontaje cadena){
        
        listaCadenas.add(cadena);
        
    }
    
    public void iniciarSimulacionSimple(){
        
        segundoActual = 0;
        simulacionActiva = true;
    
        while (simulacionActiva){
            
            segundoActual++;
    
            System.out.println("Segundo " + segundoActual);
    
            for (CadenaMontaje cadena : listaCadenas){
                
                cadena.avanzarUnSegundo();
    
                System.out.println("Cadena " + cadena.getTipoVehiculoQueProduce() +
                    " | Estado: " + cadena.getEstadoActual() +
                    " | Pendientes: " + cadena.getUnidadesPendientes() +
                    " | Terminados: " + cadena.getVehiculosTerminados());
            }
    
            if (!hayCadenasActivas()){
                
                simulacionActiva = false;
            
            }
        }
    }
    
    private boolean hayCadenasActivas(){
        
        for(CadenaMontaje cadena : listaCadenas){
            
            if(cadena.isActiva()){
                
                return true;
                
            }
        }
        
        return false;
        
    }
    
     public int getSegundoActual(){
         
        return segundoActual;
    
    }

    public boolean isSimulacionActiva(){
        
        return simulacionActiva;
    
    }

    public ArrayList<CadenaMontaje> getListaCadenas(){
        
        return listaCadenas;

    }
    
}