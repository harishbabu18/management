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
class ProductNameController {

    ProductNameService productNameService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productNameService.list(params), model:[productNameCount: productNameService.count()]
    }

    def show(Long id) {
        respond productNameService.get(id)
    }

    @Transactional
    def save(ProductName productName) {
        if (productName == null) {
            render status: NOT_FOUND
            return
        }
        if (productName.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productName.errors
            return
        }

        try {
            productNameService.save(productName)
        } catch (ValidationException e) {
            respond productName.errors
            return
        }

        respond productName, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ProductName productName) {
        if (productName == null) {
            render status: NOT_FOUND
            return
        }
        if (productName.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productName.errors
            return
        }

        try {
            productNameService.save(productName)
        } catch (ValidationException e) {
            respond productName.errors
            return
        }

        respond productName, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        productNameService.delete(id)

        render status: NO_CONTENT
    }
}
