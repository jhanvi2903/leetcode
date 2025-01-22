class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        int count = 0;

        for(char cc: c){
            if(cc == '(' || cc == '[' || cc == '{'){
                 st.push(cc);
            }else {
                if(st.isEmpty()){
                   count ++;
                }else if(!st.isEmpty() && st.pop() == '(' && cc != ')'){
                    count++;
                }
            }
        }

        if(!st.isEmpty()){
            count = count + st.size();
        }

     return count;
    }
}