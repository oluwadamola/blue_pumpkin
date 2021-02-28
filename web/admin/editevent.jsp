<%@include file="../header.jsp" %>
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="${pageContext.request.contextPath}/index.jsp">Blue BumpKin</a>
    </header>
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-edit"></i> Edit Event</h1>
          <p>Events</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">Event</li>
          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/EventServlet/list">List of Events</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="tile">
            <h3 class="tile-title">Edit Event</h3>
            <div class="tile-body">
            <form method="post" action="update">
                <div class="form-group">
                  <label class="control-label">Title</label>
                  <input class="form-control" type="text" value="#" name="firstName">
                </div>
                <div class="form-group">
                  <label class="control-label">Description</label>
                  <input class="form-control" type="text" value="#" name="lastName">
                </div>
                <div class="form-group">
                  <label class="control-label">Event Time</label>
                  <input class="form-control" type="email" value="#" name="email">
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