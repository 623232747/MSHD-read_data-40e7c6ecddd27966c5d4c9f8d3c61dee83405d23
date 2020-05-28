package yxx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import yxx.hellospring.JsonParser.JsonToEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
public class Upload_Controller {
    public static String dataResourceFile = "src/main/resources/dataResource.txt";
    //处理Post请求
    @PostMapping("/UploadPage.html")
    public void uploadOK(Model model, HttpServletRequest request) throws IOException {
        int sourceCode = Integer.parseInt(request.getParameter("source"));

        List<MultipartFile> list_files = ((MultipartHttpServletRequest) request).getFiles("jsonFile");

        if (list_files.isEmpty()) {
            model.addAttribute("file_result", "文件为空");
            return ;
        }
        InputStream inputStream = null;
        boolean isJson = true; //用以检验是否为json文件

        for (MultipartFile file : list_files) {
            inputStream = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String jsonStr;
            try {
                FileWriter fileWriter = new FileWriter(dataResourceFile);
                while ((jsonStr = br.readLine()) != null) {
//                    new JsonToEntity(sourceCode).insert(jsonStr);
//                    新迭代需要将用户操作和系统分离开来，所以这里需要将json传至“数据源”，实际上就是一个普通的文本文件
                    fileWriter.append(sourceCode+"§");
//                    json中不可包含“§”
                    fileWriter.append(jsonStr+"\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
            //读取出错，则提示非json文件或者重复上传
            catch (Exception e){
                isJson = false;
                break;
            }
//            修改已经过测试，测试人：wzy
        }
        if(isJson)
            model.addAttribute("file_result", "上传成功");
        else
            model.addAttribute("file_result", "请勿重复上传");
        return ;
    }
}
