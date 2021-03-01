<%@include file="header.jsp" %>
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="${pageContext.request.contextPath}/index">Blue BumpKin</a>
      <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
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
        <li><a class="app-menu__item active" href="index.html"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Dashboard</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-users"></i><span class="app-menu__label">Manage User</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
            <li><a class="treeview-item" href="UserServlet/new"><i class="icon fa fa-user"></i> Create User</a></li>
            <li><a class="treeview-item" href="UserServlet/list"><i class="icon fa fa-users"></i> List Users</a></li>
            <li><a class="treeview-item" href="EventServlet/new"><i class="icon fa fa-th-list"></i> Create Events</a></li>
            <li><a class="treeview-item" href="EventServlet/list"><i class="icon fa fa-th-list"></i> List Events</a></li>
          </ul>
        </li>
      </ul>
    </aside>
    <main class="app-content">
      <div class="row">

        <div class="col-md-6 col-lg-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-thumbs-o-up fa-3x"></i>
            <div class="info">
              <h4>Games</h4>
              <p><b>${gamecount}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-users fa-3x"></i>
            <div class="info">
              <h4>Meeting</h4>
              <p><b>${meetingcount}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-6">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-star fa-3x"></i>
            <div class="info">
              <h4>Competition</h4>
              <p><b>${competitioncount}</b></p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Games</h3>
            <div class="embed-responsive embed-responsive embed-responsive-12by9">
                <dl>
                    <dt>Title</dt>
                    <dd>Description of the game</dd>
                    <dd>10.34pm</dd>
                </dl>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Meeting</h3>
            <div class="embed-responsive embed-responsive-12by9">
                <dl>
                    <dt>Title</dt>
                    <dd>Description of the game</dd>
                    <dd>10.34pm</dd>
                </dl>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Games</h3>
            <div class="embed-responsive embed-responsive embed-responsive-12by9">
                <dl>
                    <dt>Title</dt>
                    <dd>Description of the game</dd>
                    <dd>10.34pm</dd>
                </dl>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Meeting</h3>
            <div class="embed-responsive embed-responsive-12by9">
                <dl>
                    <dt>Title</dt>
                    <dd>Description of the game</dd>
                    <dd>10.34pm</dd>
                </dl>
            </div>
          </div>
        </div>
      </div>
    </main>
<%@include file="footer.jsp" %>