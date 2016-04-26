package myrovh.onlinenewsreader;

/* Article Class
 * Data container for articles designed to be populated via JSON

 */
public class Article {
    private String title;
    private String description;
    private String articleUrl;
    private String thumbnailUrl;

    public Article(String title, String description, String articleUrl, String thumbnailUrl) {
        this.title = title;
        this.description = description;
        this.articleUrl = articleUrl;
        this.thumbnailUrl = thumbnailUrl;
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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
