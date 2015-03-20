package br.com.saat.core;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {
	public JavaMailApp(){};
    
    public void enviaEmail(String email, String novaSenha, int tipo) throws AddressException, MessagingException {
	      //TIPO 
    	  //1 = Esqueci Senha
    	  
          Properties props = new Properties();
          
          /** Parâmetros de conexão com servidor Gmail */
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "465");

          Session session = Session.getDefaultInstance(props,
              new javax.mail.Authenticator() {
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication() 
                   {
                         return new PasswordAuthentication("naotebukconsertos@gmail.com", "naotebuk2014");
                   }
              });

          /** Ativa Debug para sessão */
          session.setDebug(true);

        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("naotebukconsertos@gmail.com")); //Remetente
        
        if(tipo == 1){
            
            message.setSubject("SAAT - Recuperação de Senha");//Assunto
            message.setText("Olá!/n/n"
            		+ "Sua nova senha é: " + novaSenha + "/n/n"
    				+ "Favor alterá-la o mais breve possível!/n/n"
    				+ "SAAT - Sistema de Acompanhamento de Atleta de Tênis");
        }
        
        /**Método para enviar a mensagem criada*/
        Address[] toUser = InternetAddress.parse(email);  //Destinatário(s)                  	
        message.setRecipients(Message.RecipientType.TO, toUser);
        
        Transport.send(message);

    }
}
