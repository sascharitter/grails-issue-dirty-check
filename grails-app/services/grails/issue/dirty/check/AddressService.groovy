package grails.issue.dirty.check

import grails.databinding.SimpleMapDataBindingSource
import grails.transaction.Transactional
import grails.web.databinding.GrailsWebDataBinder

@Transactional
class AddressService {

    GrailsWebDataBinder grailsWebDataBinder

    def bind(Long id, Map properties) {
        CityAddress address = CityAddress.get(id)
        grailsWebDataBinder.bind(address, new SimpleMapDataBindingSource(properties))
        address.save(flush: true)
    }

    void setStreet(Long id, String value) {
        CityAddress address = CityAddress.get(id)
        address.setStreet(value)
        address.save(flush: true)
    }

    void setCity(Long id, String value) {
        CityAddress address = CityAddress.get(id)
        address.setCity(value)
        address.save(flush: true)
    }
}
