/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods;

/**
 *
 * @author Ayyappa
 */
public class LCR {
     public static  double x;
    public double a;
    public int c;
    public double m;
    public LCR(double x2,int c2,double a2,double m2){
    x=x2;
    a=a2;
    c=c2;
    m=m2-1;
    
    }
    public double next(){
    double rand=0;
    rand=((a*x)+c)%m;
    x=rand;
   // rand=rand/(m+1);
        
         //   System.out.println("rand="+x);

        return rand;
    }
}
