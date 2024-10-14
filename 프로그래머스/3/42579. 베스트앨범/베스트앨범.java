import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genreCountPlay = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int idx = i;

            genreCountPlay.put(genre, genreCountPlay.getOrDefault(genre, 0) + play);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{idx, play});
        }

        List<String> sortedGenres = new ArrayList<>(genreCountPlay.keySet());
        sortedGenres.sort((a, b) -> genreCountPlay.get(b) - genreCountPlay.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres){
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            
            for (int i = 0; i < Math.min(songs.size(), 2); i++) result.add(songs.get(i)[0]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}