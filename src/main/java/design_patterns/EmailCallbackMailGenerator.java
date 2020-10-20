package design_patterns;

@TemplateCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
        return "<HTML> don't call us</HTML>";
    }
}
