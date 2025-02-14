class Solution {
    public static boolean isValid(List<String>str,int row,int col,char[] d1,char[] d2,int n){
       for(int i=0;i<n;i++){
           if(str.get(row).charAt(i)=='Q')return false;
           if(str.get(i).charAt(col)=='Q')return false;
       }
       return !(d1[row+col]=='Q'||d2[n-1+col-row]=='Q');
    }


   public static void solve(List<String>str,int row,List<List<String>>ans,char d1[],char d2[],int n){
       if(row==n){
           ans.add(new ArrayList<>(str));
           return;
       }
       else{
           for(int i=0;i<n;i++){
           if(isValid(str,row,i,d1,d2,n)){
             char []rowArr=str.get(row).toCharArray();
             rowArr[i]='Q';
             d1[row+i]='Q';
             d2[n-1+i-row]='Q';
             str.set(row, new String(rowArr));
             solve(str,row+1,ans,d1,d2,n);
             rowArr[i]='.';
             d1[row+i]='.';
             d2[n-1+i-row]='.';
             str.set(row, new String(rowArr));
           }
           }
       }
   }
   public List<List<String>> solveNQueens(int n) {
       List<List<String>>ans=new ArrayList<>();
       List<String>str=new ArrayList<>();
       String Str="";
       for (int i = 0; i < n; i++) {
           str.add(".".repeat(n));
       }
       char d1[]=new char[2*n-1];
       char d2[]=new char[2*n-1];
       Arrays.fill(d1,'.');
       Arrays.fill(d2,'.');
       solve(str,0,ans,d1,d2,n);
       return ans;
   }
}