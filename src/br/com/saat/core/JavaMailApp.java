package br.com.saat.core;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.saat.model.Atleta;

public class JavaMailApp {
	public JavaMailApp(){};
    
    public void enviaEmail(String email, String novaSenha, int tipo) throws AddressException, MessagingException {
	      //TIPO 
    	  //1 = Esqueci Senha
    	  
          Properties props = new Properties();
          
          /** Parametros de conex„o com servidor Gmail */
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
                         return new PasswordAuthentication("saatnoreply@gmail.com", "s@@t_2o!5");
                   }
              });

          /** Ativa Debug para sess„o */
          session.setDebug(true);

        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("saatnoreply@gmail.com")); //Remetente
        
        if(tipo == 1){
            
            message.setSubject("SAAT - Senha do Usu·rio");//Assunto
            message.setText("Ol·!\n\n"
            		+ "Sua nova senha È: " + novaSenha + "\n\n"
    				+ "Favor alter·-la o mais breve possÌvel!\n\n"
    				+ "SAAT - Sistema de Acompanhamento de Atleta de TÍnis");
        }
        
        /**MÈtodo para enviar a mensagem criada*/
        Address[] toUser = InternetAddress.parse(email);  //Destinat√°rio(s)                  	
        message.setRecipients(Message.RecipientType.TO, toUser);
        
        Transport.send(message);

    }
    
    public void enviarEmailResponsavel(String destinatario, String assunto, String mensagem) throws AddressException, MessagingException{
    	Properties props = new Properties();
        
        /** Parametros de conexao com servidor Gmail */
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
                       return new PasswordAuthentication("saatnoreply@gmail.com", "s@@t_2o!5");
                 }
            });

        /** Ativa Debug para sess√£o */
        session.setDebug(true);

      
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("saatnoreply@gmail.com")); //Remetente          
      message.setSubject(assunto);//Assunto
      message.setText(mensagem,"utf-8","html");
  
      
      /**M√©todo para enviar a mensagem criada*/
      Address[] toUser = InternetAddress.parse(destinatario);  //Destinat√°rio(s)                  	
      message.setRecipients(Message.RecipientType.TO, toUser);
      
      Transport.send(message);
    }

	public void enviarDieta(Atleta atleta, String destino, String path) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
        
        /** Parametros de conex„o com servidor Gmail */
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
                       return new PasswordAuthentication("saatnoreply@gmail.com", "s@@t_2o!5");
                 }
            });

        /** Ativa Debug para sess„o */
        session.setDebug(true);

      
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("saatnoreply@gmail.com")); //Remetente
      
      message.setSubject("SAAT - RelatÛrio de dieta");//Assunto
      /**MÈtodo para enviar a mensagem criada*/
      Address[] toUser = InternetAddress.parse(destino);  //Destinat√°rio(s)                  	
      message.setRecipients(Message.RecipientType.TO, toUser);

      // cria a primeira parte da mensagem
      MimeBodyPart mbp1 = new MimeBodyPart();
      mbp1.setText("Ol·!\n\n"
    		  + "Segue em anexo a dieta atual no atleta " + atleta.getNome() + ", realizada pela Nutricionista do Clube Curitibano. \n\n"
    		  + "SAAT - Sistema de Acompanhamento de Atleta de TÍnis");
      
      // cria a segunda parte da mensage
      MimeBodyPart mbp2 = new MimeBodyPart();

      // anexa o arquivo na mensagem
      FileDataSource fds = new FileDataSource(path);
      mbp2.setDataHandler(new DataHandler(fds));
      mbp2.setFileName(fds.getName());

      // cria a Multipart
      Multipart mp = new MimeMultipart();
      mp.addBodyPart(mbp1);
      mp.addBodyPart(mbp2);

      // adiciona a Multipart na mensagem
      message.setContent(mp);
      
      // envia a mensagem
      Transport.send(message);

	}
}
