package Exercises_For_Second_PartialExam.NajdobriFilmovi;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Movie {

    private String title;
    private List<Integer> ratings;
    private Double ratingCoef;

    public static Comparator<Movie> comparatorByRating
            = Comparator.comparing(Movie::getAverageRating).reversed().thenComparing(Movie::getTitle);
    public static Comparator<Movie> comparatorByRatingCoef
            = Comparator.comparing(Movie::getRatingCoef).reversed().thenComparing(Movie::getTitle);

    public Movie(String title, List<Integer> ratings) {
        this.title = title;
        this.ratings = ratings;
        this.ratingCoef = 0.0;
    }

    public Double getAverageRating() {
        return ratings.stream().mapToDouble(r -> r.doubleValue()).average().orElse(0.0);
    }

    public String getTitle() {
        return title;
    }

    public Double getRatingCoefForMovie() {
        return getAverageRating() * ratings.size();
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public Double getRatingCoef() {
        return ratingCoef;
    }

    public void setRatingCoef(Double ratingCoef) {
        this.ratingCoef = ratingCoef;
    }

    @Override
    public String toString() {

        return String.format("%s (%.2f) of %d ratings", title, getAverageRating(), ratings.size());
    }
}
