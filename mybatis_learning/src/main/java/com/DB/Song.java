package com.DB;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Song {
    private Integer id;
    private Integer album_id;
    private String index;
    private String name;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", album_id=" + album_id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Song(Integer id, Integer album_id, String index, String name) {
        this.id = id;
        this.album_id = album_id;
        this.index = index;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Song setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public Song setAlbum_id(Integer album_id) {
        this.album_id = album_id;
        return this;
    }

    public String getIndex() {
        return index;
    }

    public Song setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getName() {
        return name;
    }

    public Song setName(String name) {
        this.name = name;
        return this;
    }
}
