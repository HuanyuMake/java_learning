package com.Notes.ProxyMapper;

import com.DB.Album;
import com.DB.Song;
import com.Mapper.AlbumsMapper;
import com.Mapper.SongsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 潘栋磊
 * @version 0.0.1
 * 要想使用代理接口 如 AlbumsMapper 通过调用方法来使用sql, 必须要让该接口对应的同名配置文件(以下称mapper.xml)与
 * 处于同一目录, 但是为了保证配置文件与源代码分离, 不能直接在开发时将配置文件
 * 至于该接口同一目录下. 解决办法就是在resources构建一个和对应AlbumsMapper接口相同的目录,
 * 你可以查看现在的项目目录,就可以明白我的意思. 这两个在 mvn compile 之后会放在target.classes下的同一目录下
 */
public class ProxyMapper {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        openSession() 是否开起自动事务提交? 是则多传一个 true
        SqlSession sqlSession = sqlSessionFactory.openSession();

        System.out.println("sql....");

        //        List<Album> Album = sqlSession.selectList("Albums.selectAll");

        //        获取 UserMapper 接口的代理对象
        AlbumsMapper albumsMapper = sqlSession.getMapper(AlbumsMapper.class);
        SongsMapper songsMapper = sqlSession.getMapper(SongsMapper.class);
        //        执行selectAll方法对应的sql
        /*List<Song> songs = songsMapper.selectAll();
        List<Album> albums = albumsMapper.selectAll();

        System.out.println(albums);
        System.out.println(songs);*/

        //        准备条件对象
        /*Album albumCondition = new Album();
        albumCondition.setName("%4%").setSinger("%4%");// 模糊查询
        List<Album> albums1 = albumsMapper.selectByCondition(albumCondition);

        HashMap<String, String> albumCondition = new HashMap<>();
        albumCondition.put("name","%4%");
        albumCondition.put("singer","%4%");
        List<Album> albums1 = albumsMapper.selectByCondition(albumCondition);
        System.out.println(albums1);*/

//        List<Album> albums = albumsMapper.selectByOneCondition(new Album().setName("%4%"));

        /*albumsMapper.add(new Album("myBatisAlbum","mybatis", null,"专辑","网络",new Date(),"个人",1,"1234567890245"));
        List<Album> albums = albumsMapper.selectAll();*/

        // 添加同时设置传入对象的id
        Album album = new Album("myBatisAlbum","mybatis", null,"专辑","网络",new Date(),"个人",1,"1234567890245");
        albumsMapper.addAndSetId(album);
        System.out.println(album.getId());
        List<Album> albums = albumsMapper.selectAll();

        System.out.println(albums);

        sqlSession.close();
    }
}
