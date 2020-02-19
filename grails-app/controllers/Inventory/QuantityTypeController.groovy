package Inventory

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class QuantityTypeController {

    QuantityTypeService quantityTypeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond quantityTypeService.list(params), model:[quantityTypeCount: quantityTypeService.count()]
    }

    def show(Long id) {
        respond quantityTypeService.get(id)
    }

    @Transactional
    def save(QuantityType quantityType) {
        if (quantityType == null) {
            render status: NOT_FOUND
            return
        }
        if (quantityType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond quantityType.errors
            return
        }

        try {
            quantityTypeService.save(quantityType)
        } catch (ValidationException e) {
            respond quantityType.errors
            return
        }

        respond quantityType, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(QuantityType quantityType) {
        if (quantityType == null) {
            render status: NOT_FOUND
            return
        }
        if (quantityType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond quantityType.errors
            return
        }

        try {
            quantityTypeService.save(quantityType)
        } catch (ValidationException e) {
            respond quantityType.errors
            return
        }

        respond quantityType, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        quantityTypeService.delete(id)

        render status: NO_CONTENT
    }
}
