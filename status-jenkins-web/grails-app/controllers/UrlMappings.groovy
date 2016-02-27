class UrlMappings {

    static mappings = {
        "/statusJenkinsWeb"(controller: 'status', action: 'sendUrlAndPort')
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
