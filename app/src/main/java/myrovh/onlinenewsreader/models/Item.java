package myrovh.onlinenewsreader.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pubDate")
    @Expose
    private String pubDate;
    @SerializedName("guid")
    @Expose
    private Guid guid;
    @SerializedName("category")
    @Expose
    private List<String> category = new ArrayList<String>();
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("creator")
    @Expose
    private String creator;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * @param pubDate The pubDate
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * @return The guid
     */
    public Guid getGuid() {
        return guid;
    }

    /**
     * @param guid The guid
     */
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    /**
     * @return The category
     */
    public List<String> getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(List<String> category) {
        this.category = category;
    }

    /**
     * @return The group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * @return The creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator The creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

}
