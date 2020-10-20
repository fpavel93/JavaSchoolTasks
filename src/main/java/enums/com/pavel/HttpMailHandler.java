package enums.com.pavel;

import enums.enums.MailHttpCodes;

public class HttpMailHandler {

    public void handleHttpCode(int code){

        MailHttpCodes httpCode = MailHttpCodes.findByCode(code);
        httpCode.getHandler().handle();
    }
}
