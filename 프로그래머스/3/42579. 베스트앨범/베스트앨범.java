import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int index = i;

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{index, play});
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);

            songs.sort((a, b) -> b[1] - a[1] == 0 ? a[0] - b[0] : b[1] - a[1]);

            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                bestAlbum.add(songs.get(i)[0]);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}
