package csust.txr.film;

import java.util.Comparator;

public class Film implements Comparable<Film>{
	private String title;
	private int year;
	private double rating;
	
	/**
	 * @param title
	 * @param year
	 * @param rating
	 */
	public Film(String title, int year, double rating) {
		this.title = title;
		this.year = year;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", year=" + year + ", rating=" + rating + "]";
	}

	@Override
	public int compareTo(Film o) {
		return this.getYear()-o.getYear();
	}
	
	public double compareToByRating(Film o) {
		return this.getRating()-o.getRating();
	}
}
