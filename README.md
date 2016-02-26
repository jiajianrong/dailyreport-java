# dailyreport-java


<?xml version="1.0" encoding="UTF-8"?>
<web-app>


    <welcome-file-list>
        <welcome-file>task.html</welcome-file>
    </welcome-file-list>



	<servlet>
	    <servlet-name>WebApi</servlet-name>
	    <servlet-class>jr58.WebApi</servlet-class>
	</servlet>
	<servlet-mapping>
	    <servlet-name>WebApi</servlet-name>
	    <url-pattern>/api/*</url-pattern>
	</servlet-mapping>
</web-app>