package models;

public class Review {
    private String id;
    private String user_id;
    private String comments;
    private String review;
    private int rating;
    private String store_id;

    public void setId(String id, String user_id, String comments, String review, int rating, String store_id) {
        this.id = id;
        this.user_id = user_id;
        this.comments = comments;
        this.review = review;
        this.rating = rating;
        this.store_id = store_id;
    }

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getComments() {
        return comments;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public String getStore_id() {
        return store_id;
    }
}