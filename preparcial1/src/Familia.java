public class Familia extends Thread {
    Atraccion atraccion;
    int tamMiembro;
    int nSillas;
    int nFilas;
    
    public Familia(int dTamMiembro, Atraccion dAtraccion, int dSillas, int dFilas){
        this.tamMiembro = dTamMiembro;
        this.atraccion = dAtraccion;
        this.nSillas = dSillas;
        this.nFilas = dFilas;
    }

    public void run() {
        boolean centinela = true;
        while(centinela){
            if(atraccion.verficarSillas(tamMiembro)){
                if(atraccion.apartarAtraccion(nFilas, nSillas, tamMiembro)){
                    synchronized(atraccion){
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
            
                        atraccion.irseAlaVerga(nFilas, nSillas);
                        atraccion.notify();
                        centinela = false;
                        
                    }
                    
                }
                else{
                    synchronized(atraccion){
                        System.out.println("Esperando en la fila.");
                        try {
                            atraccion.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    }
                    
                }
            }
            else{
                System.out.println("Son muchos, hay que culear menos.");
                centinela = false;
            }
            
        }
        System.out.println("Terminó el thread.");
    }
}
