package com.sparta.mywebapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HashMap<String, String> users = transferUsersToMap("/Users/janjakovacevic/SpartaGlobal/Java EE/MyFirstWebApp/resources/users.txt");
        String path = getPath(validate(users, username, password));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        req.setAttribute("username", username);
        requestDispatcher.forward(req, resp);

    }

    private HashMap<String, String> transferUsersToMap(String filePath){
        HashMap<String, String> map = new HashMap<>();
        String lineRead;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            while((lineRead = bufferedReader.readLine()) != null){
                String[] loginPair = lineRead.split(",");
                map.put(loginPair[0].trim(), loginPair[1].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    private boolean validate(HashMap<String,String> users, String username, String password) {
        if(users.get(username) == null) return false;
        else{
            return users.get(username).equals(password);
        }
    }

    private String getPath(boolean valid){
        if(valid) return "WEB-INF/welcome.jsp";
        else {
            return "WEB-INF/404error.jsp";
        }
    }


}
