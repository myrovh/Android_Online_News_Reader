package myrovh.onlinenewsreader.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("height")
    private String height;
    @SerializedName("medium")
    private String medium;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    private String width;
    @SerializedName("isDefault")
    private String isDefault;

    /**
     * @return The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return The isDefault
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault The isDefault
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

}
