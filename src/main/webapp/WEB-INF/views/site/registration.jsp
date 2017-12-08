<%@include file="../layout/header.jsp"%>

    <title>Create an account</title>

<div class="row">
	<div class="col-lg-4 col-lg-offset-4">
	    <form:form method="POST" modelAttribute="registrationForm" class="form-signin">
	        <h2 class="form-signin-heading">Create your account</h2>
	        <spring:bind path="user.username">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="user.username" class="form-control" placeholder="Username"
	                            autofocus="true"></form:input>
	                <form:errors path="user.username"></form:errors>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="user.password">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="password" path="user.password" class="form-control" placeholder="Password"></form:input>
	                <form:errors path="user.password"></form:errors>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="user.confirmPassword">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="password" path="user.confirmPassword" class="form-control"
	                            placeholder="Confirm your password"></form:input>
	                <form:errors path="user.confirmPassword"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.firstname">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="libraryCard.firstname" class="form-control" placeholder="Firstname"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.firstname"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.lastname">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="libraryCard.lastname" class="form-control" placeholder="Lastname"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.lastname"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.course">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="libraryCard.course" class="form-control" placeholder="Course"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.course"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.admissionYear">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="libraryCard.admissionYear" class="form-control" placeholder="Admission Year"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.admissionYear"></form:errors>
	            </div>
	        </spring:bind>
	
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    	</form:form>
    </div>
</div>


<%@include file="../layout/footer.jsp"%>