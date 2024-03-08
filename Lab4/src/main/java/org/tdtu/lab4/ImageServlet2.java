package org.tdtu.lab4;

import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/image2")
public class ImageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        String filename = "/WEB-INF/resources/image2.jpg";
        File file = new File(ctx.getRealPath(filename));
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "attachment;filename=image2.jpg");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
