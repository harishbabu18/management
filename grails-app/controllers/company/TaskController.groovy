package company

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class TaskController {

    TaskService taskService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond taskService.list(params), model:[taskCount: taskService.count()]
    }

    def show(Long id) {
        respond taskService.get(id)
    }

    @Transactional
    def save(Task task) {
        if (task == null) {
            render status: NOT_FOUND
            return
        }
        if (task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond task.errors
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors
            return
        }

        respond task, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Task task) {
        if (task == null) {
            render status: NOT_FOUND
            return
        }
        if (task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond task.errors
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors
            return
        }

        respond task, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        taskService.delete(id)

        render status: NO_CONTENT
    }
}
