package com.shiny;

import com.shiny.util.DownloadPicByUrl;
import com.shiny.util.GetInfoFromYml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class downloadPicTest {
    @Autowired
    DownloadPicByUrl downloadPicByUrl;

    @Autowired
    GetInfoFromYml getInfoFromYml;

    @Test
    public void downloadTest() throws IOException {
        downloadPicByUrl.downloadPic("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "41894");
    }

    @Test
    public void getFileNameFromUrl(){
        String fileUrl = "https://img2.baidu.com/it/u=3355464299,584008140&fm=26&fmt=auto&gp=0.jpg";
        String [] strArray = fileUrl.split("/");
        for (String s : strArray) {
            System.out.println(s);
        }
        System.out.println(strArray[strArray.length-1]);
    }
}
