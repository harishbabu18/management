package company

import grails.gorm.services.Service

@Service(TicketStatusType)
interface TicketStatusTypeService {

    TicketStatusType get(Serializable id)

    List<TicketStatusType> list(Map args)

    Long count()

    void delete(Serializable id)

    TicketStatusType save(TicketStatusType ticketStatusType)

}