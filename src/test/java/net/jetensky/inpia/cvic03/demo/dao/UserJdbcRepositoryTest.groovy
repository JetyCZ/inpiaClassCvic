package net.jetensky.inpia.cvic03.demo.dao

import net.jetensky.inpia.cvic03.demo.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.transaction.Transactional

@SpringBootTest
@Transactional
class UserJdbcRepositoryTest extends Specification {
    @Autowired UserRepository userRepository
    @Autowired UserJdbcRepository userJdbcRep

    def "FindByEmail"() {
        def testEmail = "pavel.jetensky@seznam.cz"
        given:
        userRepository.save(new User(
                email: testEmail,
                passwordHash: "bla"
        ))
        println userRepository.findAll().size()
        expect:
        userJdbcRep.findByEmail(testEmail).size()==1
        userJdbcRep.findByEmail("bla").size()==0
    }
}
