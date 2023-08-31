package com.fitexercises.api.fitexercisesapi.Config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    // Configuration class to enable caching.
    //Configure a cache manager to specify the caching behavior.
    // You can use the default cache manager provided by Spring Boot, or you can configure your own cache manager.

    /*
    The ConcurrentMapCacheManager is one of the cache manager implementations provided by Spring.
    It uses a concurrent hash map to store cached data in memory.
     Each cache is represented as an entry in this map. This means that each cache is essentially a key-value store.
     */

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("exercisesCache"); // Cache Name.
    }

}
