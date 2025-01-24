import java.util.*;
class SpiralMatrix {
    public static void main(String[] args) {
        int n=5;
        int m=5;
        int[][] spiral = new int[n][m];
        ArrayList<Integer> fiboValue = calFibo(n*m-1);
        
        System.out.println(fiboValue);

        int rowBegin=0,rowEnd=n-1;
        int colBegin=0,colEnd=m-1;
        int index=0;
        int count=1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            // System.out.println("1");
           
            for(int i=colBegin;i<=colEnd;i++){
                spiral[rowBegin][i]=fiboValue.get(index++);
            }
            rowBegin++;
            //  System.out.println("2");
            for(int i=rowBegin;i<=rowEnd;i++){
                spiral[i][colEnd]=fiboValue.get(index++);
            }
            colEnd--;
            //  System.out.println("3");
            if(rowBegin<rowEnd){
                for(int i=colEnd;i>=colBegin;i--){
                    spiral[rowEnd][i]=fiboValue.get(index++);
                }
            }
            rowEnd--;
            //  System.out.println("4");
            if(colBegin<colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    spiral[i][colBegin]=fiboValue.get(index++);
                }
            }
            colBegin++;

        }
        System.out.println("row begin : "+rowBegin +" row end : "+rowEnd);
        System.out.println("col begin : "+colBegin +" col end : "+colEnd);
        System.out.println("Print Array");
        for(int[] temp : spiral){
            for(int l : temp){
                System.out.print(l+"            ");
            }
            System.out.println();
        }

    }
    public static ArrayList<Integer> calFibo(int times){
        int prev=0;
        int cur=1;
        ArrayList<Integer> arr = new ArrayList<>(List.of(0,1));
        if(times==1){
            arr.add(0);
            return arr;
        }
        else if( times==2){
            return new ArrayList<>(List.of(0,1));
        }
        for(int i=times;i>1;i--){
            int temp = prev+cur;
            prev=cur;
            cur=temp;
            arr.add(temp);
        }
        return arr;
    }
}