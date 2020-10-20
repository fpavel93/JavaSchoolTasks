package design_patterns;

@TemplateCode(1)
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
        return "<HTML> Welcome new client</HTML>";
    }
}
