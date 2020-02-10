package company

import grails.gorm.services.Service

@Service(TicketSource)
interface TicketSourceService {

    TicketSource get(Serializable id)

    List<TicketSource> list(Map args)

    Long count()

    void delete(Serializable id)

    TicketSource save(TicketSource ticketSource)

}