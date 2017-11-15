package hello;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerRevRepository {
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    CustomerRepository customerRepository;
    
    public Customer findCustomerRevision(Long id, int revision) {
    		AuditReader auditReader = AuditReaderFactory.get(entityManager);
    		
    		return auditReader.find(Customer.class, id, revision);
    }
}
