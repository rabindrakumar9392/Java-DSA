class Solution {
    public int maxPower(String s) {
         if(s.length() == 0){
            return 0;
         }
        int n = s.length()-1;
        int count=1;
        int max=1;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)== s.charAt(i+1)){
                count++;
                max = Math.max(max, count);
               
            } else {
                count=1;
            }
           
        }
         return max;
        
    }
}