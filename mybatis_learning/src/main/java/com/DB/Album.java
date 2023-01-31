package com.DB;

import java.util.Date;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Album {
    private Integer id;
    private String name;
    private String singer;
    private String genre;
    private String album_type;
    private String medium;
    private Date publish_time;
    private String publisher;
    private Integer records_num;
    private String bar_code;

    public Album( String name, String singer, String genre, String album_type, String medium, Date publish_time, String publisher, Integer records_num, String bar_code) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.album_type = album_type;
        this.medium = medium;
        this.publish_time = publish_time;
        this.publisher = publisher;
        this.records_num = records_num;
        this.bar_code = bar_code;
    }

    public Album(){}

    public Integer getId() {
        return id;
    }

    public Album setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    public String getSinger() {
        return singer;
    }

    public Album setSinger(String singer) {
        this.singer = singer;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Album setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public Album setAlbum_type(String album_type) {
        this.album_type = album_type;
        return this;
    }

    public String getMedium() {
        return medium;
    }

    public Album setMedium(String medium) {
        this.medium = medium;
        return this;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public Album setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Album setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Integer getRecords_num() {
        return records_num;
    }

    public Album setRecords_num(Integer records_num) {
        this.records_num = records_num;
        return this;
    }

    public String getBar_code() {
        return bar_code;
    }

    public Album setBar_code(String bar_code) {
        this.bar_code = bar_code;
        return this;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", genre='" + genre + '\'' +
                ", album_type='" + album_type + '\'' +
                ", medium='" + medium + '\'' +
                ", publish_time=" + publish_time +
                ", publisher='" + publisher + '\'' +
                ", records_num=" + records_num +
                ", bar_code='" + bar_code + '\'' +
                '}';
    }

   }
