package org.tdtu.lab4;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.*;
public class LoginServlet extends HttpServlet {

    private HashMap<String, String> accounts = new HashMap<String,String>();

    public void init()  {
        // Initialize the list of accounts. In a real scenario, this could be retrieved from a database.
        accounts.put("lehaitien", "422003");
        accounts.put("lehaidang", "422003");
        // Add more pre-built accounts as needed.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Redirect to index.jsp when accessed by GET
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Set content type to HTML
        response.setContentType("text/html");

        // Retrieve the username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       if (username != null && password != null && accounts.containsKey(username) && accounts.get(username).equals(password)) {
           request.setAttribute("notice", "Account was successful!");
        }else{
           request.setAttribute("notice", "Account was failed!");

       }


//
    }
}
