# SpringReactiveApp
`This project explain about how spring webflux work and how it better than normal blocking spring mvc.`
`This project is depend on SpringNonReactiveApp since current project call the sleep API to demonstration`
* Spring WebFlux in detail
    * There is one API in current project as "http://localhost:8080/reactiveService/1000"
    * In this API you can see the webclient calling the external service API which is non reactive API,sleep for time.
    * If you monitor the logs of API,You can see the thread count per request not getting more than 10.
        * In case of normal non reactive API,We have maximum 200 tomcat thread per request.
        
    * If you jemter file and run and see the result,Every request is getting successfull.
        * Spring reactive APP, handle load on the basis of (You can see the benefit in logs as thread are limited and see the thread incovation)
            * The key expected benefit of reactive and non-blocking is the ability to scale with a small, fixed number of threads and less memory
            * More info : https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-config
            
        * You can configure the  default the number of thread (Event loop thread),Default to number of processor.
        
