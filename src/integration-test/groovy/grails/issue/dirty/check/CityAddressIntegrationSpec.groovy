package grails.issue.dirty.check

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class CityAddressIntegrationSpec extends Specification {

    void "Test setting property of superclass"() {
        CityAddress cityAddress = new CityAddress(street: 'Street', city: 'City').save(flush: true)

        when:
        cityAddress.setStreet('NewStreet')

        then:
        cityAddress.hasChanged('street')
    }

    void "Test setting property of subclass"() {
        CityAddress cityAddress = new CityAddress(street: 'Street', city: 'City').save(flush: true)

        when:
        cityAddress.setCity('NewCity')

        then:
        cityAddress.hasChanged('city')
    }
}
