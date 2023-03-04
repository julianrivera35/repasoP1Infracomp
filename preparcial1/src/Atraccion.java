import java.util.concurrent.Semaphore;

public class Atraccion {
    int nFilas;
    int nSillas;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);

    public Atraccion(int dFilas, int dSillas){
        this.nFilas = dFilas;
        this.nSillas = dSillas;
    }

    public boolean verficarSillas(int tamMiembro){
        try {
            mutex.acquire();
            if(tamMiembro >= 1 && tamMiembro <=(nSillas/2)){
                mutex.release();
                return true;
                
            }
            else{
                mutex.release();
                return false;
            }
            
        }catch (InterruptedException e){
            return false;
        }
        
        
        
    }

    public boolean apartarAtraccion(int aFilas, int aSillas, int tamMiembro){

        
        if(aFilas <= nFilas && aSillas <= (nSillas/2)){
            nFilas = nFilas - aFilas;
            nSillas = nSillas - aSillas;
            System.out.println("Sigan mis reyes");
            return true;
        }
        else{
            System.out.println("No nos queda suficiente espacio.");
            return false;
        }
        

    }

    public void irseAlaVerga(int aFilas, int aSillas){
        try {
            mutex2.acquire();
            nFilas = nFilas + aFilas;
            nSillas = nSillas + aSillas;
            System.out.println("Nos fuimos.");
            mutex.release();
            mutex2.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
