package org.tdtu.lab4;

import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Initialize with some products
        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 200.0));
        products.add(new Product(3, "Sản phẩm 3", 300.0)); // Product in Vietnamese
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                Product product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                if (product == null) {
                    out.println("{\"id\": \"404\", \"message\": \"Sản phẩm không tồn tại.\", \"data\": null}"); // Product not found in Vietnamese
                } else {
                    // Output product as JSON
                }
            } catch (NumberFormatException e) {
                out.println("{\"id\": \"400\", \"message\": \"ID sản phẩm không hợp lệ.\", \"data\": null}"); // Invalid product ID in Vietnamese
            }
        } else {
            // Output all products as JSON
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle adding a new product
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle updating a product's information
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle deleting a product
    }

    // Helper method to write JSON response
    private void writeJsonResponse(HttpServletResponse response, String id, String message, Object data) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("id", id);
        jsonResponse.addProperty("message", message);

        if (data != null) {
            JsonElement jsonData = new Gson().toJsonTree(data);
            jsonResponse.add("data", jsonData);
        } else {
            jsonResponse.add("data", JsonNull.INSTANCE);
        }

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }

    // Additional helper methods for processing requests can be added here
}
