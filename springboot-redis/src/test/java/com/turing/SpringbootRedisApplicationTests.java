package com.turing;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRedisApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;  //操作k-v都是字符串的

    @Resource
    private StringRedisTemplate stringRedisTemplate;  //操作k-v都是对象的

    @Test
    public void redisCacheTest() {
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
//        User user = new User();
//        user.setName("秋一叶");
//        user.setAge(18);
//        redisTemplate.opsForValue().set("用户", user);
    }

    @Test
    public void testFaceRegister() throws IOException {
        //1. 创建Java代码和百度云交互的Client对象
//        AipFace client = new AipFace("AppId","Api_key","Api_secret");
        AipFace client = new AipFace("26365874","LbK7GBm6WhgcoipXshTftXbV","bQ619qFvDGA4eUp6gsGODuFBQ9rHElNe");
        //2. 参数设置（示例下表格对参数进行介绍）
        HashMap<String,String> map = new HashMap<>();
        map.put("quality_control","NORMAL");//图片质量
        map.put("liveness_control","LOW");//活体检测

        //3. 构造图片
        String path = "E:\\OpenSource\\SourceCode\\spring\\springboot-learning\\springboot-redis\\docs\\罗杰_1907.jpg";
        //上传的图片  两种格式：url地址 Base64字符串形式
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String encode = Base64Util.encode(bytes);

        //4.调用api方法完成人脸注册
        /**
         * 参数1：图片的url或者base64字符串
         * 参数2：图片形式（URL，BASE64）
         * 参数3：组Id（固定一个字符串）
         * 参数4：用户Id
         * 参数5：hashMap基本参数配置
         */
        JSONObject res = client.addUser(encode, "BASE64", "pdx", "1000", map);
        System.out.println(res.toString());
    }

    // 判断图片是否具有面部信息
    @Test
    public void testFaceCheck() throws IOException {
        //1. 创建Java代码和百度云交互的Client对象
        AipFace client = new AipFace("26365874","LbK7GBm6WhgcoipXshTftXbV","bQ619qFvDGA4eUp6gsGODuFBQ9rHElNe");
        //2. 构造图片
        String path = "E:\\OpenSource\\SourceCode\\spring\\springboot-learning\\springboot-redis\\docs\\罗杰_1907.jpg";
        //上传的图片  两种格式：url地址 Base64字符串形式
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String encode = Base64Util.encode(bytes);

        //调用Api方法进行人脸检测
        /**
         * 参数1：图片的url或者base64字符串
         * 参数2：图片形式（URL，BASE64）
         * 参数3：hashMap中的基本参数配置（null:使用默认配置）
         */
        JSONObject res = client.detect(encode, "BASE64", null);
        System.out.println(res.toString(2));
    }

    @Test
    public void testFaceSearch() throws IOException {
        //1. 创建Java代码和百度云交互的Client对象
        AipFace client = new AipFace("26365874","LbK7GBm6WhgcoipXshTftXbV","bQ619qFvDGA4eUp6gsGODuFBQ9rHElNe");

        //2. 构造图片
        String path = "E:\\OpenSource\\SourceCode\\spring\\springboot-learning\\springboot-redis\\docs\\罗杰_1907.jpg";

        //上传的图片  两种格式：url地址 Base64字符串形式
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String encode = Base64Util.encode(bytes);

        //人脸搜索
        JSONObject res = client.search(encode, "BASE64", "pdx", null);
        System.out.println(res.toString(2));
    }

}
