package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CabBookingModel;

//SECOND LAYER
@WebServlet("/bookinglink")
public class CabBookingController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch the value from html page
	     String cab_type=req.getParameter("cabtype");
		int km=Integer.parseInt(req.getParameter("km"));
		int waitingTime=Integer.parseInt(req.getParameter("waiting"));
		
		//Create the object of that class to call the method
		CabBookingModel c1=new CabBookingModel();
		double totalAmount=c1.totalAmount(cab_type, km);
		double waitingCharges=c1.waitingCharges(cab_type, waitingTime);
		double finalBill=totalAmount+waitingCharges;
         if (finalBill!=0)
         {
        	 RequestDispatcher rd=req.getRequestDispatcher("getBill.jsp");
        	 req.setAttribute("totalamount",totalAmount);
        	 req.setAttribute("waitingcharges",waitingCharges);
        	 req.setAttribute("finalbill",finalBill);
			 rd.forward(req, resp);
		}
		
		
	}
    

}
