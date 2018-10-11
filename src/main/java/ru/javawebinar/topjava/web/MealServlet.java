package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("send to meals");
/*1.2.4 Вариант реализации:
из сервлета преобразуете еду в List<MealWithExceeded>;
кладете список в запрос (request.setAttribute);
делаете forward на jsp для отрисовки таблицы (при redirect атрибуты теряются).*/

//        MealsUtil mu = new MealsUtil();
//
//        request.setAttribute("meals", getAllMealsRecord);
//        request.setAttribute(String meals, );
        request.getRequestDispatcher("/meals.jsp").forward(request, response);


//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        request.setAttribute("name", "RoseIndia");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/servletTwo");
//        rd.forward(request, response);

//        response.sendRedirect("meals.jsp");
//        PrintWriter pw = resp.getWriter();
//        pw.println("<B>Список групп</B>");
//        pw.println("<table border=1>");
//        try {
//            List<Group> l = ManagementSystem.getInstance().getGroups();
//            for (Group gr : l) {
//                pw.println("<tr>");
//                pw.println("<td>" + gr.getGroupId() + "</td>");
//                pw.println("<td>" + gr.getNameGroup() + "</td>");
//                pw.println("<td>" + gr.getCurator() + "</td>");
//                pw.println("<td>" + gr.getSpeciality() + "</td>");
//                pw.println("</tr>");
//            }
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//        pw.println("</table>");

    }
}
