package br.com.saat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.saat.enumeradores.Perfis;
import br.com.saat.model.CalendarDTO;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.Torneio;
import br.com.saat.model.negocio.TorneioNegocio;

import com.google.gson.Gson;

/**
 * Servlet implementation class CalendarJsonServlet
 */
@WebServlet("/CalendarJsonServlet")
public class CalendarJsonServlet extends Controller {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//Verifica autenticação usuário
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null || (usuarioLogado.getPerfil() != Perfis.Tecnico.getValor() && usuarioLogado.getPerfil() != Perfis.PreparadorFisico.getValor())){
			super.doPost(request, response, usuarioLogado, false, false);
			return;
		}
		
		TorneioNegocio negocio = new TorneioNegocio();
		List<Torneio> listaTorneios = null;
		try {
			listaTorneios = negocio.buscarTorneios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<CalendarDTO> listaCalendario = new ArrayList<CalendarDTO>();
        
        for (Torneio torneio : listaTorneios) {
			CalendarDTO calendar = new CalendarDTO();
			
			//FORMATAR A DATA PARA UMA STRING YYYY-MM-DD 
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dtInicial = new Date(); 
			Date dtFinal = new Date(); 
			
			dtInicial = torneio.getDtInicial();
			dtFinal = torneio.getDtFinal();
			
			String start = formatoData.format(dtInicial);
			String end = formatoData.format(dtFinal);
			
			//CONCATENAR TITULO
			String title = torneio.getNome() + " - Categoria " + torneio.getNomeCategoria();
			
			//CONCATENAR URL
			int finalizado = 1; //Fechado
			if (!torneio.isFlFinalizado()) {
				finalizado = 0; //Aberto
			}
			String url = "abrilModalTorneio(" + torneio.getIdTorneio() + "," + finalizado + ")";

			//SETAR                       
            calendar.setId(torneio.getIdTorneio());  
            calendar.setTitle(title);
            calendar.setStart(start);
            calendar.setEnd(end);
            calendar.setAllDay(Boolean.TRUE);
            calendar.setUrl(url);
            
            listaCalendario.add(calendar);
		}
         
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(listaCalendario));
          
        }
	}

