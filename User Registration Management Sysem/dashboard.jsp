<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% String type=(String) session.getAttribute("type"); if (type==null) { response.sendRedirect("index.html"); } else
        { %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Login again</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        </head>

        <body>
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-6 text-center mb-5">
                            <h2 class="heading-section">Login successfully!</h2>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-md-7 col-lg-5">
                            <div class="login-wrap p-4 p-md-5">
                                <div class="icon d-flex align-items-center justify-content-center">
                                    <span class="fa fa-user-o"></span>
                                </div>
                                <% if(type.equals("1")) { type="Student" ; } else { type="Admin" ; } %>
                                    <h3 class="text-center mb-4">Signed In <span>
                                            <%= type %>
                                        </span></h3>
                                    <form action="signout" class="login-form" method="get">
                                        <div class="form-group">
                                            <h3>Now you can see your Screen </h3>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit"
                                                class="form-control btn btn-primary rounded submit px-3">Sign
                                                Out</button>
                                        </div>
                                    </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <script src="js/jquery.min.js"></script>
            <script src="js/popper.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
        </body>

        </html>
        <% } %>