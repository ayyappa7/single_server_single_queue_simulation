/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 *
 * @author Ayyappa
 */
public class Rand {
    public static LCR rn1;
public static LCR rn2;
public static LCR rn3;
public static LCR rn4;
public static double max;
     public Rand() throws FileNotFoundException, UnsupportedEncodingException{
         double m1,m2,m3,m4;
         double a1,a2,a3,a4;
        int c1=0,c2=0,c3=61684,c4=14;
         m1=2147483563;
         m2=2147483399;
         m3=Math.pow(2, 31);
         m4=Math.pow(2, 31);
         a1=400;
         a2=406;
         a3=Math.pow(11,6);
         a4=Math.pow(17,7);
         
         
 rn1=new LCR(354646,c1,a1,m1);
 rn2=new LCR(684556,c2,a2,m2);
 rn3=new LCR(665,c3,a3,m3);
 rn4=new LCR(54685,c4,a4,m4);
max=Math.pow(2,31);
 
     }
public static  double nextrand( ){
   double rand;
    rand=(rn1.next()-rn2.next())%2147483562;//+rn3.next()-rn4.next())%(max);
    if(rand>0)
    rand=rand/2147483563;
    else if (rand<0)
        rand=(rand/2147483563)+1;
    else
       rand= 2147483562/2147483563;
return rand;
}

}
