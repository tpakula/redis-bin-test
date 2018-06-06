import redis.embedded.RedisExecProvider;
import redis.embedded.RedisServer;
import redis.embedded.util.JarUtil;
import redis.embedded.util.OS;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class RedisTest {

    @Test
    public void test() throws IOException {
//        File jar = JarUtil.extractExecutableFromJar("redis-server-3.2.11");
        File jar = JarUtil.extractExecutableFromJar("com/github/tpakula/redis-bin/redis-server-3.2.11");

        RedisExecProvider execProvider = RedisExecProvider.defaultProvider()
                .override(OS.UNIX, jar.getAbsolutePath());

        RedisServer redisServer = RedisServer.builder().port(6333)
                .redisExecProvider(execProvider)
                .build();

        redisServer.start();

        System.out.println("test");


        redisServer.stop();
    }
}
