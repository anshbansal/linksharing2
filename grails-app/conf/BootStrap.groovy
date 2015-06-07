class BootStrap {

    def bootstrapService
    def grailsApplication

    def init = { servletContext ->

        String defaultEmail = grailsApplication.config.defaults.email

        bootstrapService.createUser(defaultEmail).save()
    }
    def destroy = {
    }
}
