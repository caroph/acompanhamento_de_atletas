//package br.com.saat.core;
//
//import java.util.Properties;
//
//import javax.mail.Address;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import br.com.kmproaudio.model.Contato;
//
//public class JavaMailApp {
//	public JavaMailApp(){};
//    
//    public void enviaEmail(Contato contato, Integer tipo) {
//    	  String email;
//    	  
//          Properties props = new Properties();
//          
//          /** Parâmetros de conexão com servidor Gmail */
//          props.put("mail.smtp.host", "smtp.gmail.com");
//          props.put("mail.smtp.socketFactory.port", "465");
//          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//          props.put("mail.smtp.auth", "true");
//          props.put("mail.smtp.port", "465");
//
//          Session session = Session.getDefaultInstance(props,
//              new javax.mail.Authenticator() {
//                   @Override
//                   protected PasswordAuthentication getPasswordAuthentication() 
//                   {
//                         return new PasswordAuthentication("naotebukconsertos@gmail.com", "naotebuk2014");
//                   }
//              });
//
//          /** Ativa Debug para sessão */
//          session.setDebug(true);
//
//          try {
//
//                Message message = new MimeMessage(session);
//                message.setFrom(new InternetAddress("naotebukconsertos@gmail.com")); //Remetente
//                
//                if(tipo == 0){
//                	email = contato.getEmail();                
//                    
//                    message.setSubject("Contato KM Pro Audio");//Assunto
//                    message.setText("Olá, " + contato.getNome() + "!\n\n"
//                    		+ "Agradecemos seu contato.\n"
//                    		+ "Em breve lhe retornaremos.\n\n"
//                    		+ "KM Pro Audio");
//                }else if(tipo == 1){
//                	email = "jchaerki@gmail.com";            
//                    
//                    message.setSubject("Contato Site KM Pro Audio");//Assunto
//                    message.setText("Olá!\n\n"
//                    		+ "Novo contato realizado via site, seguem dados:\n"
//                    		+ "Nome Cliente: " + contato.getNome() + "\n"
//                    		+ "Telefone: " + contato.getTelefone() + "\n"
//                    		+ "Email: " + contato.getEmail() + "\n"
//                    		+ "Mensagem: " + contato.getMensagem() + "\n\n"
//                    		+ "Cliente aguarda seu retorno.");
//                }else{
//                	email = "jchaerki@gmail.com";            
//                    
//                    message.setSubject("Fique por dentro - Site KM Pro Audio");//Assunto
//                    message.setText("Olá!\n\n"
//                    		+ "Um novo cliente quer receber as notícia, novidades e promoções da KM Pro Audio:\n"
//                    		+ "Nome Cliente: " + contato.getNome() + "\n"
//                    		+ "Email: " + contato.getEmail() + "\n\n"                    		
//                    		+ "Cliente aguarda seus emails!");
//                }
//                
//                /**Método para enviar a mensagem criada*/
//                Address[] toUser = InternetAddress.parse(email);  //Destinatário(s)                  	
//                message.setRecipients(Message.RecipientType.TO, toUser);
//                
//                Transport.send(message);
//
//           } catch (Exception e) {
//                throw new RuntimeException(e);
//          }
//    }
//}
