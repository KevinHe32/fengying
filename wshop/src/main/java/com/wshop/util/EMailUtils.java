package com.wshop.util;

import org.apache.commons.mail.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * E-mail工具类
 */
public class EMailUtils {

    /**
     * 发件人的服务端口
     */
    private static final int POST = 587;

    /**
     * 发件人的服务地址
     */
    private static final String HOST = "smtp.qq.com";

    /**
     * 发件人用户名
     */
    private static final String USER_NAME = "1111@qq.com";

    /**
     * 发件人密码
     */
    private static final String PASS_WORD = "gltzspeszwbjbgid";

    /**
     * 发件人的邮箱地址
     */
    private static final String FORM_EMAIL_ADDRESS = "111@qq.com";

    /**
     * 发件人的邮箱名称
     */
    private static final String FORM_EMAIL_NIKE_NAME = "test";

    /**
     * 简单的发邮件方式    邮件内容只有标题和邮件内容  支持单个个用户发送
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址
     * @return 是否成功
     */
    public static boolean sendSimpleEmail(String subject, String contents, String toEmailAddress) {
        return sendSimpleEmail(subject, contents, new String[]{toEmailAddress});
    }

    /**
     * 简单的发邮件方式    邮件内容只有标题和邮件内容  支持多个用户批量发送
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址
     * @return 是否成功
     */
    public static boolean sendSimpleEmail(String subject, String contents, String[] toEmailAddress) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName(HOST);
            email.setSmtpPort(POST);
            email.setAuthentication(USER_NAME, PASS_WORD);
            for (String toEmailAddres : toEmailAddress) {
                email.addTo(toEmailAddres, toEmailAddres);
            }
            email.setFrom(FORM_EMAIL_ADDRESS, FORM_EMAIL_NIKE_NAME);
            email.setSubject(subject);
            email.setContent(contents, "text/plain;charset=UTF-8");
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送带附件的邮件方式  邮件内容有标题和邮件内容和附件，附件可以是本地机器上的文本，也可以是web上的一个URL 文件，
     * 当为web上的一个URL文件时，此方法可以将WEB中的URL文件先下载到本地，再发送给收入用户
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址
     * @param multiPaths     附件文件数组
     * @return 是否成功
     */

    public static boolean sendMultiPartEmail(String subject, String contents, String toEmailAddress, String[] multiPaths) {
        return sendMultiPartEmail(subject, contents, new String[]{toEmailAddress}, multiPaths);
    }

    /**
     * 发送带附件的邮件方式  邮件内容有标题和邮件内容和附件，附件可以是本地机器上的文本，也可以是web上的一个URL 文件，
     * 当为web上的一个URL文件时，此方法可以将WEB中的URL文件先下载到本地，再发送给收入用户
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址数组
     * @param multiPaths     附件文件数组
     * @return 是否成功
     */

    public static boolean sendMultiPartEmail(String subject, String contents, String[] toEmailAddress, String[] multiPaths) {
        try {
            List<EmailAttachment> attachmentList = new ArrayList<>();
            if (multiPaths != null) {
                for (String multiPath : multiPaths) {
                    EmailAttachment attachment = new EmailAttachment();
                    if (!multiPath.contains("http")) {
                        attachment.setPath(multiPath);
                    } else {
                        attachment.setURL(new URL(multiPath));
                    }
                    attachment.setDisposition(EmailAttachment.ATTACHMENT);
                    attachment.setDescription("");
                    attachmentList.add(attachment);
                }
            }

            //发送邮件信息
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(HOST);
            email.setSmtpPort(POST);
            email.setCharset("UTF-8");
            email.setAuthentication(USER_NAME, PASS_WORD);
            for (String toEmailAddres : toEmailAddress) {
                email.addTo(toEmailAddres, toEmailAddres);
            }
            email.setFrom(FORM_EMAIL_ADDRESS, FORM_EMAIL_NIKE_NAME);
            email.setSubject(subject);
            email.setMsg(contents);   //注意这个不要使用setContent这个方法  setMsg不会出现乱码
            for (Object anAttachmentList : attachmentList) {
                email.attach((EmailAttachment) anAttachmentList);
            }
            email.send();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 发送Html格式的邮件
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址
     * @return 是否成功
     */
    public static boolean sendHtmlEmail(String subject, String contents, String toEmailAddress) {
        return sendHtmlEmail(subject, contents, new String[]{toEmailAddress});
    }

    /**
     * 发送Html格式的邮件
     *
     * @param subject        邮件的主题
     * @param contents       邮件的内容
     * @param toEmailAddress 收件人的邮件地址数组
     * @return 是否成功
     */
    public static boolean sendHtmlEmail(String subject, String contents, String[] toEmailAddress) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(HOST);
            email.setSmtpPort(POST);
            email.setCharset("UTF-8");
            email.setAuthentication(USER_NAME, PASS_WORD);
            for (String toEmailAddres : toEmailAddress) {
                email.addTo(toEmailAddres, toEmailAddres);
            }
            email.setFrom(FORM_EMAIL_ADDRESS, FORM_EMAIL_NIKE_NAME);
            email.setSubject(subject);
            email.setHtmlMsg(contents);
            email.send();
            return true;
        } catch (EmailException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String title = "您的账户信息已更新";
        String contents = "您的账号于 " + dateFormat.format(new Date()) + " 重置了密码，为了您的帐号安全，请立即登录 <a href='http://zd.kashuo.cn'>知店运营后台</a> 修改或联系管理员。";
        sendHtmlEmail(title, contents, "zhaoqingping@kashuo.com");
    }
}
