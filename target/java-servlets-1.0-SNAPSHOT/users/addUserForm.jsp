<%@ page import="pl.coderslab.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.coderslab.DAO.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>User Dashboard</title>
    <link href="<c:url value="/themes/css/sb-admin-2.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="<c:url value="/themes/css/sb-admin-2.css"/>" rel="stylesheet">
</head>

<body id="page-top">

<div id="wrapper">

    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <hr class="sidebar-divider my-0">

        <li class="nav-item active">
            <a class="nav-link" href="/user/list">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

    </ul>

    <div id="content-wrapper" class="d-flex flex-column">

        <div id="content">

            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

            </nav>
            <h1>Add New User</h1>
            <div class="container-fluid">
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800"><a href="/user/list">Dashboard</a></h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                </div>
                <form action="/users/addUser" method="post">
                    Username <input type="text" name="username"/>
                    Email <input type="text" name="email"/>
                    Password <input type="text" name="password"/>
                    <button type="submit">Submit</button>
                </form>

            </div>
            <%@ include file="/users/footer.jsp" %>
        </div>
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2021</span>
                </div>
            </div>
        </footer>

    </div>
</div>
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<script src="../../../startbootstrap-sb-admin-2-gh-pages/vendor/jquery/jquery.min.js"></script>
<script src="../../../startbootstrap-sb-admin-2-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../../startbootstrap-sb-admin-2-gh-pages/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="themes/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="../../../startbootstrap-sb-admin-2-gh-pages/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="themes/js/demo/chart-area-demo.js"></script>
<script src="themes/js/demo/chart-pie-demo.js"></script>

</body>

</html>