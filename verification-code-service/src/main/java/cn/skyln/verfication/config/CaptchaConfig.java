package cn.skyln.verfication.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: lamella
 * @Date: 2022/08/28/18:07
 * @Description:
 */
@Configuration
@RefreshScope
public class CaptchaConfig {

    @Value("${skyln.verification.text.char_length}")
    private String charLength;
    @Value("${skyln.verification.text.char_space}")
    private String charSpace;
    @Value("${skyln.verification.text.noise_impl}")
    private String noiseImpl;
    @Value("${skyln.verification.text.obscurificator_impl}")
    private String obscurificatorImpl;
    @Value("${skyln.verification.text.char_string}")
    private String charString;
    @Value("${skyln.verification.text.noise_color}")
    private String noiseColor;

    /**
     * 验证码配置
     * Kaptcha配置类名
     *
     * @return
     */
    @Bean
    @Qualifier("captchaProducer")
    public DefaultKaptcha kaptcha() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //验证码个数
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, charLength);
        //字体间隔
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, charSpace);
        //干扰线颜色
//        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, noiseColor);
        //干扰实现类
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, noiseImpl);
        //图片样式
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, obscurificatorImpl);
        //文字来源
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, charString);
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
