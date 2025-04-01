class Solution {
    private static int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    
    private boolean isInBounds(int y, int x) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    private boolean isDistanced(char[][] room){
        for(int y = 0; y < room.length; y++){
            for(int x = 0; x < room[y].length; x++){
                if(room[y][x] == 'P' && !isProperlyDistanced(y, x, room)) return false;
            }
        }
        return true;
    }
    
    private boolean isProperlyDistanced(int y, int x, char[][] room){
        for(int i = 0; i < 4; i++){
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if(!isInBounds(ny, nx)) continue;
            switch (room[ny][nx]) {
                case 'P' : return false;
                case 'O' : if(checkAroundP(ny, nx, room, i)) return false; break; 
            }
        }
        return true;
    }
    
    private boolean checkAroundP(int y, int x, char[][] room, int d){
        for(int i = 0; i < 4; i++){
            if(d + i == 3) continue;
            int ny = y + dirs[i][0];
            int nx = x + dirs[i][1];
            if(!isInBounds(ny, nx)) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++){
                room[j] = place[j].toCharArray();
            }
            
            if(isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}