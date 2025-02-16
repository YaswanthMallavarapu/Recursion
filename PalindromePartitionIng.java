class Solution {
    public static boolean isPalindrome(String str,int st,int end){
        while(st<end){
            if(str.charAt(st)!=str.charAt(end))return false;
            st++;
            end--;
        }
        return true;
    }
    public static void solve(String str,int idx,List<List<String>>res,List<String>parts){
        if(idx==str.length()){
            res.add(new ArrayList<>(parts));
            return;
        }
        else{
            for(int i=idx;i<str.length();i++){
                if(isPalindrome(str,idx,i)){
                    parts.add(str.substring(idx,i+1));
                    solve(str,i+1,res,parts);
                    parts.remove(parts.size()-1);
                }
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>parts=new ArrayList<>();
        solve(s,0,res,parts);
        return res;
    }
}