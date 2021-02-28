<%@include file="../header.jsp" %>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="${pageContext.request.contextPath}/index">Blue BumpKin</a>
      <!-- Navbar Right Menu-->
      <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">           
            <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>
            <li><a class="dropdown-item" href="login.jsp"><i class="fa fa-sign-out fa-lg"></i>Sign in</a></li>
            <li><a class="dropdown-item" href="#"><i class="fa fa-sign-out fa-lg"></i>Logout</a></li>
          </ul>
        </li>
      </ul>
    </header>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <ul class="app-menu">

      </ul>
    </aside>     
      <main class="app-content">
      <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">User</li>
          <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/UserServlet/new">New User</a></li>
        </ul>
      </div>
        <div class="col-md-12">
          <div class="tile">
            <h3 class="tile-title">List of Registered Users</h3>
            <table class="table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>                 
                  <c:forEach items="${users}" var="user" varStatus="status">
                    <tr class="table-info">
                      <td>${status.count}</td>
                      <td>${user.firstName}</td>
                      <td>${user.lastName}</td>
                      <td>${user.email}</td>
                      <td>
                          <a class="text text-info" href="edit?userId=<c:out value='${user.userId}' />">Edit</a>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <a class="text text-danger" href="delete?userId=<c:out value='${user.userId}' />">Delete</a>                     
                      </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
       </main>
    </body>
 <%@include file="../footer.jsp" %>
    