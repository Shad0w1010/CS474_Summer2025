package Exceptions;

public class rval {
       int x = 1;
       void rv(){
              try{
                     x=2;
              }
              catch(Exception e){
                     return;
              }
              finally {
                     x=3;
                     return;
              }
       }
       public static void main(String[] args) {
              rval r = new rval();
              r.rv();
              System.out.println(r.x);
       }
 
}
