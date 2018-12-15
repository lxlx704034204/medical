/*
import com.bben.infusion.InfusionMainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfusionMainApplication.class)
public class MailMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
//    private AmqpTemplate rabbitTemplate;//此处报错但是不影响程序运行

    public static final String EXCHANGE_DIRECT_NOTICE_MAIL = "test.exchange.direct.notice.mail";
    public static final String QUEUE_NOTICE_MAIL_PLAIN = "test.notice.mail.plain";
    public static final String QUEUE_NOTICE_MAIL_HTML = "test.notice.mail.html";

    @Test
    public void send() {
        MailMessage m = new MailMessage();
        m.setTo("testDaisy@bben.top");
        m.setSubject("test test mq subject");
        m.setText("test test mq text");
        rabbitTemplate.convertAndSend(EXCHANGE_DIRECT_NOTICE_MAIL, QUEUE_NOTICE_MAIL_PLAIN, m);
    }

    @Test
    public void sendHtml() {
        SpecialMailMessage m = new SpecialMailMessage();
        m.setTo("Daisy@bben.top");
        m.setSubject("test mq");
        m.setMould("<h1 style=\"color: red\">{1}</h1>");
        m.setReplaces(Arrays.asList("Test MQ"));
        rabbitTemplate.convertAndSend(EXCHANGE_DIRECT_NOTICE_MAIL, QUEUE_NOTICE_MAIL_HTML, m);
    }

    @Test
    public void sendHtml2() {
        SpecialMailMessage m = new SpecialMailMessage();
        m.setTo("Daisy@bben.top");
        m.setSubject("test mq");
        m.setMould("<h1 style=\"color: red\">{1}</h1>");
        m.setReplaces(Arrays.asList("Test MQ"));
//        mailService.receive(m);
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert(QUEUE_NOTICE_MAIL_PLAIN);
        System.out.println(o);
    }
}
*/
