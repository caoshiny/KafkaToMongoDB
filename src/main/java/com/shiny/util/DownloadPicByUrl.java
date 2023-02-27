package com.shiny.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

@Slf4j
@Component
public class DownloadPicByUrl {
    @Autowired
    private GetInfoFromYml getInfoFromYml;

    public void downloadPic(String fileUrl, String HitTime) throws IOException {
        // 判断保存文件的根目录否存在，不存在就创建根目录文件夹
        File isExistSaveRootDir  = new File(getInfoFromYml.getCopyPath());
        if(!isExistSaveRootDir.exists()){
            try {
                Boolean s = isExistSaveRootDir.mkdir();
                log.info("由于配置文件中的根目录不存在，程序已经自动创建了"+ getInfoFromYml.getCopyPath() +"根目录文件夹！");
            } catch (Exception e){
                log.error(String.valueOf(e));
            }
        }else{
            log.info("保存图片文件的根目录"+ getInfoFromYml.getCopyPath() +"已经存在！");
        }

        // 根据根目录创建保存文件的目录结构
        String savePicPath = getInfoFromYml.getCopyPath() + "\\business\\hit\\" + HitTime;
        File savePicDir = new File(getInfoFromYml.getCopyPath() + "\\business\\hit\\" + HitTime);
        if (!savePicDir.exists()) {
            try{
                Boolean s = savePicDir.mkdirs();
                log.info("由于保存图片文件的路径不存在，程序已经自动创建了"+ savePicPath +"目录结构！");
            }catch (Exception e){
                log.error(String.valueOf(e));
            }
        } else {
            log.info("保存图片文件的目录结构" + savePicPath + "已经存在！");
        }

        // 根据fileUrl获取文件名全名 fileAllName
        String [] strArray = fileUrl.split("/");
        String fileAllName = strArray[strArray.length - 1];
        // 根据需要保存文件目录创建文件
        String picPath = savePicPath + "\\" + fileAllName;
        File file = new File(picPath);
        if(!file.exists()) {
            try {
                boolean s = file.createNewFile();
                log.info("创建保存图片信息的空文件成功，文件的绝对路径为: " + picPath);
            }catch (Exception e){
                log.error("创建保存图片信息的空文件失败: " + e);
            }

        }else {
            log.info("保存图片信息的空文件已经存在！");
            log.info("保存文件的绝对路径为: " + picPath);
        }

        URL url = null;
        try {
            url = new URL(fileUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(picPath);
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
            log.info("|____________________保存图片到本地完成____________________|");
        } catch (IOException e) {
            log.error("---保存图片本地失败---: " + e);
        }
    }
}
