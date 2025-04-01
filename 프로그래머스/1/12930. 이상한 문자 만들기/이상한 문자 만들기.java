class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                toUpper = true;
            } else {
                builder.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));       
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }
}