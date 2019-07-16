package project.app.modelRD;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    private List<Directors> directors;
    @OneToOne
    private Languages language;
    @ManyToMany
    private List<Reviews> reviews;
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany
    private List<Tags> tags;
    @ManyToMany
    private List<Actors> actors;
    @ManyToMany
    private List<Awards> awards;
    private String country;
    private String releaseDate;
    private int movieLength;

    public Movie() {
    }

    public Movie(String title, List<Directors> directors, Languages language, List<Reviews> reviews, List<Genre> genres, List<Tags> tags, List<Actors> actors, List<Awards> awards, String country, String releaseDate, int movieLength) {
        this.title = title;
        this.directors = directors;
        this.language = language;
        this.reviews = reviews;
        this.genres = genres;
        this.tags = tags;
        this.actors = actors;
        this.awards = awards;
        this.country = country;
        this.releaseDate = releaseDate;
        this.movieLength = movieLength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }
}
