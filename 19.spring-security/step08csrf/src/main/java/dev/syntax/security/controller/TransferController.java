package dev.syntax.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    private final Logger logger = Logger.getLogger(TransferController.class.getName());

    @GetMapping
    public String showTransferForm() {
        return "transfer";
    }

    @PostMapping
    public String transfer(HttpServletRequest request) {
        String allowedReferer = "http://localhost:8080/transfer";
        String amount = request.getParameter("amount");
        String account = request.getParameter("account");

        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);
        String host = request.getHeader("host");
        System.out.println("host = " + host);

        if (!request.getHeader("Referer").equals(allowedReferer)) {
            return "error";
        }

        logger.info(account + "계좌로" + amount + "원이 입금되었습니다.");

        return "home";
    }
}
