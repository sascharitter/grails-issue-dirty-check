package grails.issue.dirty.check

import grails.transaction.Transactional

@Transactional
class AddressController {

    def index() {
        CityAddress address = CityAddress.get(1)

        render "Street: ${address.street}, City: ${address.city}"
    }

    def bind() {
        CityAddress address = CityAddress.get(1)
        bindData(address, params)
        address.save(flush: true)

        redirect action: 'index'
    }

    def street() {
        CityAddress address = CityAddress.get(1)
        address.setStreet(params.value)
        address.save(flush: true)

        redirect action: 'index'
    }

    def city() {
        CityAddress address = CityAddress.get(1)
        address.setCity(params.value)
        address.save(flush: true)

        redirect action: 'index'
    }
}
