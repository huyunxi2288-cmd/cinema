package com.cinema.dto;

public class Movie {
    private String movieId;
    private String movieName;
    private int duration;
    private String type;
    private String releaseDate;
    private String director;
    private String description;

    // Constructor, getters, and setters
    public Movie(String movieId, String movieName, int duration, String type, String releaseDate, String director, String description) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.type = type;
        this.releaseDate = releaseDate;
        this.director = director;
        this.description = description;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
