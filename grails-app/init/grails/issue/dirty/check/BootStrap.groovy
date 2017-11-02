package grails.issue.dirty.check

class BootStrap {

    def init = { servletContext ->
        new CityAddress(street: 'Street', city: 'City').save()
    }

    def destroy = {
    }
}
