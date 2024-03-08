package org.tdtu.lab4;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("file");
        if (fileName == null || fileName.isEmpty()) {
            response.getWriter().write("File not found");
            return;
        }

        ServletContext context = getServletContext();
        String filePath = "/WEB-INF/resources/" + fileName;
        File downloadFile = new File(context.getRealPath(filePath));
        if (!downloadFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }

        response.setContentType(context.getMimeType(filePath));
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        Files.copy(downloadFile.toPath(), response.getOutputStream());
    }
}
