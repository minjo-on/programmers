class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();                          
        answer = answer.replaceAll("[^a-z0-9-_.]", "");          
        answer = answer.replaceAll("\\.{2,}", ".");               
        answer = step4(answer);                            
        if (answer.isEmpty()) answer = "a";                    
        answer = answer.length() > 15 ? answer.substring(0, 15) : answer; 
        answer = step4(answer);                   
        answer = step7(answer);
        return answer;
    }

    private String step4(String s) {
        if (s.startsWith(".")) s = s.substring(1);
        if (s.endsWith(".")) s = s.substring(0, s.length() - 1);
        return s;
    }

    private String step7(String s) {
        while (s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }
        return s;
    }
}
