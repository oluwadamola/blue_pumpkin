<%@include file="../header.jsp" %>
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="index.html">Blue BumpKin</a>
    </header>
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-edit"></i> Create User</h1>
          <p>user registration</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">User</li>
          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/UserServlet/list">List Of Users</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="tile">
            <h3 class="tile-title">User Registration</h3>
            <div class="tile-body">
                <form method="post" action="${pageContext.request.contextPath}/UserServlet/add">
                <h4 class="text text-danger">${email_taken}</h4>
                <div class="form-group">
                  <label class="control-label">First Name</label>
                  <input class="form-control" type="text" placeholder="Enter full name" name="firstName">
                </div>
                <div class="form-group">
                  <label class="control-label">Last Name</label>
                  <input class="form-control" type="text" placeholder="Enter full name" name="lastName">
                </div>
                <div class="form-group">
                  <label class="control-label">Email</label>
                  <input class="form-control" type="email" placeholder="Enter email address" name="email">
                </div>
                <div class="form-group">
                  <label class="control-label">Password</label>
                  <input class="form-control" type="password" placeholder="Enter password" name="password">
                </div>
                <div class="form-group">
                  <label class="control-label">Phone Number</label>
                  <input class="form-control" type="tel" placeholder="Enter phonenumber" name="phoneNumber" >
                </div>
                <div class="form-group">
                  <label class="control-label">Address</label>
                  <textarea class="form-control" rows="4" placeholder="Enter your address" name="address"></textarea>
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
    <!-- Essential javascripts for application to work-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <!-- Google analytics script-->
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>
    <%@include file="../footer.jsp" %>