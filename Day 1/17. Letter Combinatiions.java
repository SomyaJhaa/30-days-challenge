class Solution {
    public List<String> letterCombinations(String digits) {
         if (digits.isEmpty()){
            return new ArrayList<>();
        }
      
        List<String> ans = new ArrayList<>();
        ans.add( "");

        String[] numTochar = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for( char s : digits.toCharArray() ){
            List<String> a = new ArrayList<>();
            for( String p : ans){
                for( char n : numTochar[ s - '0'].toCharArray() ){
                    a.add( p + n);
                }
            }
            ans = a;
        }
        return ans;
    }
}