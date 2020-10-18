package Enums.com.pavel;

import Enums.enums.MailHttpCodes;

public class HttpMailHandler {

    public void handleHttpCode(int code){

        MailHttpCodes httpCode = MailHttpCodes.findByCode(code);
        httpCode.getHandler().handle();
    }
}
