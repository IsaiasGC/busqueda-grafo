/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoia;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaias
 */
public class Busqueda {
    
    private ArrayList<Camino> grafo;
    private ColaOrdenada frontera;
    private ArrayList<Integer> hijosVisitados;
    private int meta;
    private Dibujos d;
    
    public Busqueda(Dibujos d){
        this.d=d;
        frontera=new ColaOrdenada();
        hijosVisitados=new ArrayList<>();
    }
    public void setGrafo(ArrayList<Camino> grafo){
        this.grafo=grafo;
    }
    public void setParametros(int inicio, int meta){
        this.meta=meta;
        frontera.insertar(inicio, 0);
    }
    public void buscar(){
        
    }
    public void iniciarBusqueda(){
        Nodo seleccion;
        boolean termina=false;
//        System.out.println("Iniciando busqueda...");
        while(!frontera.vacio() && !termina){
            seleccion=frontera.extraer();
//            System.out.println("seleccion: "+seleccion.nombre);
            if(seleccion.nombre==meta){
                hijosVisitados.add(seleccion.nombre);
                JOptionPane.showMessageDialog(null, seleccion.nombre+"("+seleccion.costo+")");
                termina=true;
            }else{
                int x=seleccion.nombre%20, y=seleccion.nombre/20;
                
                x=(20*(x))+10;
                y=(20*(y))+30;
                d.cam(x, y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
                hijosVisitados.add(new Integer(seleccion.nombre));
                //Expandir grafo
                ColaOrdenada hijosNoVisitados=new ColaOrdenada();
                Camino hijo;
//                System.out.println("Hijos de "+seleccion.nombre+"...");
                for(int i=0; i<grafo.size(); i++) {
                    if(grafo.get(i).de==seleccion.nombre){
                        hijo=grafo.get(i);
                        if(!visitado(hijo.a)){
//                            System.out.print(hijo.a+"\t");
                            hijosNoVisitados.insertar(hijo.a, seleccion.costo+hijo.costo);
                        }
                    }
                }
                agregarFrontera(hijosNoVisitados);
            }
        }
        if(termina){
            for (int i=0; i<hijosVisitados.size(); i++) {
                System.out.print(hijosVisitados.get(i)+", ");
            }
        }else{
            System.out.println("No hay soluion");
        }
    }
    public boolean visitado(int nombre){
        for (int i=0; i<hijosVisitados.size(); i++) {
            if(hijosVisitados.get(i)==nombre){
                return true;
            }
        }
        return false;
    }
    public void agregarFrontera(ColaOrdenada hijos){
        Nodo nuevo, exis;
        while(!hijos.vacio()){
            nuevo=hijos.extraer();
            exis=frontera.extraer(nuevo.nombre);
            if(exis!=null){
                if(exis.costo<nuevo.costo){
                    nuevo=exis;
                }
            }
            frontera.insertar(nuevo.nombre, nuevo.costo);
        }
    }
    
}
