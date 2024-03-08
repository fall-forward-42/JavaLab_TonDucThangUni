package org.tdtu.lab4;

import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/image1")
public class ImageServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        ServletContext ctx = getServletContext();
        InputStream in = ctx.getResourceAsStream("/WEB-INF/resources/image1.jpg");
        if (in == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
        } else {
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();
        }
    }
}
