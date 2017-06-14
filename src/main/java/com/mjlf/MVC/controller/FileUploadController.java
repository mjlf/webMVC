package com.mjlf.MVC.controller;

/**
 * Created by a123 on 17/6/14.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 处理文件上传类
 */
@Controller
@RequestMapping({"/", "/home"})
public class FileUploadController{

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void home(HttpServletRequest request, HttpServletResponse response, @RequestPart("profilePicture")MultipartFile profilePicture) throws IOException {
        File proFile = new File("/tmp/webMVC/"+profilePicture.getOriginalFilename());
        if(!proFile.exists()){
            proFile.getParentFile().mkdirs();
            proFile.createNewFile();
        }
        profilePicture.transferTo(proFile);
        System.out.println(request.getParameter("name"));
    }
}
