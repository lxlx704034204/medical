import lombok.*;

import java.util.List;

@Data
public class SpecialMailMessage extends MailMessage {
    private String mould;
    private List<String> replaces;

    @Override
    public boolean check() {
        text = "";
        if (!super.check()) return false;
        if (null == mould) return false;
        if (null == replaces) return false;
        for (int i = 1; i <= replaces.size(); i++)
            mould = mould.replace("{" + i + "}", replaces.get(i - 1));
        return true;
    }
}
