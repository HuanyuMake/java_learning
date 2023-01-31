package com.Mapper;

import com.DB.Song;

import java.util.List;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface SongsMapper {
    List<Song> selectAll();
}
