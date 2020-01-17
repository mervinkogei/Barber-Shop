
package com.example.barbershop.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Hit {

    @SerializedName("largeImageURL")
    @Expose
    public String largeImageURL;
    @SerializedName("webformatHeight")
    @Expose
    public Integer webformatHeight;
    @SerializedName("webformatWidth")
    @Expose
    public Integer webformatWidth;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("imageWidth")
    @Expose
    public Integer imageWidth;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("views")
    @Expose
    public Integer views;
    @SerializedName("comments")
    @Expose
    public Integer comments;
    @SerializedName("pageURL")
    @Expose
    public String pageURL;
    @SerializedName("imageHeight")
    @Expose
    public Integer imageHeight;
    @SerializedName("webformatURL")
    @Expose
    public String webformatURL;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("previewHeight")
    @Expose
    public Integer previewHeight;
    @SerializedName("tags")
    @Expose
    public String tags;
    @SerializedName("downloads")
    @Expose
    public Integer downloads;
    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("favorites")
    @Expose
    public Integer favorites;
    @SerializedName("imageSize")
    @Expose
    public Integer imageSize;
    @SerializedName("previewWidth")
    @Expose
    public Integer previewWidth;
    @SerializedName("userImageURL")
    @Expose
    public String userImageURL;
    @SerializedName("previewURL")
    @Expose
    public String previewURL;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hit() {
    }

    /**
     * 
     * @param webformatHeight
     * @param imageWidth
     * @param favorites
     * @param webformatURL
     * @param previewHeight
     * @param userImageURL
     * @param comments
     * @param previewURL
     * @param type
     * @param userId
     * @param imageHeight
     * @param tags
     * @param previewWidth
     * @param downloads
     * @param largeImageURL
     * @param pageURL
     * @param id
     * @param imageSize
     * @param webformatWidth
     * @param user
     * @param views
     * @param likes
     */
    public Hit(String largeImageURL, Integer webformatHeight, Integer webformatWidth, Integer likes, Integer imageWidth, Integer id, Integer userId, Integer views, Integer comments, String pageURL, Integer imageHeight, String webformatURL, String type, Integer previewHeight, String tags, Integer downloads, String user, Integer favorites, Integer imageSize, Integer previewWidth, String userImageURL, String previewURL) {
        super();
        this.largeImageURL = largeImageURL;
        this.webformatHeight = webformatHeight;
        this.webformatWidth = webformatWidth;
        this.likes = likes;
        this.imageWidth = imageWidth;
        this.id = id;
        this.userId = userId;
        this.views = views;
        this.comments = comments;
        this.pageURL = pageURL;
        this.imageHeight = imageHeight;
        this.webformatURL = webformatURL;
        this.type = type;
        this.previewHeight = previewHeight;
        this.tags = tags;
        this.downloads = downloads;
        this.user = user;
        this.favorites = favorites;
        this.imageSize = imageSize;
        this.previewWidth = previewWidth;
        this.userImageURL = userImageURL;
        this.previewURL = previewURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public Integer getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(Integer webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public Integer getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(Integer webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(Integer previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public Integer getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(Integer previewWidth) {
        this.previewWidth = previewWidth;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

}
