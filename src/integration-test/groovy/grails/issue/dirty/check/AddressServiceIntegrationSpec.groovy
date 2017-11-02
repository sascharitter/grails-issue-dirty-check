package grails.issue.dirty.check

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class AddressServiceIntegrationSpec extends Specification {

    def addressService

    void "Test setting property of superclass"() {
        when:
        addressService.setStreet(1, 'NewStreet')
        CityAddress cityAddress = CityAddress.get(1)

        then:
        cityAddress.street == 'NewStreet'
    }

    void "Test setting property of superclass using bind"() {
        when:
        addressService.bind(1, [street: 'NewStreet'])
        CityAddress cityAddress = CityAddress.get(1)

        then:
        cityAddress.street == 'NewStreet'
    }

    void "Test setting property of subclass"() {
        when:
        addressService.setCity(1, 'NewCity')
        CityAddress cityAddress = CityAddress.get(1)

        then:
        cityAddress.city == 'NewCity'
    }
}
