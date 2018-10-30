package com.wyz.task5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfiguration {

    /**
     * Initialise Tiles on application startup and identify the location of the tiles configuration file, tiles.xml.
     *
     * @return tiles configurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {"WEB-INF/tiles.xml"});
        configurer.setCheckRefresh(true);
        return configurer;
    }
    /**
     * Introduce a Tiles view resolver, this is a convenience implementation that extends URLBasedViewResolver.
     *
     * @return tiles view resolver
     */

    @Bean
    public TilesViewResolver tilesViewResolver(){
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
}
