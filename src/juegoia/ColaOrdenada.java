/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoia;

/**
 *
 * @author Isaias
 */
public class ColaOrdenada {
    
    private Nodo nodo;
    
    public void insertar(int c, int costo){
        Nodo nuevo=new Nodo();
        nuevo.nombre=c;
        nuevo.costo=costo;
        if(vacio()){
            nuevo.sig=null;
            nodo=nuevo;
        }else{
            if(nodo.costo>nuevo.costo){
                nuevo.sig=nodo;
                nodo=nuevo;
            }else{
                Nodo ant=nodo;
                boolean listo=false;
                while(ant.sig!=null && !listo){
                    if(ant.sig.costo>nuevo.costo){
                        listo=true;
                    }else{
                        ant=ant.sig;
                    }
                }
                nuevo.sig=ant.sig;
                ant.sig=nuevo;
            }
        }
    }
    public Nodo extraer(){
        if(!vacio()){
            Nodo c=nodo;
            nodo=nodo.sig;
            c.sig=null;
            return c;
        }
        return null;
    }
    public Nodo extraer(int nombre){
        Nodo ant=nodo, c=null;
        if(ant!=null){
            if(ant.nombre==nombre){
                c=nodo;
                nodo=nodo.sig;
                c.sig=null;
            }else{
                while(ant.sig!=null){
                    if(ant.sig.nombre==nombre){
                        c=ant.sig;
                        ant.sig=c.sig;
                        c.sig=null;
                    }else{
                        ant=ant.sig;
                    }
                }
            }
        }
        return c;
    }
    public boolean vacio(){
        return nodo==null;
    }
}
