import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailMessage {
    public static final String MAIL_REGEX = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    protected String to;
    protected String subject;
    protected String text;


    protected String[] receives;

    public boolean check() {
        if (null == to) return false;
        receives = to.split(",");
        for (String s : receives) if (!s.matches(MAIL_REGEX)) return false;
        if (null == subject) return false;
        if (null == text) return false;
        return true;
    }



}
