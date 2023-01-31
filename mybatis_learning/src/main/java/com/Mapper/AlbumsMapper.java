package com.Mapper;

import com.DB.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface AlbumsMapper {
    List<Album> selectAll();

    Album selectById(Integer id);

    //    散装传参, 需要使用 ibatis 的注解 @Param("sql变量对应的变量名") 参数
    List<Album> selectByCondition(@Param("name")String name, @Param("singer")String singer);

    //    封装传参, 传一个对象,其属性名与sql中用到的变量名一一对应
    List<Album> selectByCondition(Album album);
    //    Map集合传参, 可以传其实现类 HashMap 其键名与sql变量名一一对应
    List<Album> selectByCondition(Map<String,String> album);

    List<Album> selectByOneCondition(Album album);

    void add(Album album);

    void addAndSetId(Album album);
}
