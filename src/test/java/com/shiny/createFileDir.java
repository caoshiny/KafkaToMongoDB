package com.shiny;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class createFileDir {
    @Test
    public void Test() {
        File file = new File("D:/a/b");
        file.mkdirs();
    }
}
