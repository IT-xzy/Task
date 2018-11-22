package com.jnshu.myutils;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

public class ProtoStuffRedisSerializer implements RedisSerializer<String> {
    private final Charset charset;

    public ProtoStuffRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public ProtoStuffRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }
    @Override
    public  byte[] serialize(String s) throws SerializationException {
        return new byte[0];
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return null;
    }
}
