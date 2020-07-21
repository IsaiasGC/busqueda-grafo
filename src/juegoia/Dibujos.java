package juegoia;
import java.awt.Color;
import java.awt.Graphics;

public class Dibujos {    
    static Graphics g;
    public  void pintarLinea(Graphics g,int x,int y,int x1,int y1){ 
        this.g=g;
        g.drawLine(x, y, x1, y1);        
        g.setColor(new Color(240,240,240));
    }
    
    public static void inicio(Graphics g,int x,int y,int x1,int y1){        
        g.setColor(Color.GREEN);        
        g.fillRect(x, y, x1, y1);        
        
    }
    
    public static void fin(Graphics g,int x,int y,int x1,int y1){        
        g.setColor(Color.RED);        
        g.fillRect(x, y, x1, y1);        
    }
        
    public static void bl(Graphics g,int x,int y,int x1,int y1){        
        g.fillRect(x, y, x1, y1);        
        g.setColor(Color.BLACK);        
    }    
    public void cam(int x,int y){        
        g.fillRect(x, y, 20, 20);        
        g.setColor(Color.orange);        
    }    
    
    public static void borrar(Graphics g,int x,int y,int x1,int y1){
        g.setColor(new Color(240,240,240));        
    }
}
