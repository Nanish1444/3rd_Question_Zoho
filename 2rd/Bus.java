import java.util.*;

class Bus {
    public static void main(String[] args) {
        int n=8;
        int[] stop={2};
        boolean[] stops=new boolean[n];
        for(int i=0;i<stop.length;i++){
            stops[stop[i]-1]=true;
        }
        int max=0;
        for(int i=0;i<stops.length;i++){
            int left=leftSum(i,stops);
            int right=rightSum(i,stops);
            max=Math.max(max,Math.min(left,right));
        }
        System.out.println("MAX : "+max);
        
    }
    public static int leftSum(int person,boolean[] stops){
        int steps=0;
        for(int i=person;i>=0;i--){
            if(stops[i]==true){
                return steps;
            }
            else{
                steps++;
            }
        }
        return Integer.MAX_VALUE;
    }
    public static int rightSum(int person,boolean[] stops){
        int steps=0;
        for(int i=person;i<stops.length;i++){
            if(stops[i]==true){
                return steps;
            }
            else{
                steps++;
            }
        }
        return Integer.MAX_VALUE;
    }
}