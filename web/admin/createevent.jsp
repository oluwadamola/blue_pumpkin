<%@include file="../header.jsp"%>
    <header class="app-header"><a class="app-header__logo" href="${pageContext.request.contextPath}/index">Blue BumpKin</a>
    </header>
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-edit"></i> Create Event</h1>
          <p>Create Event</p>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">Event</li>
          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/EventServlet/list">List Of Events</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="tile">
            <h3 class="tile-title">Create Event</h3>
            <div class="tile-body">
                <form method="post" action="${pageContext.request.contextPath}/EventServlet/add">
                <div class="form-group">
                  <label class="control-label">Title</label>
                  <input class="form-control" type="text" placeholder="Enter full name" name="title">
                </div>
                <div class="form-group">
                  <label class="control-label">Description</label>
                  <input class="form-control" type="text" placeholder="Enter full name" name="description">
                </div>
                <div class="form-group">
                  <label class="control-label">Event Time</label>
                  <input class="form-control" type="date" placeholder="Enter full name" name="date">
                </div>
                <div class="form-group">
                  <label class="control-label">Event Type</label>
                  <select name="eventtype" class="form-control">
                      <c:forEach items="${eventtypes}" var="eventtype">
                          <option value="${eventtype.eventTypeId}"><c:out value="${eventtype.eventName}"/></option>
                      </c:forEach>
                  </select>
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

<%@include file="../footer.jsp"%>