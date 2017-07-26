/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods;
import java.io.*;

/**
 *
 * @author Ayyappa
 */
class Onetrial {
    BufferedReader br = null;
    FileReader fr=null;
    Rand rn;
    PrintWriter writer;
    PrintWriter writer2;
    int[] st,iat;
    double[]  piat,pst,cpiat,cpst;
     int irp,srp;
    public Onetrial() throws FileNotFoundException, IOException{
        rn= new Rand();
        String[] rls= new String[3];
        piat=new double[30];
        pst=new double[30];
        cpiat=new double[30];
        cpst=new double[30];
        st = new int[30];
        iat= new int[30];
       irp=0;srp=0;
        fr=new FileReader("C:\\Users\\PERSONAL\\Desktop\\rand\\input.txt");
        br = new BufferedReader(fr);
    String rl;
        while((rl=br.readLine())!=null){
            if ('i'==rl.charAt(0)){
           rls= rl.split(",");
           piat[irp]=Double.parseDouble(rls[2]);
           iat[irp]=Integer.parseInt(rls[1]);
           irp++;
            System.out.println("piat["+irp+"-1]="+piat[irp-1]+"iat["+irp+"-1]="+iat[irp-1]);
            }else if('s'==rl.charAt(0)) {
            rls=rl.split(",");
            pst[srp]=Double.parseDouble(rls[2]);
           st[srp]=Integer.parseInt(rls[1]);
           srp++;
             System.out.println("pst["+srp+"-1]="+pst[srp-1]+"st["+srp+"-1]="+st[srp-1]);
            
            }
    System.out.println(rl);
   
    
    }
     writer=new PrintWriter("C:\\Users\\PERSONAL\\Desktop\\rand\\output1.txt");    
     writer2=new PrintWriter("C:\\Users\\PERSONAL\\Desktop\\rand\\output2.txt");   
     writer2.println("Sno \t time\t AAWT");
    calcprob();
    
    calaawt();
    writer.close();
    writer2.close();
    }
    public void calcprob(){
     cpiat[0]=piat[0];
    for(int i=1;i<irp;i++)
      {
          for(int j=i;j>=0;j--)
          {cpiat[i]=cpiat[i]+piat[j];
        
          }   System.out.println("cpiat["+i+"]="+cpiat[i]);
          
     } 
    cpst[0]=pst[0];
    for(int i=1;i<srp;i++)
      {
          for(int j=i;j>=0;j--)
          {cpst[i]=cpst[i]+pst[j];
         
          } System.out.println("cpst["+i+"]="+cpst[i]);
      } 
    
    }

    public void calaawt() {
        
     int ntrials=1000,ntime=100,trialcon=2,timecon=100;
               
                 double awt=0,aawt=0,aaawt=0;
                 int k=0;
                   for(int i=1;i<=ntrials;i++){
                      aawt=0;
                     for(int j=1;j<=i*trialcon;j++){
                         
                       awt=Avgwt(timecon);
                        
                       aawt=aawt+awt;
                     }
                    
                     aawt=aawt/i*trialcon;
                     writer2.println(" "+i+"\t "+i*trialcon+"\t "+aawt);
                   writer.println(aawt);
                 //  System.out.println("written"+aawt);
                   }
        
    }
    
     public double Avgwt(int rntime){

  double stoptime,currenttime,awt2=0; 
  
 stoptime=rntime;
 
 currenttime=0;
  int stp2=0,st2=0,ste2=0,iatp2=0,iat2=0,at2=0,wt=0,stbg=0,runs=0;
  while(currenttime<stoptime){
      
     
     //  System.out.println("rnst"+rnst2);
 
    
   while(cpst[stp2]< rn.nextrand() )
   {
    stp2++;
    }
  
    st2=(st[stp2]);
   
    ste2=stbg+st2;//Departure event at ste2
      
    
   iatp2=0;
    while(cpiat[iatp2]<rn.nextrand())
    {
    iatp2++;
    }
    
    iat2=(iat[iatp2]);
     at2=at2+iat2;  //arrival event at at2
  //remove While loop to consider time as runtime for program. 
     //keep while loop if time is considered as clock time for system.  
    
      //System.out.print("\nstbg="+stbg+"st="+st+"steg="+ste2);
     
     
     if(ste2<at2){
     wt=0;
     stbg=at2;
     }
     else
     {
     wt=ste2-at2;

    stbg=ste2;   
   }
     
    
    //System.out.print(" at="+at2);
   //  System.out.print(" wt="+wt);
     
     currenttime=stbg;
     awt2=awt2+wt;
    
  runs++;
  } 
 //System.out.println("awt2="+awt2+"runs="+runs);
awt2=(awt2/runs);
   
  
   // System.out.println("returned"+awt2);
  return awt2;
  
  }
    
    
}
