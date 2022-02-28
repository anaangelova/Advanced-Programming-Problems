package Exercises_For_Second_PartialExam.NajdobriFilmovi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesList {

    List<Movie> movies;

    public MoviesList() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings) {
        Movie movie = new Movie(title, Arrays.stream(ratings).boxed().collect(Collectors.toList()));
        movies.add(movie);
    }

    public List<Movie> top10ByAvgRating() {
        return movies.stream().sorted(Movie.comparatorByRating).limit(10).collect(Collectors.toList());
    }

    public List<Movie> top10ByRatingCoef() {
        return movies.stream().peek(m -> m.setRatingCoef(m.getRatingCoefForMovie() / getMaxCountRatings())).sorted(Movie.comparatorByRatingCoef).limit(10).collect(Collectors.toList());
    }

    public int getMaxCountRatings() {
        return movies.stream().mapToInt(m -> m.getRatings().size()).max().orElse(0);
    }
}
