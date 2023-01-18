package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位文件地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //导演头像定位
        registry.addResourceHandler("/img/DirectorPic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"DirectorPic" +System.getProperty("file.separator")
        );
        //电影图片定位
        registry.addResourceHandler("/img/MovePic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                        +System.getProperty("file.separator")+"MovePic" +System.getProperty("file.separator")
        );
        //收藏夹图片定位
        registry.addResourceHandler("/img/MoveListPic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                        +System.getProperty("file.separator")+"MoveListPic" +System.getProperty("file.separator")
        );
        //电影地址
        registry.addResourceHandler("/Move/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+ "Move"
                        +System.getProperty("file.separator")
        );
        //用户头像地址定位
        registry.addResourceHandler("/avatarImages/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+ "avatarImages"
                        +System.getProperty("file.separator")
        );
        //用户头像默认地址定位定位
        registry.addResourceHandler("/img/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+ "img"
                        +System.getProperty("file.separator")
        );
    }
}
