package myrovh.onlinenewsreader;

/* Article Class
 * Data container for articles designed to be populated via JSON

 */
public class Article {
    private String title;
    private String description;
    private String thumbnailUri;

    public Article(String title, String description, String thumbnailUri) {
        this.title = title;
        this.description = description;
        this.thumbnailUri = thumbnailUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUri() {
        return thumbnailUri;
    }

    public void setThumbnailUri(String thumbnailUri) {
        this.thumbnailUri = thumbnailUri;
    }
}
