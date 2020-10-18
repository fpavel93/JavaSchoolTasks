package Enums.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MailHttpCodes {

    INFORMATIONAL(100,199,new InformationalHandler()),
    SUCCESS(200,299,new SuccessHandler()),
    REDIRECTION(300,399,new RedirectionHandler()),
    CLIENT_ERROR(400,499,new ClientErrorHandler()),
    SERVER_ERROR(500,599,new ServerErrorHandler());

    private final int min;
    private final int max;
    private final EnumHandler handler;

    public static MailHttpCodes findByCode(int code){
        MailHttpCodes[] mailHttpCodes = values();
        for (MailHttpCodes mailHttpCode : mailHttpCodes)
        {
            if(code >= mailHttpCode.min && code <= mailHttpCode.max){
                return mailHttpCode;
            }
        }

        throw new IllegalStateException(code + " not supported");
    }
}
