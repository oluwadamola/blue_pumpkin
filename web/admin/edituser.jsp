<%@include file="../header.jsp" %>
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="${pageContext.request.contextPath}/index.jsp">Blue BumpKin</a>
    </header>
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-edit"></i> Edit User</h1>
          <p>user registration</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">User</li>
          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/UserServlet/list">List of Users</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="tile">
            <h3 class="tile-title">Edit User</h3>
            <div class="tile-body">
            <form method="post" action="update">
                <div class="form-group">
                  <label class="control-label">First Name</label>
                  <input class="form-control" type="text" value="<c:out value='${user.firstName}'/>" name="firstName">
                </div>
                <div class="form-group">
                  <label class="control-label">Last Name</label>
                  <input class="form-control" type="text" value="${user.lastName}" name="lastName">
                </div>
                <div class="form-group">
                  <label class="control-label">Email</label>
                  <input class="form-control" type="email" value="${user.email}" name="email">
                </div>
                <div class="form-group">
                  <label class="control-label">Password</label>
                  <input class="form-control" type="password" value="${user.password}" name="password">
                </div>
                <div class="form-group">
                  <label class="control-label">Phone Number</label>
                  <input class="form-control" type="tel" value="${user.phoneNumber}" name="phoneNumber" >
                </div>
                <div class="form-group">
                  <label class="control-label">Address</label>
                  <textarea class="form-control" rows="4" name="address">${user.address}</textarea>
                </div>
                <div class="tile-footer">
                    <input type="submit" class="btn btn-primary" value="Register"/>
                </div>
            </form>
            </div>
          </div>
        </div>
      </div>
    </main>
    <%@include file="../footer.jsp" %>