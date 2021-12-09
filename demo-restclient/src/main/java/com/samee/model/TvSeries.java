package com.samee.model;

import java.net.URL;
import java.util.Set;

public class TvSeries {
    
    private long id;
    private URL url;
    private String name;
    private String type;
   
    private String language;

    private Set<String> genres;
    private URL officialSite;

   

   
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public URL getUrl() {
        return url;
    }
    public void setUrl(URL url) {
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Set<String> getGenres() {
        return genres;
    }
    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }
    public URL getOfficialSite() {
        return officialSite;
    }
    public void setOfficialSite(URL officialSite) {
        this.officialSite = officialSite;
    }
  

}
